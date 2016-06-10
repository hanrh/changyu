/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.facade.resource;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import org.breezee.facade.inter.IProductFacade;
import org.breezee.facade.response.JsonResponse;
import org.breezee.pcm.api.domain.ProductCustomerInfo;
import org.breezee.pcm.api.domain.ProductInfo;
import org.breezee.pcm.api.domain.ProductLimitInfo;
import org.breezee.pcm.api.domain.ProductOpenInfo;
import org.breezee.pcm.api.service.IProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.ws.rs.*;

/**
 * 产品服务对外接口
 * Created by Silence on 2016/6/10.
 */
@SuppressWarnings("unchecked")
@Service("productFacade")
@Produces(ContentType.APPLICATION_JSON_UTF_8)
@Consumes(ContentType.APPLICATION_JSON_UTF_8)
@Path("/product")
public class ProductFacadeImpl extends JsonCommonFacade implements IProductFacade {

    @Resource
    private IProductService productService;

    @Path("/customer")
    @POST
    @Override
    public JsonResponse pageCustomerProducts(ProductCustomerInfo customerInfo) {
        try {
            return JsonResponse.build(productService.pageByCustomer(customerInfo));
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResponse.ERROR(e.getMessage());
        }
    }

    @Path("/limits")
    @POST
    @Override
    public JsonResponse pageProductLimits(ProductLimitInfo limitInfo) {
        try {
            return JsonResponse.build(productService.pageByLimit(limitInfo));
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResponse.ERROR(e.getMessage());
        }
    }

    @Path("/list")
    @POST
    @Override
    public JsonResponse pageProducts(ProductInfo info) {
        return _pageAll(productService, info);
    }

    @Path("/prtLimit")
    @POST
    @Override
    public JsonResponse listLimits(ProductLimitInfo info) {
        return JsonResponse.build(productService.listLimit(info), System.currentTimeMillis());
    }

    @Path("/opens")
    @POST
    @Override
    public JsonResponse listOpens(ProductOpenInfo info) {
        return JsonResponse.build(productService.pageByOpen(info));
    }

    @Path("/customerOpens")
    @POST
    @Override
    public JsonResponse listOpensByCustomer(ProductCustomerInfo info) {
        return JsonResponse.build(productService.customerOpenProduct(info));
    }

    @Path("/{id}")
    @GET
    @Override
    public JsonResponse findProductById(@PathParam("id") String id) {
        return _findOne(productService, id, 0);
    }
}
