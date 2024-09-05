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

package org.nervousync.brain.query.data;

import jakarta.annotation.Nonnull;
import jakarta.xml.bind.annotation.*;
import org.nervousync.beans.core.BeanObject;

import java.io.Serial;
import java.io.Serializable;

/**
 * <h2 class="en-US">Match condition range define</h2>
 * <h2 class="zh-CN">匹配条件范围定义</h2>
 *
 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
 * @version $Revision: 1.0.0 $ $Date: Oct 9, 2020 17:37:44 $
 */
@XmlType(name = "ranges_data", namespace = "https://nervousync.org/schemas/database")
@XmlRootElement(name = "ranges_data", namespace = "https://nervousync.org/schemas/database")
public final class RangesData extends BeanObject {

    /**
     * <span class="en-US">Serial version UID</span>
     * <span class="zh-CN">序列化UID</span>
     */
	@Serial
    private static final long serialVersionUID = 2018535373465095105L;

    /**
     * <span class="en-US">Begin value</span>
     * <span class="zh-CN">起始值</span>
     */
    @XmlElement(name = "begin_value")
    private Serializable beginValue;
    /**
     * <span class="en-US">End value</span>
     * <span class="zh-CN">终止值</span>
     */
    @XmlElement(name = "end_value")
    private Serializable endValue;

    /**
     * <h4 class="en-US">Constructor method for match condition range define</h4>
     * <h4 class="zh-CN">匹配条件范围定义的构造方法</h4>
     */
    public RangesData() {
    }

    /**
     * <h4 class="en-US">Constructor method for match condition range define</h4>
     * <h4 class="zh-CN">匹配条件范围定义的构造方法</h4>
     *
     * @param beginValue <span class="en-US">Begin value</span>
     *                   <span class="zh-CN">起始值</span>
     * @param endValue   <span class="en-US">End value</span>
     *                   <span class="zh-CN">终止值</span>
     */
    public RangesData(@Nonnull final Serializable beginValue, @Nonnull final Serializable endValue) {
        this();
        this.beginValue = beginValue;
        this.endValue = endValue;
    }

    /**
     * <h4 class="en-US">Getter method for begin value</h4>
     * <h4 class="zh-CN">起始值的Getter方法</h4>
     *
     * @return <span class="en-US">Begin value</span>
     * <span class="zh-CN">起始值</span>
     */
    public Serializable getBeginValue() {
        return this.beginValue;
    }

    /**
     * <h4 class="en-US">Setter method for begin value</h4>
     * <h4 class="zh-CN">起始值的Setter方法</h4>
     *
     * @param beginValue <span class="en-US">Begin value</span>
     *                   <span class="zh-CN">起始值</span>
     */
    public void setBeginValue(final Serializable beginValue) {
        this.beginValue = beginValue;
    }

    /**
     * <h4 class="en-US">Getter method for end value</h4>
     * <h4 class="zh-CN">终止值的Getter方法</h4>
     *
     * @return <span class="en-US">End value</span>
     * <span class="zh-CN">终止值</span>
     */
    public Serializable getEndValue() {
        return this.endValue;
    }

    /**
     * <h4 class="en-US">Setter method for end value</h4>
     * <h4 class="zh-CN">终止值的Setter方法</h4>
     *
     * @param endValue <span class="en-US">End value</span>
     *                 <span class="zh-CN">终止值</span>
     */
    public void setEndValue(final Serializable endValue) {
        this.endValue = endValue;
    }
}
