/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.facade.resource;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import org.breezee.crm.api.domain.CustomerInfo;
import org.breezee.crm.api.service.ICustomerService;
import org.breezee.facade.inter.ICustomerFacade;
import org.breezee.facade.response.JsonResponse;
import org.breezee.facade.response.Response;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.ws.rs.*;

/**
 * 客户服务接口实现类
 * Created by Silence on 2016/6/10.
 */
@SuppressWarnings("unchecked")
@Service("customerFacade")
@Produces(ContentType.APPLICATION_JSON_UTF_8)
@Consumes(ContentType.APPLICATION_JSON_UTF_8)
@Path("/customer")
public class CustomerFacadeImpl extends JsonCommonFacade implements ICustomerFacade {

    @Resource
    private ICustomerService customerService;

    @Path("/page")
    @POST
    @Override
    public JsonResponse pageCustomer(CustomerInfo info) {
        return _pageAll(customerService, info);
    }

    @Path("/{id}")
    @GET
    @Override
    public Response<CustomerInfo> findCustomerById(@PathParam("id") String id) {
        return _findOne(customerService, id, 0);
    }
}
