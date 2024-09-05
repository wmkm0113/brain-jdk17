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

package org.nervousync.brain.configs.schema.impl;

import jakarta.xml.bind.annotation.*;
import org.nervousync.brain.commons.BrainCommons;
import org.nervousync.brain.configs.schema.SchemaConfig;
import org.nervousync.brain.configs.server.ServerInfo;
import org.nervousync.commons.Globals;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

/**
 * <h2 class="en-US">Relational data source configuration information</h2>
 * <h2 class="zh-CN">关系型数据源配置信息</h2>
 *
 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
 * @version $Revision : 1.0 $ $Date: Jul 12, 2020 16:42:35 $
 */
@XmlType(name = "jdbc_schema", namespace = "https://nervousync.org/schemas/database")
@XmlRootElement(name = "jdbc_schema", namespace = "https://nervousync.org/schemas/database")
@XmlAccessorType(XmlAccessType.NONE)
public final class JdbcSchemaConfig extends SchemaConfig {

	/**
	 * <span class="en-US">Serial version UID</span>
	 * <span class="zh-CN">序列化UID</span>
	 */
	@Serial
	private static final long serialVersionUID = -553668725998373198L;

	/**
	 * <span class="en-US">Using server array</span>
	 * <span class="zh-CN">使用服务器组</span>
	 */
	@XmlElement(name = "server_array")
	private boolean serverArray = Boolean.FALSE;
	/**
	 * <span class="en-US">Database server info list</span>
	 * <span class="zh-CN">数据库服务器列表</span>
	 */
	@XmlElementWrapper(name = "server_list")
	@XmlElement(name = "server_info")
	private List<ServerInfo> serverList = new ArrayList<>();
	/**
	 * <span class="en-US">JDBC connection url</span>
	 * <span class="zh-CN">JDBC连接字符串</span>
	 */
	@XmlElement(name = "jdbc_url")
	private String jdbcUrl = Globals.DEFAULT_VALUE_STRING;
	/**
	 * <span class="en-US">Maximum number of connection retries</span>
	 * <span class="zh-CN">连接最大重试次数</span>
	 */
	@XmlElement(name = "retry_count")
	private int retryCount = BrainCommons.DEFAULT_RETRY_COUNT;
	/**
	 * <span class="en-US">Retry count if obtains connection has error</span>
	 * <span class="zh-CN">获取连接的重试次数</span>
	 */
	@XmlElement(name = "retry_period")
	private long retryPeriod = BrainCommons.DEFAULT_RETRY_PERIOD;
	/**
	 * <span class="en-US">Maximum size of prepared statement</span>
	 * <span class="zh-CN">查询分析器的最大缓存结果</span>
	 */
	private int cachedLimitSize = Globals.DEFAULT_VALUE_INT;
	/**
	 * <span class="en-US">Check connection validate when obtains database connection</span>
	 * <span class="zh-CN">在获取连接时检查连接是否有效</span>
	 */
	private boolean testOnBorrow = Boolean.FALSE;
	/**
	 * <span class="en-US">Check connection validate when return database connection</span>
	 * <span class="zh-CN">在归还连接时检查连接是否有效</span>
	 */
	private boolean testOnReturn = Boolean.FALSE;

	/**
	 * <h4 class="en-US">Constructor method for relational data source configuration information</h4>
	 * <h4 class="zh-CN">关系型数据源配置信息的构造方法</h4>
	 */
	public JdbcSchemaConfig() {
	}

	/**
	 * <h4 class="en-US">Getter method for using server array</h4>
	 * <h4 class="zh-CN">使用服务器组的Getter方法</h4>
	 *
	 * @return <span class="en-US">Using server array</span>
	 * <span class="zh-CN">使用服务器组</span>
	 */
	public boolean isServerArray() {
		return this.serverArray;
	}

	/**
	 * <h4 class="en-US">Setter method for using server array</h4>
	 * <h4 class="zh-CN">使用服务器组的Setter方法</h4>
	 *
	 * @param serverArray <span class="en-US">Using server array</span>
	 *                    <span class="zh-CN">使用服务器组</span>
	 */
	public void setServerArray(final boolean serverArray) {
		this.serverArray = serverArray;
	}

	/**
	 * <h4 class="en-US">Getter method for database server info list</h4>
	 * <h4 class="zh-CN">数据库服务器列表的Getter方法</h4>
	 *
	 * @return <span class="en-US">Database server info list</span>
	 * <span class="zh-CN">数据库服务器列表</span>
	 */
	public List<ServerInfo> getServerList() {
		return this.serverList;
	}

	/**
	 * <h4 class="en-US">Setter method for database server info list</h4>
	 * <h4 class="zh-CN">数据库服务器列表的Setter方法</h4>
	 *
	 * @param serverList <span class="en-US">Database server info list</span>
	 *                   <span class="zh-CN">数据库服务器列表</span>
	 */
	public void setServerList(final List<ServerInfo> serverList) {
		this.serverList = serverList;
	}

