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

package org.nervousync.brain.defines;

import jakarta.xml.bind.annotation.*;
import org.nervousync.beans.core.BeanObject;

import java.io.Serial;
import java.util.List;

/**
 * <h2 class="en-US">Column index configure information</h2>
 * <h2 class="zh-CN">列索引配置信息</h2>
 *
 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
 * @version $Revision: 1.0.0 $ $Date: Nov 4, 2020 16:33:28 $
 */
@XmlType(name = "index_define", namespace = "https://nervousync.org/schemas/database")
@XmlRootElement(name = "index_define", namespace = "https://nervousync.org/schemas/database")
@XmlAccessorType(XmlAccessType.NONE)
public final class IndexDefine extends BeanObject {

	/**
	 * <span class="en-US">Serial version UID</span>
	 * <span class="zh-CN">序列化UID</span>
	 */
	@Serial
	private static final long serialVersionUID = -5837891022386585126L;

	/**
	 * <span class="en-US">Index name</span>
	 * <span class="zh-CN">索引名称</span>
	 */
	@XmlElement(name = "index_name")
	private String indexName;
	/**
	 * <span class="en-US">Index contains column name list</span>
	 * <span class="zh-CN">索引包含的列名列表</span>
	 */
	@XmlElement(name = "column_name")
	@XmlElementWrapper(name = "column_list")
	private List<String> columnList;
	/**
	 * <span class="en-US">Index is unique</span>
	 * <span class="zh-CN">索引是唯一索引</span>
	 */
	@XmlElement
	private boolean unique;

	/**
	 * <h4 class="en-US">Constructor method for column index configure information</h4>
	 * <h4 class="zh-CN">列索引配置信息的构造方法</h4>
	 */
	public IndexDefine() {
	}

	/**
	 * <h4 class="en-US">Getter method for index name</h4>
	 * <h4 class="zh-CN">索引名称的Getter方法</h4>
	 *
	 * @return <span class="en-US">Index name</span>
	 * <span class="zh-CN">索引名称</span>
	 */
	public String getIndexName() {
		return this.indexName;
	}

	/**
	 * <h4 class="en-US">Setter method for index name</h4>
	 * <h4 class="zh-CN">索引名称的Setter方法</h4>
	 *
	 * @param indexName <span class="en-US">Index name</span>
	 *                  <span class="zh-CN">索引名称</span>
	 */
	public void setIndexName(String indexName) {
		this.indexName = indexName;
	}

	/**
	 * <h4 class="en-US">Getter method for index contains column name list</h4>
	 * <h4 class="zh-CN">索引包含的列名列表的Getter方法</h4>
	 *
	 * @return <span class="en-US">Index contains column name list</span>
	 * <span class="zh-CN">索引包含的列名列表</span>
	 */
	public List<String> getColumnList() {
		return this.columnList;
	}

	/**
	 * <h4 class="en-US">Setter method for index contains column name list</h4>
	 * <h4 class="zh-CN">索引包含的列名列表的Setter方法</h4>
	 *
	 * @param columnList <span class="en-US">Index contains column name list</span>
	 *                   <span class="zh-CN">索引包含的列名列表</span>
	 */
	public void setColumnList(List<String> columnList) {
		this.columnList = columnList;
	}

	/**
	 * <h4 class="en-US">Getter method for index is unique</h4>
	 * <h4 class="zh-CN">索引是唯一索引的Getter方法</h4>
	 *
	 * @return <span class="en-US">Index is unique</span>
	 * <span class="zh-CN">索引是唯一索引</span>
	 */
	public boolean isUnique() {
		return this.unique;
	}

	/**
	 * <h4 class="en-US">Setter method for index is unique</h4>
	 * <h4 class="zh-CN">索引是唯一索引的Setter方法</h4>
	 *
	 * @param unique <span class="en-US">Index is unique</span>
	 *               <span class="zh-CN">索引是唯一索引</span>
	 */
	public void setUnique(boolean unique) {
		this.unique = unique;
	}
}
