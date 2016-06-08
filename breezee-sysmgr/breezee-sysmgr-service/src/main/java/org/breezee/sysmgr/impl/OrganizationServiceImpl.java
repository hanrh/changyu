/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.sysmgr.impl;

import org.breezee.common.domain.IRepository;
import org.breezee.common.domain.exception.BreezeeException;
import org.breezee.sysmgr.api.domain.OrganizationInfo;
import org.breezee.sysmgr.api.service.IOrganizationService;
import org.breezee.sysmgr.entity.OrganizationEntity;
import org.breezee.sysmgr.repository.IOrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * 组织服务实现类
 * Created by Silence on 2016/6/2.
 */
@Service("organizationService")
public class OrganizationServiceImpl implements IOrganizationService<OrganizationEntity> {

    @Autowired
    private IOrganizationRepository organizationRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Override
    public IRepository<OrganizationInfo> getRepository() {
        return organizationRepository;
    }

    @Override
    public Class<OrganizationEntity> getEntityClass() {
        return OrganizationEntity.class;
    }

    @Override
    public void saveAccounts(OrganizationInfo info) throws BreezeeException {
        String delSqlActAll = "delete from SYM_TF_ORG_ACN where ORG_ID='" + info.getId() + "'";
        String insertSql = "insert into SYM_TF_ORG_ACN (ORG_ID,ACN_ID) values(?,?)";
        List<Object[]> l = new ArrayList<>();
        if (info.getAccounts() != null) {
            info.getAccounts().forEach(a -> {
                l.add(new Object[]{info.getId(), a});
            });
        }
        TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);
        transactionTemplate.execute(status -> {
            //先删除此组织下所有的关联人员，然后新增即可
            jdbcTemplate.update(delSqlActAll);
            if (l.size() > 0) {
                jdbcTemplate.batchUpdate(insertSql, l);
            }
            return null;
        });
    }
}
