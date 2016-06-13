/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.sysmgr.entity;

import org.breezee.common.framework.BaseEntity;
import org.breezee.common.framework.ContextUtil;
import org.breezee.sysmgr.api.domain.OrganizationInfo;
import org.breezee.sysmgr.repository.IOrganizationRepository;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * 持久域：组织实体。
 * 省，城市，营销部 构成一个树形结构
 * Created by Silence on 2016/5/10.
 */
@Entity
@Table(name = "SYM_TF_ORGANIZATION", schema = BaseEntity.DB_SCHEMA)
public class OrganizationEntity extends BaseEntity<OrganizationEntity, OrganizationInfo> {

    private Integer category;

    private OrganizationEntity parent;

    private Set<OrganizationEntity> children;

    private Set<AccountEntity> accounts;

    @Id
    @GeneratedValue(generator = "assigned-uid")
    @GenericGenerator(name = "assigned-uid", strategy = "assigned")
    @Column(name = "ORG_ID", unique = true, nullable = false, updatable = false, length = 64)
    public String getId() {
        return id;
    }

    @Column(name = "ORG_CODE", unique = true, nullable = false, updatable = false, length = 64)
    public String getCode() {
        return code;
    }

    @Column(name = "ORG_NAME", nullable = false, length = 2000)
    public String getName() {
        return name;
    }

    @Column(name = "TENANT_ID", nullable = false, updatable = false, length = 64)
    public String getTenantId() {
        return tenantId;
    }

    @Column(name = "CREATOR", nullable = false, updatable = false, length = 64)
    public String getCreator() {
        return creator;
    }

    @Column(name = "CREATE_TIME", nullable = false, updatable = false)
    public Date getCreateTime() {
        return createTime;
    }

    @Column(name = "UPDATOR", nullable = false, length = 64)
    public String getUpdator() {
        return updator;
    }

    @Column(name = "UPDATE_TIME", nullable = false)
    public Date getUpdateTime() {
        return updateTime;
    }

    @Column(name = "REMARK", length = 3000)
    public String getRemark() {
        return remark;
    }

    @Column(name = "COMPANY", length = 32)
    public String getCompany() {
        return company;
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

    @Column(name = "NODE_HOST", nullable = false, length = 128)
    public String getNode() {
        return node;
    }

    @OneToMany(mappedBy = "organization", cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @OrderBy(value = "code ASC")
    public Set<AccountEntity> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<AccountEntity> accounts) {
        this.accounts = accounts;
    }

    @Column(name = "CATEGORY", nullable = false)
    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    @OneToOne
    @JoinColumn(name = "PARENT_ID", referencedColumnName = "ORG_ID")
    public OrganizationEntity getParent() {
        return parent;
    }

    public void setParent(OrganizationEntity parent) {
        this.parent = parent;
    }

    @OneToMany(mappedBy = "parent", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    public Set<OrganizationEntity> getChildren() {
        return children;
    }

    public void setChildren(Set<OrganizationEntity> children) {
        this.children = children;
    }

    public OrganizationEntity parseInfo(OrganizationInfo info, String... ignore) {
        super.parseInfo(info, "parent", "children");
        if (info.getParent() != null
                && StringUtils.hasText(info.getParent().getId())) {
            this.setParent(ContextUtil.getBean("organizationRepository", IOrganizationRepository.class)
                    .findOne(info.getParent().getId()));
        }
        return this;
    }

    public OrganizationInfo toInfo(OrganizationInfo info, String... ignore) {
        super.toInfo(info, "parent", "children");
        if (this.getParent() != null) {
            info.setParent(new OrganizationInfo(getParent().getId(), getParent().getCode(), getParent().getName(), getParent().getCategory()));
            info.getParent().setCompany(getParent().getCompany());
        }
//        List<OrganizationInfo> l = new ArrayList<>();
//        this.getChildren().forEach(a -> {
//            l.add(new OrganizationInfo(a.getId(), a.getCode(), a.getName()));
//        });
//        info.setChildren(l);
        if (this.getChildren().size() > 0)
            info.setLeaf(false);
        return info;
    }
}
