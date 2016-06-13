/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.crm.impl;

import org.breezee.common.domain.IRepository;
import org.breezee.common.domain.exception.BreezeeException;
import org.breezee.crm.api.domain.CustomerDlgInfo;
import org.breezee.crm.api.domain.CustomerInfo;
import org.breezee.crm.api.service.ICustomerService;
import org.breezee.crm.entity.CustomerDlgEntity;
import org.breezee.crm.entity.CustomerEntity;
import org.breezee.crm.repository.ICustomerDlgRepository;
import org.breezee.crm.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 服务域：客户服务
 * Created by Silence on 2016/6/4.
 */
@Service("customerService")
public class CustomerServiceImpl implements ICustomerService<CustomerEntity> {

    @Autowired
    private ICustomerRepository customerRepository;

    @Autowired
    private ICustomerDlgRepository customerDlgRepository;

    @Override
    public IRepository<CustomerInfo> getRepository() {
        return customerRepository;
    }

    @Override
    public Class<CustomerEntity> getEntityClass() {
        return CustomerEntity.class;
    }

    @Override
    public void saveCustomerDelegate(CustomerDlgInfo info) throws BreezeeException {
        customerDlgRepository.saveInfo(info, CustomerDlgEntity.class);
    }

    @Override
    public List<CustomerInfo> accountDelegate(String accountCode) {
        List<CustomerDlgEntity> l = customerDlgRepository.findByAccountCode(accountCode);
        List<CustomerInfo> ll = new ArrayList<>();
        l.forEach(a -> {
            if (a.getCustomer() != null) {
                ll.add(a.getCustomer().toInfo(CustomerInfo.class));
            }
        });
        return ll;
    }

    @Override
    public void delCustomerDlg(String id) {
        customerDlgRepository.delete(id);
    }
}
