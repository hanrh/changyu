/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.sysmgr.repository;

import org.breezee.common.framework.ICommonRepository;
import org.breezee.sysmgr.api.domain.EnumInfo;
import org.breezee.sysmgr.entity.EnumEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * 枚举服务的持久化接口
 * Created by Silence on 2016/5/31.
 */
@Repository("enumRepository")
public interface IEnumRepository extends ICommonRepository<EnumEntity, EnumInfo, String> {

    @Modifying
    @Transactional
    @Query("delete from EnumItemEntity m where m.master=:master")
    void deleteItems(@Param("master") EnumEntity master);
}
