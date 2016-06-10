/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.sysmgr.impl;

import org.breezee.common.domain.BreezeeUtils;
import org.breezee.common.domain.IRepository;
import org.breezee.sysmgr.api.domain.AccountInfo;
import org.breezee.sysmgr.api.service.IAccountService;
import org.breezee.sysmgr.entity.AccountEntity;
import org.breezee.sysmgr.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 账号服务实现类
 * Created by Silence on 2016/6/2.
 */
@Service("accountService")
public class AccountServiceImpl implements IAccountService<AccountEntity> {

    @Autowired
    private IAccountRepository accountRepository;

    @Override
    public IRepository<AccountInfo> getRepository() {
        return accountRepository;
    }

    @Override
    public Class<AccountEntity> getEntityClass() {
        return AccountEntity.class;
    }

    @Override
    public void changePassword(String id, String password) {
        AccountEntity entity = accountRepository.findOne(id);
        entity.setPassword(BreezeeUtils.enCrypt(password));
        accountRepository.saveAndFlush(entity);
    }
}
