/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.crm.api.service;

import org.breezee.common.domain.IServiceLayer;
import org.breezee.common.domain.exception.BreezeeException;
import org.breezee.crm.api.domain.CustomerDlgInfo;
import org.breezee.crm.api.domain.CustomerInfo;

import java.util.List;

/**
 * 服务域：客户管理服务
 * Created by Silence on 2016/6/4.
 */
public interface ICustomerService<E> extends IServiceLayer<CustomerInfo, E> {

    @Override
    default Class<CustomerInfo> getInfoClass() {
        return CustomerInfo.class;
    }

    /**
     * 保存客户的代理账号
     *
     * @param info 客户代理
     * @throws BreezeeException
     */
    void saveCustomerDelegate(CustomerDlgInfo info) throws BreezeeException;

    /**
     * 获取代理客户
     *
     * @param accountCode 账号
     * @return 列表
     */
    List<CustomerInfo> accountDelegate(String accountCode);

    /**
     * 删除指定代理
     *
     * @param id 代理标识
     */
    void delCustomerDlg(String id);
}
