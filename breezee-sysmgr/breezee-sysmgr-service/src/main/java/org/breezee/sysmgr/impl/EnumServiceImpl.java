/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.sysmgr.impl;

import javafx.util.Callback;
import org.breezee.common.domain.IRepository;
import org.breezee.common.domain.exception.BreezeeException;
import org.breezee.sysmgr.api.domain.EnumInfo;
import org.breezee.sysmgr.api.service.IEnumService;
import org.breezee.sysmgr.entity.EnumEntity;
import org.breezee.sysmgr.repository.IEnumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 枚举服务实现类
 * Created by Silence on 2016/5/31.
 */
@Service("enumService")
public class EnumServiceImpl implements IEnumService<EnumEntity> {

    @Autowired
    private IEnumRepository enumRepository;

    @Override
    public IRepository<EnumInfo> getRepository() {
        return enumRepository;
    }

    @Override
    public Class<EnumEntity> getEntityClass() {
        return EnumEntity.class;
    }

    /**
     * 在更新枚举的时候，先删除此枚举，然后再重新建立
     * 因为枚举比较简单，可以采用此方法，进行重建
     *
     * @param info
     * @param callback 回调函数
     * @return
     * @throws BreezeeException
     */
    public EnumInfo saveInfo(EnumInfo info, Callback<EnumInfo, EnumEntity>... callback) throws BreezeeException {
        deleteById(info.getId());
        try {
            enumRepository.flush();
        } catch (Exception e) {
            e.printStackTrace();
            throw new BreezeeException(e.getMessage(), e);
        }
        info.setId(null);
        return getRepository().saveInfo(info, getEntityClass());
    }
}
