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

package org.nervousync.brain.configs.server;

import jakarta.xml.bind.annotation.*;
import org.nervousync.beans.core.BeanObject;
import org.nervousync.commons.Globals;
import org.nervousync.utils.IPUtils;

import java.io.Serial;

/**
 * <h2 class="en-US">Server configuration information</h2>
 * <h2 class="zh-CN">服务器配置信息</h2>
 *
 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
 * @version $Revision : 1.0 $ $Date: Dec 12, 2020 09:27:39 $
 */
@XmlType(name = "server_info", namespace = "https://nervousync.org/schemas/database")
@XmlRootElement(name = "server_info", namespace = "https://nervousync.org/schemas/database")
@XmlAccessorType(XmlAccessType.NONE)
public final class ServerInfo extends BeanObject {

	/**
	 * <span class="en-US">Serial version UID</span>
	 * <span class="zh-CN">序列化UID</span>
	 */
	@Serial
	private static final long serialVersionUID = -5393915530015766873L;

	/**
	 * <span class="en-US">Server address</span>
	 * <span class="zh-CN">服务器地址</span>
	 */
	@XmlElement(name = "server_address")
	private String serverAddress = Globals.DEFAULT_VALUE_STRING;
	/**
	 * <span class="en-US">Server port number</span>
	 * <span class="zh-CN">服务器端口号</span>
	 */
	@XmlElement(name = "server_port")
	private int serverPort = Globals.DEFAULT_VALUE_INT;
	/**
	 * <span class="en-US">Server level</span>
	 * <span class="zh-CN">服务器等级</span>
	 */
	@XmlElement(name = "server_level")
	private int serverLevel = Globals.DEFAULT_VALUE_INT;

	/**
	 * <h4 class="en-US">Constructor method for server configuration information</h4>
	 * <h4 class="zh-CN">服务器配置信息的构造方法</h4>
	 */
	public ServerInfo() {
	}

	/**
	 * <h4 class="en-US">Getter method for server address</h4>
	 * <h4 class="zh-CN">服务器地址的Getter方法</h4>
	 *
	 * @return <span class="en-US">Server address</span>
	 * <span class="zh-CN">服务器地址</span>
	 */
	public String getServerAddress() {
		return this.serverAddress;
	}

	/**
	 * <h4 class="en-US">Setter method for server address</h4>
	 * <h4 class="zh-CN">服务器地址的Setter方法</h4>
	 *
	 * @param serverAddress <span class="en-US">Server address</span>
	 *                      <span class="zh-CN">服务器地址</span>
	 */
	public void setServerAddress(String serverAddress) {
		this.serverAddress = serverAddress;
	}

	/**
	 * <h4 class="en-US">Getter method for server port number</h4>
	 * <h4 class="zh-CN">服务器端口号的Getter方法</h4>
	 *
	 * @return <span class="en-US">Server port number</span>
	 * <span class="zh-CN">服务器端口号</span>
	 */
	public int getServerPort() {
		return this.serverPort;
	}

	/**
	 * <h4 class="en-US">Setter method for server port number</h4>
	 * <h4 class="zh-CN">服务器端口号的Setter方法</h4>
	 *
	 * @param serverPort <span class="en-US">Server port number</span>
	 *                   <span class="zh-CN">服务器端口号</span>
	 */
	public void setServerPort(int serverPort) {
		this.serverPort = serverPort;
	}

	/**
	 * <h4 class="en-US">Getter method for server level</h4>
	 * <h4 class="zh-CN">服务器等级的Getter方法</h4>
	 *
	 * @return <span class="en-US">Server level</span>
	 * <span class="zh-CN">服务器等级</span>
	 */
	public int getServerLevel() {
		return this.serverLevel;
	}

	/**
	 * <h4 class="en-US">Setter method for server level</h4>
	 * <h4 class="zh-CN">服务器等级的Setter方法</h4>
	 *
	 * @param serverLevel <span class="en-US">Server level</span>
	 *                    <span class="zh-CN">服务器等级</span>
	 */
	public void setServerLevel(int serverLevel) {
		this.serverLevel = serverLevel;
	}

	/**
	 * <h4 class="en-US">Convert server information to string</h4>
	 * <h4 class="zh-CN">转换服务器信息为字符串</h4>
	 *
	 * @return <span class="en-US">Converted string</span>
	 * <span class="zh-CN">转换后的字符串</span>
	 */
	public String info() {
		StringBuilder stringBuilder = new StringBuilder();
		if (IPUtils.isIPv6Address(this.serverAddress)) {
			stringBuilder.append("[").append(this.serverAddress).append("]");
		} else {
			stringBuilder.append(this.serverAddress);
		}
		if (this.serverPort > Globals.INITIALIZE_INT_VALUE) {
			stringBuilder.append(":").append(this.serverPort);
		}
		return stringBuilder.toString();
	}
}
