/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.facade.resource;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import org.breezee.common.domain.BreezeeUtils;
import org.breezee.common.domain.constants.InfoStatusEnum;
import org.breezee.common.domain.exception.EntityNotFoundException;
import org.breezee.facade.inter.IAuthFacade;
import org.breezee.facade.response.JsonResponse;
import org.breezee.sysmgr.api.domain.AccountInfo;
import org.breezee.sysmgr.api.domain.OrganizationInfo;
import org.breezee.sysmgr.api.domain.RoleInfo;
import org.breezee.sysmgr.api.service.IAccountService;
import org.breezee.sysmgr.api.service.IOrganizationService;
import org.breezee.sysmgr.api.service.IRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.ws.rs.*;
import java.util.List;

/**
 * 人员，组织，角色的资源类
 * Created by Silence on 2016/6/6.
 */
@SuppressWarnings("unchecked")
@Service("authFacade")
@Produces(ContentType.APPLICATION_JSON_UTF_8)
@Consumes(ContentType.APPLICATION_JSON_UTF_8)
@Path("/auth")
public class AuthFacadeImpl extends JsonCommonFacade implements IAuthFacade {

    @Resource
    private IAccountService accountService;

    @Resource
    private IOrganizationService organizationService;

    @Resource
    private IRoleService roleService;

    @Path("/checkLogin")
    @POST
    @Override
    public JsonResponse checkLogin(AccountInfo accountInfo) {
        AccountInfo myInfo;
        try {
            myInfo = (AccountInfo) accountService.findByCode(accountInfo.getCode());
            if (!myInfo.getPassword().equals(BreezeeUtils.enCrypt(accountInfo.getPassword()))) {
                return JsonResponse.ERROR("password is wrong!");
            }
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return JsonResponse.ERROR(e.getMessage());
        }
        //将用户信息返回至页面中
        return JsonResponse.buildSingle(myInfo);
    }

    @Path("/account")
    @PUT
    @Override
    public JsonResponse saveAccount(AccountInfo accountInfo) {
        return _saveInfo(accountService, accountInfo);
    }

    @Path("/organization")
    @PUT
    @Override
    public JsonResponse saveOrganization(OrganizationInfo organizationInfo) {
        return _saveInfo(organizationService, organizationInfo);
    }

    @Path("/role")
    @PUT
    @Override
    public JsonResponse saveRole(RoleInfo roleInfo) {
        return _saveInfo(roleService, roleInfo);
    }

    @Path("/account/page")
    @POST
    @Override
    public JsonResponse pageAccount(AccountInfo accountInfo) {
        return _pageAll(accountService, accountInfo);
    }

    @Path("/organization/tree/{parentId}")
    @GET
    @Override
    public JsonResponse treeOrganization(@PathParam("parentId") String parentId) {
        long t = System.currentTimeMillis();
        OrganizationInfo organizationInfo = new OrganizationInfo();
        organizationInfo.getProperties().put("parent_obj", parentId);
        return JsonResponse.build(organizationService.listAll(organizationInfo), t);
    }

    @Path("/role/list")
    @POST
    @Override
    public JsonResponse listRole(RoleInfo roleInfo) {
        return _pageAll(roleService, roleInfo);
    }

    @Path("/role/{id}")
    @GET
    @Override
    public JsonResponse findRoleById(@PathParam("id") String id) {
        return _findOne(roleService, id, 0);
    }

    @Override
    public JsonResponse enableAccount(List<String> ids, boolean enable) {
        ids.forEach(a -> {
            accountService.updateStatus(a, enable ? InfoStatusEnum.ENABLE : InfoStatusEnum.DISABLE);
        });
        return JsonResponse.OK();
    }

    @Override
    public JsonResponse enableAccount(AccountInfo accountInfo, boolean enable) {
        List<AccountInfo> l = accountService.listAll(accountInfo);
        l.forEach(a -> {
            accountService.updateStatus(a.getId(), enable ? InfoStatusEnum.ENABLE : InfoStatusEnum.DISABLE);
        });
        return JsonResponse.OK();
    }

    @Path("/account/restPassword")
    @POST
    @Override
    public JsonResponse resetPassword(List<AccountInfo> accounts) {
        accounts.forEach(a -> {
            accountService.changePassword(a.getId(), a.getCode() + "123");
        });
        return JsonResponse.OK();
    }

    @Path("/account/code/{code}")
    @GET
    @Override
    public JsonResponse findAccountByCode(@PathParam("code") String code) {
        return _findOne(accountService, code, 1);
    }

    @Path("/account/{id}")
    @GET
    @Override
    public JsonResponse findAccountById(@PathParam("id") String id) {
        return _findOne(accountService, id, 0);
    }

    @Path("/organization/{id}")
    @GET
    @Override
    public JsonResponse findOrganizationById(@PathParam("id") String id) {
        return _findOne(organizationService, id, 0);
    }

    @Path("/organization/accounts")
    @POST
    @Override
    public JsonResponse saveOrgAccounts(OrganizationInfo info) {
        organizationService.saveAccounts(info);
        return JsonResponse.OK();
    }

}
