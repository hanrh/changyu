/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.sysmgr.api.domain;

import org.breezee.common.domain.TreeInfo;

/**
 * 实体域：组织信息对象
 * 省，城市，营销部 构成一个树形结构
 * Created by Silence on 2016/4/25.
 */
public class OrganizationInfo extends TreeInfo<OrganizationInfo> {

    protected String company;

    public OrganizationInfo() {
    }

    public OrganizationInfo(String id, String code, String name) {
        this.setId(id);
        this.setCode(code);
        this.setName(name);
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
