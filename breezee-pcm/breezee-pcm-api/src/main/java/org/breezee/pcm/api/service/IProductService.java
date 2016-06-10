/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.pcm.api.service;

import org.breezee.common.domain.IServiceLayer;
import org.breezee.common.domain.InfoPage;
import org.breezee.pcm.api.domain.ProductCustomerInfo;
import org.breezee.pcm.api.domain.ProductInfo;
import org.breezee.pcm.api.domain.ProductLimitInfo;
import org.breezee.pcm.api.domain.ProductOpenInfo;

import java.util.List;

/**
 * 服务域：产品管理服务接口
 * Created by Silence on 2016/6/9.
 */
public interface IProductService<E> extends IServiceLayer<ProductInfo, E> {

    @Override
    default Class<ProductInfo> getInfoClass() {
        return ProductInfo.class;
    }

    /**
     * 分页获取所有的客户限售数据
     *
     * @param customerInfo 客户限售对象
     * @return 分页数据
     */
    InfoPage pageByCustomer(ProductCustomerInfo customerInfo);

    /**
     * 分页获取所有的限售数据
     *
     * @param info 限售对象
     * @return 分页数据
     */
    InfoPage pageByLimit(ProductLimitInfo info);

    /**
     * 分页获取开放清单产品数据
     *
     * @param info 开放清单对象
     * @return 分页数据
     */
    InfoPage pageByOpen(ProductOpenInfo info);

    /**
     * 获取指定的限售数据列表
     *
     * @param info 限售对象
     * @return 列表数据
     */
    List<ProductLimitInfo> listLimit(ProductLimitInfo info);

    /**
     * 分页获取指定用户的开放清单产品
     *
     * @param info 查询条件
     * @return 分页数据
     */
    InfoPage customerOpenProduct(ProductCustomerInfo info);

}
