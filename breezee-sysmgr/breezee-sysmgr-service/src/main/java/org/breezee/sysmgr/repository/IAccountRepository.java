/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.sysmgr.repository;

import org.breezee.common.framework.ICommonRepository;
import org.breezee.sysmgr.api.domain.AccountInfo;
import org.breezee.sysmgr.entity.AccountEntity;
import org.springframework.stereotype.Repository;

/**
 * 账号管理的持久化服务
 * Created by Silence on 2016/6/2.
 */
@Repository("accountRepository")
public interface IAccountRepository extends ICommonRepository<AccountEntity, AccountInfo, String> {
}
