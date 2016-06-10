/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.facade.resource;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import org.breezee.crm.api.domain.UserInfo;
import org.breezee.crm.api.service.IUserService;
import org.breezee.facade.inter.IUserFacade;
import org.breezee.facade.response.JsonResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.ws.rs.*;

/**
 * 用户服务
 * Created by Silence on 2016/6/10.
 */
@SuppressWarnings("unchecked")
@Service("userFacade")
@Produces(ContentType.APPLICATION_JSON_UTF_8)
@Consumes(ContentType.APPLICATION_JSON_UTF_8)
@Path("/user")
public class UserFacadeImpl extends JsonCommonFacade implements IUserFacade {

    @Resource
    private IUserService userService;

    @Path("/page")
    @POST
    @Override
    public JsonResponse pageUsers(UserInfo info) {
        return _pageAll(userService, info);
    }

    @Path("/")
    @PUT
    @Override
    public JsonResponse saveUser(UserInfo info) {
        return _saveInfo(userService, info);
    }

    @Path("/{id}")
    @GET
    @Override
    public JsonResponse findUserById(@PathParam("id") String id) {
        return _findOne(userService, id, 0);
    }
}
