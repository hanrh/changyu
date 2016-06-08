/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.facade.resource;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import org.breezee.common.domain.BaseInfo;
import org.breezee.common.domain.exception.BreezeeException;
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
public class AuthFacadeImpl implements IAuthFacade {

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
        return JsonResponse.OK();
    }

    @Path("/account")
    @PUT
    @Override
    public JsonResponse saveAccount(AccountInfo accountInfo) {
        return _saveInfo(accountInfo);
    }

    @Path("/organization")
    @PUT
    @Override
    public JsonResponse saveOrganization(OrganizationInfo organizationInfo) {
        return _saveInfo(organizationInfo);
    }

    @Path("/role")
    @PUT
    @Override
    public JsonResponse saveRole(RoleInfo roleInfo) {
        return _saveInfo(roleInfo);
    }

    /**
     * 内部保存方法，只是为了减少重复代码罢了
     *
     * @param info 界面对象
     * @return 成功还是失败信息
     */
    private JsonResponse _saveInfo(BaseInfo info) {
        try {
            if (info instanceof OrganizationInfo) {
                organizationService.saveInfo(info);
            } else if (info instanceof AccountInfo) {
                accountService.saveInfo(info);
            } else if (info instanceof RoleInfo) {
                roleService.saveInfo(info);
            }
        } catch (BreezeeException e) {
            e.printStackTrace();
            return JsonResponse.ERROR(e.getMessage());
        }
        return JsonResponse.OK();
    }

    @Path("/account/page")
    @POST
    @Override
    public JsonResponse pageAccount(AccountInfo accountInfo) {
        long t = System.currentTimeMillis();
        try {
            if ((accountInfo.getProperties().get("pageSize").toString()).equals("-1")) {
                return JsonResponse.build(accountService.listAll(accountInfo), t);
            } else {
                return JsonResponse.build(accountService.pageAll(accountInfo), t);
            }
        } catch (BreezeeException e) {
            e.printStackTrace();
            return JsonResponse.ERROR(e.getMessage());
        }
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
        return null;
    }

    @Override
    public JsonResponse enableAccount(List<String> ids, boolean enable) {
        return null;
    }

    @Override
    public JsonResponse enableAccount(AccountInfo accountInfo, boolean enable) {
        return null;
    }

    @Override
    public JsonResponse resetPassword(List<String> ids) {
        return null;
    }

    @Path("/account/code/{code}")
    @GET
    @Override
    public JsonResponse findAccountByCode(@PathParam("code") String code) {
        return JsonResponse.buildSingle(accountService.findByCode(code));
    }

    @Path("/account/{id}")
    @GET
    @Override
    public JsonResponse findAccountById(@PathParam("id") String id) {
        return JsonResponse.buildSingle(accountService.findById(id));
    }

    @Path("/organization/{id}")
    @GET
    @Override
    public JsonResponse findOrganizationById(@PathParam("id") String id) {
        return JsonResponse.buildSingle(organizationService.findById(id));
    }

    @Path("/organization/accounts")
    @POST
    @Override
    public JsonResponse saveOrgAccounts(OrganizationInfo info) {
        organizationService.saveAccounts(info);
        return JsonResponse.OK();
    }
}
