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
package org.nervousync.brain.enumerations.query;

/**
 * <h2 class="en-US">Enumeration value of query item type</h2>
 * <h2 class="zh-CN">查询项类型的枚举值</h2>
 *
 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
 * @version $Revision: 1.0.0 $ $Date: Oct 6, 2020 19:02:27 $
 */
public enum ItemType {
    /**
     * <span class="en-US">Column</span>
     * <span class="zh-CN">数据列</span>
     */
    COLUMN,
    /**
     * <span class="en-US">SQL function</span>
     * <span class="zh-CN">SQL函数</span>
     */
    FUNCTION,
    /**
     * <span class="en-US">Constant value</span>
     * <span class="zh-CN">常量值</span>
     */
    CONSTANT,
    /**
     * <span class="en-US">Sub-query</span>
     * <span class="zh-CN">子查询</span>
     */
    QUERY,
    /**
     * <span class="en-US">Ranges value</span>
     * <span class="zh-CN">区间值</span>
     */
    RANGE,
    /**
     * <span class="en-US">Object array</span>
     * <span class="zh-CN">数据数组</span>
     */
    ARRAY,
    /**
     * <span class="en-US">Query result</span>
     * <span class="zh-CN">查询结果</span>
     */
    RESULT
}
