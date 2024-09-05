/*
 * Licensed to the Nervousync Studio (NSYC) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.nervousync.brain.schemas.distribute;

import org.jetbrains.annotations.NotNull;
import org.nervousync.brain.commons.BrainCommons;
import org.nervousync.brain.configs.schema.impl.DistributeSchemaConfig;
import org.nervousync.brain.configs.server.ServerInfo;
import org.nervousync.brain.defines.TableDefine;
import org.nervousync.brain.dialects.DialectFactory;
import org.nervousync.brain.dialects.distribute.DistributeClient;
import org.nervousync.brain.dialects.distribute.DistributeDialect;
import org.nervousync.brain.dialects.distribute.Operator;
import org.nervousync.brain.enumerations.ddl.DDLType;
import org.nervousync.brain.enumerations.ddl.DropOption;
import org.nervousync.brain.enumerations.query.LockOption;
import org.nervousync.brain.query.QueryInfo;
import org.nervousync.brain.query.condition.Condition;
import org.nervousync.brain.schemas.BaseSchema;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.*;

/**
 * <h2 class="en-US">Distribute data source implementation class</h2>
 * <h2 class="zh-CN">分布式数据源实现类</h2>
 *
 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
 * @version $Revision: 1.0.0 $ $Date: Feb 18, 2019 10:38:52 $
 */
public final class DistributeSchema extends BaseSchema implements DistributeSchemaMBean {

	/**
	 * <span class="en-US">Using SSL when connect to server</span>
	 * <span class="zh-CN">使用SSL连接</span>
	 */
	private final boolean useSsl;
	/**
	 * <span class="en-US">Database main/writable server info</span>
	 * <span class="zh-CN">数据库主服务器（写入服务器）</span>
	 */
	private final ServerInfo serverInfo;
	/**
	 * <span class="en-US">Database secondary/readable server info list</span>
	 * <span class="zh-CN">数据库从服务器列表（只读服务器）</span>
	 */
	private final List<ServerInfo> serverList;
	/**
	 * <span class="en-US">Distributed database client implementation class</span>
	 * <span class="zh-CN">分布式数据库客户端实现类</span>
	 */
	private final DistributeClient distributeClient;
	/**
	 * <span class="en-US">The distributed database client operator instance object used by the current thread</span>
	 * <span class="zh-CN">当前线程使用的分布式数据库客户端操作器实例对象</span>
	 */
	private final ThreadLocal<Operator> operatorThreadLocal = new ThreadLocal<>();

	/**
	 * <h4 class="en-US">Constructor method for distribute data source implementation class</h4>
	 * <h4 class="zh-CN">分布式数据源实现类的构造方法</h4>
	 *
	 * @param schemaConfig <span class="en-US">Distribute data source configure information</span>
	 *                     <span class="zh-CN">分布式数据源配置信息</span>
	 * @throws SQLException <span class="en-US">Database server information not found or sharding configuration error</span>
	 *                      <span class="zh-CN">数据库服务器信息未找到或分片配置出错</span>
	 */
	public DistributeSchema(@NotNull final DistributeSchemaConfig schemaConfig) throws Exception {
		super(schemaConfig);
		this.useSsl = schemaConfig.isUseSsl();
		List<ServerInfo> serverList =
				(schemaConfig.getServerList() == null) ? new ArrayList<>() : schemaConfig.getServerList();
		serverList.sort((o1, o2) -> Integer.compare(o2.getServerLevel(), o1.getServerLevel()));
		if (serverList.isEmpty()) {
			throw new SQLException("");
		}
		this.serverList = serverList;
		this.serverInfo = serverList.get(0);
		this.distributeClient = DialectFactory.retrieve(schemaConfig.getDialectName())
				.unwrap(DistributeDialect.class)
				.newClient(schemaConfig.getServerList(), this.authentication, this.trustStore,
						this.getLowQueryTimeout(), this.useSsl, this.getValidateTimeout(), this.getConnectTimeout());
		this.initSharding(this.shardingDefault);
	}

	@Override
	public void initialize() {
	}

