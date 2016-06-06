/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.facade.resource;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import org.breezee.common.domain.exception.BreezeeException;
import org.breezee.facade.inter.IEnumFacade;
import org.breezee.facade.response.JsonResponse;
import org.breezee.sysmgr.api.domain.EnumInfo;
import org.breezee.sysmgr.api.service.IEnumService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.ws.rs.*;

/**
 * 枚举服务的资源类
 * <p>
 * Created by Silence on 2016/5/31.
 */
@SuppressWarnings("unchecked")
@Service("enumFacade")
@Produces(ContentType.APPLICATION_JSON_UTF_8)
@Consumes(ContentType.APPLICATION_JSON_UTF_8)
@Path("/enum")
public class EnumFacadeImpl implements IEnumFacade {

    @Resource
    private IEnumService enumService;

    @Path("/")
    @PUT
    @Override
    public JsonResponse saveEnum(EnumInfo info) {
        try {
            enumService.saveInfo(info);
        } catch (RuntimeException e) {
            return JsonResponse.ERROR(e.getMessage());
        }
        return JsonResponse.buildSingle(info);
    }

    @Path("/{id}")
    @GET
    @Override
    public JsonResponse findById(@PathParam("id") String id) {
        return JsonResponse.buildSingle(enumService.findById(id));
    }

    @Path("/{id}")
    @DELETE
    @Override
    public JsonResponse deleteById(@PathParam("id") String id) {
        try {
            enumService.deleteById(id);
        } catch (BreezeeException e) {
            return JsonResponse.ERROR(e.getMessage());
        }
        return JsonResponse.OK();
    }

    @Path("/list")
    @POST
    @Override
    public JsonResponse list(EnumInfo enumInfo) {
        return JsonResponse.build(enumService.listAll(enumInfo), System.currentTimeMillis());
    }

}
