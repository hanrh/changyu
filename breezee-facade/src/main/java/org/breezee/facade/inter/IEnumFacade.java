/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.facade.inter;

import org.breezee.common.domain.IFacadeLayer;
import org.breezee.facade.response.Response;
import org.breezee.sysmgr.api.domain.EnumInfo;

/**
 * 枚举值管理的Facade接口
 * Created by Silence on 2016/5/31.
 */
public interface IEnumFacade extends IFacadeLayer {

    /**
     * 枚举值保存
     *
     * @param info 枚举信息
     * @return 保存后的枚举信息
     */
    Response<EnumInfo> saveEnum(EnumInfo info);

    /**
     * 根据id查找枚举对象
     *
     * @param id 指定ID
     * @return 查找到的对象
     */
    Response<EnumInfo> findById(String id);

    /**
     * 根据ID删除对象
     *
     * @param id 指定ID
     * @return 处理结果
     */
    Response<EnumInfo> deleteById(String id);

    /**
     * 列表展现枚举信息
     *
     * @param enumInfo 查询条件
     * @return 列表集
     */
    Response<EnumInfo> list(EnumInfo enumInfo);


}