	/**
	 * <h4 class="en-US">Getter method for JDBC connection url</h4>
	 * <h4 class="zh-CN">JDBC连接字符串的Getter方法</h4>
	 *
	 * @return <span class="en-US">JDBC connection url</span>
	 * <span class="zh-CN">JDBC连接字符串</span>
	 */
	public String getJdbcUrl() {
		return this.jdbcUrl;
	}

	/**
	 * <h4 class="en-US">Setter method for JDBC connection url</h4>
	 * <h4 class="zh-CN">JDBC连接字符串的Setter方法</h4>
	 *
	 * @param jdbcUrl <span class="en-US">JDBC connection url</span>
	 *                <span class="zh-CN">JDBC连接字符串</span>
	 */
	public void setJdbcUrl(final String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}

	/**
	 * <h4 class="en-US">Getter method for maximum number of connection retries</h4>
	 * <h4 class="zh-CN">连接最大重试次数的Getter方法</h4>
	 *
	 * @return <span class="en-US">Maximum number of connection retries</span>
	 * <span class="zh-CN">连接最大重试次数</span>
	 */
	public int getRetryCount() {
		return this.retryCount;
	}

	/**
	 * <h4 class="en-US">Setter method for maximum number of connection retries</h4>
	 * <h4 class="zh-CN">连接最大重试次数的Setter方法</h4>
	 *
	 * @param retryCount <span class="en-US">Maximum number of connection retries</span>
	 *                   <span class="zh-CN">连接最大重试次数</span>
	 */
	public void setRetryCount(final int retryCount) {
		this.retryCount = retryCount;
	}

	/**
	 * <h4 class="en-US">Getter method for retry count if obtains connection has error</h4>
	 * <h4 class="zh-CN">获取连接的重试次数的Getter方法</h4>
	 *
	 * @return <span class="en-US">Retry count if obtains connection has error</span>
	 * <span class="zh-CN">获取连接的重试次数</span>
	 */
	public long getRetryPeriod() {
		return this.retryPeriod;
	}

	/**
	 * <h4 class="en-US">Setter method for retry count if obtains connection has error</h4>
	 * <h4 class="zh-CN">获取连接的重试次数的Setter方法</h4>
	 *
	 * @param retryPeriod <span class="en-US">Retry count if obtains connection has error</span>
	 *                    <span class="zh-CN">获取连接的重试次数</span>
	 */
	public void setRetryPeriod(final long retryPeriod) {
		this.retryPeriod = retryPeriod;
	}

	/**
	 * <h4 class="en-US">Getter method for maximum size of prepared statement</h4>
	 * <h4 class="zh-CN">查询分析器的最大缓存结果的Getter方法</h4>
	 *
	 * @return <span class="en-US">Maximum size of prepared statement</span>
	 * <span class="zh-CN">查询分析器的最大缓存结果</span>
	 */
	public int getCachedLimitSize() {
		return this.cachedLimitSize;
	}

	/**
	 * <h4 class="en-US">Setter method for maximum size of prepared statement</h4>
	 * <h4 class="zh-CN">查询分析器的最大缓存结果的Setter方法</h4>
	 *
	 * @param cachedLimitSize <span class="en-US">Maximum size of prepared statement</span>
	 *                        <span class="zh-CN">查询分析器的最大缓存结果</span>
	 */
	public void setCachedLimitSize(final int cachedLimitSize) {
		this.cachedLimitSize = cachedLimitSize;
	}

	/**
	 * <h4 class="en-US">Getter method for check connection validate when obtains database connection</h4>
	 * <h4 class="zh-CN">在获取连接时检查连接是否有效的Getter方法</h4>
	 *
	 * @return <span class="en-US">Check connection validate when obtains database connection</span>
	 * <span class="zh-CN">在获取连接时检查连接是否有效</span>
	 */
	public boolean isTestOnBorrow() {
		return this.testOnBorrow;
	}

	/**
	 * <h4 class="en-US">Setter method for check connection validate when obtains database connection</h4>
	 * <h4 class="zh-CN">在获取连接时检查连接是否有效的Setter方法</h4>
	 *
	 * @param testOnBorrow <span class="en-US">Check connection validate when obtains database connection</span>
	 *                     <span class="zh-CN">在获取连接时检查连接是否有效</span>
	 */
	public void setTestOnBorrow(final boolean testOnBorrow) {
		this.testOnBorrow = testOnBorrow;
	}

	/**
	 * <h4 class="en-US">Getter method for check connection validate when return database connection</h4>
	 * <h4 class="zh-CN">在归还连接时检查连接是否有效的Getter方法</h4>
	 *
	 * @return <span class="en-US">Check connection validate when return database connection</span>
	 * <span class="zh-CN">在归还连接时检查连接是否有效</span>
	 */
	public boolean isTestOnReturn() {
		return this.testOnReturn;
	}

	/**
	 * <h4 class="en-US">Setter method for check connection validate when return database connection</h4>
	 * <h4 class="zh-CN">在归还连接时检查连接是否有效的Setter方法</h4>
	 *
	 * @param testOnReturn <span class="en-US">Check connection validate when return database connection</span>
	 *                     <span class="zh-CN">在归还连接时检查连接是否有效</span>
	 */
	public void setTestOnReturn(final boolean testOnReturn) {
		this.testOnReturn = testOnReturn;
	}
}
