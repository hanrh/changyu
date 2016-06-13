/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.sysmgr.api.domain;

import org.breezee.common.domain.TreeInfo;

import java.util.List;

/**
 * 实体域：组织信息对象
 * 省，城市，营销部 构成一个树形结构
 * Created by Silence on 2016/4/25.
 */
public class OrganizationInfo extends TreeInfo<OrganizationInfo> {

    /**
     * 组织级别：0：顶层，1:省公司，2： 城市公司， 3:营销部
     */
    protected Integer category;

    protected String company;

    protected List<String> accounts;

    public OrganizationInfo() {
    }

    public OrganizationInfo(String id, String code, String name, Integer category) {
        this.setId(id);
        this.setCode(code);
        this.setName(name);
        this.setCategory(category);
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public List<String> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<String> accounts) {
        this.accounts = accounts;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }
}
