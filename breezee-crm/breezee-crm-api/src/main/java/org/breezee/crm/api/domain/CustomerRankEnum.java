/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.crm.api.domain;

import org.breezee.common.domain.constants.ConstantEnum;

/**
 * 客户分级的枚举值
 * Created by Silence on 2016/5/11.
 */
public enum CustomerRankEnum implements ConstantEnum {

    GENERAL("A", 1);

    private final String text;

    private final Integer value;


    CustomerRankEnum(String text, Integer value) {
        this.text = text;
        this.value = value;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }

    @Override
    public String getText() {
        return this.text;
    }
}
