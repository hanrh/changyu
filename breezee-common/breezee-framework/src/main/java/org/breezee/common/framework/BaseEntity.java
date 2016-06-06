/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.common.framework;

import org.breezee.common.domain.BaseInfo;
import org.breezee.common.domain.BizInfo;
import org.breezee.common.domain.exception.BreezeeException;

import java.util.Date;

/**
 * * 持久实体域：基类
 * 子类方法，继承了父类上的方法，同时也会继承方法上的注解
 * Created by Silence on 2016/5/5.
 */
public class BaseEntity<T extends BaseEntity, R extends BaseInfo> extends BizInfo {

//    @Id
//    @GeneratedValue(generator = "assigned-uid")
//    @GenericGenerator(name = "assigned-uid", strategy = "assigned")
//    @Column(name = "PK_ID", unique = true, nullable = false, updatable = false, length = 64)
//    public String getId() {
//        return id;
//    }
//
//    @Column(name = "CODE", unique = true, nullable = false, updatable = false, length = 64)
//    public String getCode() {
//        return code;
//    }
//
//    @Column(name = "NAME", nullable = false, length = 2000)
//    public String getName() {
//        return name;
//    }
//
//    @Column(name = "TENANT_ID", nullable = false, updatable = false, length = 64)
//    public String getTenantId() {
//        return tenantId;
//    }
//
//    @Column(name = "CREATOR", nullable = false, updatable = false, length = 64)
//    public String getCreator() {
//        return creator;
//    }
//
//    @Column(name = "CREATE_TIME", nullable = false, updatable = false)
//    public Date getCreateTime() {
//        return createTime;
//    }
//
//    @Column(name = "UPDATOR", nullable = false, length = 64)
//    public String getUpdator() {
//        return updator;
//    }
//
//    @Column(name = "UPDATE_TIME", nullable = false)
//    public Date getUpdateTime() {
//        return updateTime;
//    }
//
//    @Column(name = "REMARK", length = 3000)
//    public String getRemark() {
//        return remark;
//    }

//    @Column(name = "COMPANY", length = 32)
//    public String getCompany() {
//        return company;
//    }
//
//    @Column(name = "LANGUAGE", nullable = false, length = 16)
//    public String getLanguage() {
//        return language;
//    }
//
//    @Column(name = "ROW_NUM", nullable = false)
//    public Long getRowNum() {
//        return rowNum;
//    }
//
//    @Column(name = "VERSION", nullable = false)
//    public Integer getVersion() {
//        return version;
//    }
//
//    @Column(name = "STATUS", nullable = false)
//    public Integer getStatus() {
//        return this.status;
//    }
//
//    @Column(name = "EQUIPMENT", nullable = false)
//    public Integer getEquipment() {
//        return equipment;
//    }

    /**
     * DTO转换
     *
     * @param r         info实例
     * @param ignorePro 忽略属性
     * @return 返回传入的info实例
     */
    public R toInfo(R r, String... ignorePro) {
        if (r == null)
            return null;
        BeanUtil.beanCopy(this, r, ignorePro);
        return r;
    }

    public R toInfo(Class<R> cla, String... ignorePro) {
        try {
            R r = cla.newInstance();
            return toInfo(r, ignorePro);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * DTO转换
     *
     * @param r         info实例
     * @param ignorePro 忽略的属性
     * @return 解析后的实体
     */
    public T parseInfo(R r, String... ignorePro) throws BreezeeException {
        //设置最后保存的节点
        r.setNode(SystemTool.getHostName());
        r.setUpdateTime(new Date());
        if (r.getId() == null || r.getId().trim().length() == 0) {
            r.setId(SystemTool.uuid().replaceAll("-", "") + "@" + r.getNode());
            r.setCreateTime(new Date());
        }
        BeanUtil.beanCopy(r, this, ignorePro);
        return (T) this;
    }
}
