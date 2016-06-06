/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.sysmgr.entity;

import org.breezee.common.framework.BaseEntity;
import org.breezee.sysmgr.api.domain.EnumItemInfo;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 持久域：枚举行
 * Created by Silence on 2016/5/10.
 */
@Entity
@Table(name = "SYM_TF_ENUM_ITEM")
public class EnumItemEntity extends BaseEntity<EnumItemEntity, EnumItemInfo> {

    private EnumEntity master;

    @Id
    @GeneratedValue(generator = "assigned-uid")
    @GenericGenerator(name = "assigned-uid", strategy = "assigned")
    @Column(name = "ENUM_ITEM_ID", unique = true, nullable = false, updatable = false, length = 64)
    public String getId() {
        return id;
    }

    @Column(name = "ENUM_ITEM_CODE", nullable = false, updatable = false, length = 64)
    public String getCode() {
        return code;
    }

    @Column(name = "ENUM_ITEM_NAME", nullable = false, length = 2000)
    public String getName() {
        return name;
    }

    @Column(name = "TENANT_ID", nullable = false, updatable = false, length = 64)
    public String getTenantId() {
        return tenantId;
    }

    @Column(name = "ROW_NUM", nullable = false)
    public Long getRowNum() {
        return rowNum;
    }

    @Column(name = "VERSION", nullable = false)
    public Integer getVersion() {
        return version;
    }

    @Column(name = "STATUS", nullable = false)
    public Integer getStatus() {
        return this.status;
    }

    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "ENUM_ID")
    public EnumEntity getMaster() {
        return master;
    }

    public void setMaster(EnumEntity master) {
        this.master = master;
    }
}
