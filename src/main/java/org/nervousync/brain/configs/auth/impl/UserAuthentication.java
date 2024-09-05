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

package org.nervousync.brain.configs.auth.impl;

import jakarta.xml.bind.annotation.*;
import org.nervousync.annotations.configs.Password;
import org.nervousync.brain.configs.auth.Authentication;
import org.nervousync.brain.enumerations.auth.AuthType;

import java.io.Serial;

/**
 * <h2 class="en-US">Basic authentication information</h2>
 * <h2 class="zh-CN">基本身份认证信息</h2>
 *
 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
 * @version $Revision : 1.0 $ $Date: Apr 10, 2018 15:44:07 $
 */
@XmlRootElement(name = "user_authentication", namespace = "https://nervousync.org/schemas/database")
@XmlType(name = "user_authentication", namespace = "https://nervousync.org/schemas/database")
@XmlAccessorType(XmlAccessType.NONE)
public final class UserAuthentication extends Authentication {

	/**
	 * <span class="en-US">Serial version UID</span>
	 * <span class="zh-CN">序列化UID</span>
	 */
	@Serial
	private static final long serialVersionUID = 3066602225213721895L;

	/**
	 * <span class="en-US">Username</span>
	 * <span class="zh-CN">用户名</span>
	 */
	@XmlElement(name = "username")
	private String userName = null;
	/**
	 * <span class="en-US">Password</span>
	 * <span class="zh-CN">密码</span>
	 */
	@XmlElement(name = "password")
	@Password
	private String passWord = null;

	/**
	 * <h4 class="en-US">Constructor method for basic authentication information</h4>
	 * <h4 class="zh-CN">基本身份认证信息的构造方法</h4>
	 */
	public UserAuthentication() {
		super(AuthType.BASIC);
	}

	/**
	 * <h4 class="en-US">Getter method for username</h4>
	 * <h4 class="zh-CN">用户名的Getter方法</h4>
	 *
	 * @return <span class="en-US">Username</span>
	 * <span class="zh-CN">用户名</span>
	 */
	public String getUserName() {
		return this.userName;
	}

	/**
	 * <h4 class="en-US">Setter method for username</h4>
	 * <h4 class="zh-CN">用户名的Setter方法</h4>
	 *
	 * @param userName <span class="en-US">Username</span>
	 *                 <span class="zh-CN">用户名</span>
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * <h4 class="en-US">Getter method for password</h4>
	 * <h4 class="zh-CN">密码的Getter方法</h4>
	 *
	 * @return <span class="en-US">Password</span>
	 * <span class="zh-CN">密码</span>
	 */
	public String getPassWord() {
		return this.passWord;
	}

	/**
	 * <h4 class="en-US">Setter method for password</h4>
	 * <h4 class="zh-CN">密码的Setter方法</h4>
	 *
	 * @param passWord <span class="en-US">Password</span>
	 *                 <span class="zh-CN">密码</span>
	 */
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
}
