/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.facade.inter;

import org.breezee.common.domain.IFacadeLayer;
import org.breezee.facade.response.Response;
import org.breezee.sysmgr.api.domain.AccountInfo;
import org.breezee.sysmgr.api.domain.OrganizationInfo;
import org.breezee.sysmgr.api.domain.RoleInfo;

import java.util.List;

/**
 * 账号，组织，角色的Facade接口
 * Created by Silence on 2016/6/6.
 */
public interface IAuthFacade extends IFacadeLayer {

    /**
     * 登录认证
     *
     * @param accountInfo 界面传入信息
     * @return 认证结果
     */
    Response<AccountInfo> checkLogin(AccountInfo accountInfo);

    /**
     * 保存账号
     *
     * @param accountInfo 账号对象
     * @return 结果
     */
    Response<AccountInfo> saveAccount(AccountInfo accountInfo);

    /**
     * 保存组织信息
     *
     * @param organizationInfo 组织对象
     * @return 结果信息
     */
    Response<OrganizationInfo> saveOrganization(OrganizationInfo organizationInfo);

    /**
     * 保存角色
     *
     * @param roleInfo 角色信息
     * @return 结果
     */
    Response<RoleInfo> saveRole(RoleInfo roleInfo);

    /**
     * 分页获取账号列表
     *
     * @param accountInfo 查询条件
     * @return 分页结果
     */
    Response<AccountInfo> pageAccount(AccountInfo accountInfo);

    /**
     * 展现组织树
     *
     * @return 或者指定根节点下的组织树
     */
    Response<OrganizationInfo> treeOrganization(String parentId);

    /**
     * 列表展现所有的角色
     *
     * @return 角色列表
     */
    Response<RoleInfo> listRole(RoleInfo roleInfo);

    /**
     * 获取指定ID的角色信息
     *
     * @param id 指定ID
     * @return 角色信息
     */
    Response<RoleInfo> findRoleById(String id);

    /**
     * 更新指定人员的状态
     *
     * @param ids    人员ID集合
     * @param enable 状态值
     * @return 结果
     */
    Response<AccountInfo> enableAccount(List<String> ids, boolean enable);

    /**
     * 更新指定查询条件的人员的状态
     *
     * @param accountInfo 查询条件
     * @param enable      状态值
     * @return 结果
     */
    Response<AccountInfo> enableAccount(AccountInfo accountInfo, boolean enable);

    /**
     * 重置指定人员的密码
     *
     * @param accounts 人员集合
     * @return 结果
     */
    Response<AccountInfo> resetPassword(List<AccountInfo> accounts);

    /**
     * 根据用户编码，获取用户信息
     *
     * @param code 用户编码
     * @return 用户对象
     */
    Response<AccountInfo> findAccountByCode(String code);

    Response<AccountInfo> findAccountById(String id);

    Response<OrganizationInfo> findOrganizationById(String id);

    Response<OrganizationInfo> saveOrgAccounts(OrganizationInfo info);
}