	@Override
	public void beginTransactional() throws Exception {
		if (this.operatorThreadLocal.get() == null) {
			Operator operator = this.distributeClient.newOperator();
			if (this.txConfig.get() != null) {
				operator.beginTransactional(this.txConfig.get());
			}
			this.operatorThreadLocal.set(operator);
		}
	}

	@Override
	public void rollback() throws Exception {
		if (this.txConfig.get() != null) {
			this.operatorThreadLocal.get().rollback(this.txConfig.get());
		}
	}

	@Override
	public void commit() throws Exception {
		if (this.txConfig.get() != null) {
			this.operatorThreadLocal.get().commit(this.txConfig.get());
		}
	}

	@Override
	public void truncateTables() throws Exception {
		this.operatorThreadLocal.get().truncateTables();
	}

	@Override
	public void truncateTable(@NotNull final TableDefine tableDefine) throws Exception {
		this.operatorThreadLocal.get().truncateTable(tableDefine);
	}

	@Override
	public void dropTables(final DropOption dropOption) throws Exception {
		this.operatorThreadLocal.get().dropTables(dropOption);
	}

	@Override
	public void dropTable(@NotNull final TableDefine tableDefine, @NotNull final DropOption dropOption)
			throws Exception {
		this.operatorThreadLocal.get().dropTable(tableDefine, dropOption);
	}

	@Override
	public Map<String, Serializable> insert(@NotNull final TableDefine tableDefine,
	                                        @NotNull final Map<String, Serializable> dataMap) throws Exception {
		return this.operatorThreadLocal.get().insert(tableDefine, dataMap);
	}

	@Override
	public Map<String, String> retrieve(@NotNull final TableDefine tableDefine, final String columns,
	                                    @NotNull final Map<String, Serializable> filterMap,
	                                    final boolean forUpdate, final LockOption lockOption) throws Exception {
		return this.operatorThreadLocal.get().retrieve(tableDefine, columns, filterMap, forUpdate, lockOption);
	}

	@Override
	public int update(@NotNull final TableDefine tableDefine, @NotNull final Map<String, Serializable> dataMap,
	                  @NotNull final Map<String, Serializable> filterMap) throws Exception {
		return this.operatorThreadLocal.get().update(tableDefine, dataMap, filterMap);
	}

	@Override
	public int delete(@NotNull final TableDefine tableDefine, @NotNull final Map<String, Serializable> filterMap)
			throws Exception {
		return this.operatorThreadLocal.get().delete(tableDefine, filterMap);
	}

	@Override
	public List<Map<String, String>> query(@NotNull final QueryInfo queryInfo) throws Exception {
		return this.operatorThreadLocal.get().query(queryInfo);
	}

	@Override
	public List<Map<String, String>> queryForUpdate(@NotNull final TableDefine tableDefine,
	                                                final List<Condition> conditionList, final LockOption lockOption)
			throws Exception {
		return this.operatorThreadLocal.get().queryForUpdate(tableDefine, conditionList, lockOption);
	}

	@Override
	protected void initSharding(final String shardingKey) throws SQLException {
		this.distributeClient.initSharding(shardingKey);
	}

	@Override
	protected void initTable(@NotNull final DDLType ddlType, @NotNull final TableDefine tableDefine, final String shardingDatabase) throws Exception {
		this.operatorThreadLocal.get().initTable(ddlType, tableDefine, shardingDatabase);
	}

	@Override
	protected void clearTransactional() {
		this.operatorThreadLocal.remove();
	}

	@Override
	public void close() throws IOException {
		this.distributeClient.close();
	}

	@Override
	public String getServerInfo() {
		StringBuilder stringBuilder = new StringBuilder();
		this.serverList.forEach(serverInfo ->
				stringBuilder.append(BrainCommons.DEFAULT_SPLIT_CHARACTER).append(serverInfo.info()));
		return stringBuilder.substring(BrainCommons.DEFAULT_SPLIT_CHARACTER.length());
	}

	@Override
	public String getMainServer() {
		return this.serverInfo.info();
	}

	@Override
	public boolean isUseSsl() {
		return this.useSsl;
	}

	@Override
	public void configRetry(final int retryCount, final long retryPeriod) {
		this.distributeClient.configRetry(retryCount, retryPeriod);
	}
}
