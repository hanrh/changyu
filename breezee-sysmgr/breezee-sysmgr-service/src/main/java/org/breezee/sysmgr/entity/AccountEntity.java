/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.sysmgr.entity;

import org.breezee.common.domain.BreezeeUtils;
import org.breezee.common.framework.BaseEntity;
import org.breezee.sysmgr.api.domain.AccountInfo;
import org.breezee.sysmgr.api.domain.OrganizationInfo;
import org.breezee.sysmgr.api.domain.RoleInfo;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 持久域：账号实体
 * Created by Silence on 2016/5/5.
 */
@Entity
@Table(name = "SYM_TF_ACCOUNT", schema = BaseEntity.DB_SCHEMA)
public class AccountEntity extends BaseEntity<AccountEntity, AccountInfo> {

    private OrganizationEntity organization;

    private Set<RoleEntity> roles;

    private String password;

    private Integer type;

    private String job;

    private Integer sex;

    private String mobile;

    private String email;

    @Id
    @GeneratedValue(generator = "assigned-uid")
    @GenericGenerator(name = "assigned-uid", strategy = "assigned")
    @Column(name = "ACN_ID", unique = true, nullable = false, updatable = false, length = 64)
    public String getId() {
        return id;
    }

    @Column(name = "ACN_CODE", unique = true, nullable = false, updatable = false, length = 64)
    public String getCode() {
        return code;
    }

    @Column(name = "ACN_NAME", nullable = false, length = 2000)
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

    @Column(name = "COMPANY", nullable = false, length = 32)
    public String getCompany() {
        return company;
    }

    @Column(name = "CHANNEL", nullable = false, length = 32)
    public String getChannel() {
        return channel;
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

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(name = "SYM_TF_ORG_ACN", joinColumns = @JoinColumn(name = "ACN_ID", referencedColumnName = "ACN_ID"),
            inverseJoinColumns = @JoinColumn(name = "ORG_ID", referencedColumnName = "ORG_ID"))
    public OrganizationEntity getOrganization() {
        return organization;
    }

    public void setOrganization(OrganizationEntity organization) {
        this.organization = organization;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "SYM_TF_ROLE_ACN", joinColumns = @JoinColumn(name = "ACN_ID", referencedColumnName = "ACN_ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID"))
    public Set<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
    }

    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "TYPE", nullable = false)
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Column(name = "JOB", length = 64)
    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Column(name = "SEX", length = 16)
    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Column(name = "MOBILE", nullable = false, length = 16)
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Column(name = "EMAIL", length = 255)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Transactional
    public AccountInfo toInfo(AccountInfo info, String... ignorep) {
        super.toInfo(info, ignorep);
        OrganizationEntity org = this.getOrganization();
        if (org != null) {
            OrganizationInfo oInfo = new OrganizationInfo();
            oInfo.setId(org.getId());
            oInfo.setCode(org.getCode());
            oInfo.setCompany(org.getCompany());
            oInfo.setName(org.getName());
            oInfo.setCategory(org.getCategory());
            info.setOrg(oInfo);

            info.setProvince(org.getCode());
            org = org.getParent();
            while (org != null) {
                if (org.getCategory() == 1) {
                    info.setProvince(org.getCode());
                    break;
                }
                org = org.getParent();
            }
        }
        Set<RoleInfo> roles = new HashSet<>();
        if (this.getRoles() != null)
            this.getRoles().forEach(a -> roles.add(a.toInfo(new RoleInfo())));
        info.setRoles(roles);
        return info;
    }

    public AccountEntity parseInfo(AccountInfo info, String... ignore) {
        super.parseInfo(info, ignore);
        if (StringUtils.isEmpty(info.getPassword())) {
            this.setPassword(BreezeeUtils.enCrypt(info.getCode() + "123"));
        }
        return this;
    }
}
