/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.facade.inter;

import org.breezee.common.domain.IFacadeLayer;
import org.breezee.facade.response.Response;
import org.breezee.pcm.api.domain.ProductCustomerInfo;
import org.breezee.pcm.api.domain.ProductInfo;
import org.breezee.pcm.api.domain.ProductLimitInfo;
import org.breezee.pcm.api.domain.ProductOpenInfo;

/**
 * 产品服务对外暴露的接口
 * Created by Silence on 2016/6/10.
 */
public interface IProductFacade extends IFacadeLayer {

    /**
     * 根据指定ID获取产品信息
     *
     * @param id 指定产品ID
     * @return 产品信息
     */
    Response<ProductInfo> findProductById(String id);

    /**
     * 获取客户的可售产品
     *
     * @param customerInfo 客户信息
     * @return 可售产品列表
     */
    Response<ProductInfo> pageCustomerProducts(ProductCustomerInfo customerInfo);

    /**
     * 获取省份的可售列表
     *
     * @param limitInfo 产品限售
     * @return 分页产品
     */
    Response<ProductInfo> pageProductLimits(ProductLimitInfo limitInfo);

    /**
     * 获取所有产品列表
     *
     * @param info 产品信息
     * @return 分页产品
     */
    Response<ProductInfo> pageProducts(ProductInfo info);

    /**
     * 获取产品限售信息
     *
     * @param info 限售查询条件
     * @return 结果集
     */
    Response<ProductLimitInfo> listLimits(ProductLimitInfo info);

    /**
     * 获取开放清单信息
     *
     * @param info 查询条件
     * @return 结果集
     */
    Response<ProductOpenInfo> listOpens(ProductOpenInfo info);

    /**
     * 获取指定用户，指定范围的开放清单
     *
     * @param info 查询条件
     * @return 结果集
     */
    Response<ProductOpenInfo> listOpensByCustomer(ProductCustomerInfo info);
}
