/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved. 
 */

package org.breezee.facade.resource;

import javafx.util.Callback;
import org.breezee.common.domain.BaseInfo;
import org.breezee.common.domain.IServiceLayer;
import org.breezee.common.domain.exception.BreezeeException;
import org.breezee.common.domain.exception.EntityNotFoundException;
import org.breezee.facade.response.JsonResponse;

/**
 * Created by Silence on 2016/6/9.
 */
public class JsonCommonFacade {
    /**
     * 只是供子类调用使用
     * 内部使用, 保存方法，只是为了减少重复代码罢了
     *
     * @param service  管理服务
     * @param info     界面传入对象
     * @param callback 回调方法
     * @return 返回界面对象
     */
    protected JsonResponse _saveInfo(IServiceLayer service, BaseInfo info, Callback... callback) {
        try {
            service.saveInfo(info, callback);
        } catch (BreezeeException e) {
            e.printStackTrace();
            return JsonResponse.ERROR(e.getMessage());
        }
        return JsonResponse.OK();
    }

    /**
     * 查找唯一对象.
     * 内部使用,不建议供外部调用
     *
     * @param service 服务
     * @param id      唯一标识，可以是Id，也可以是code
     * @param type    id:0, code:1
     * @return 界面对象
     */
    protected JsonResponse _findOne(IServiceLayer service, String id, int type) {
        BaseInfo info = null;
        try {
            if (type == 0)
                info = service.findById(id);
            else if (type == 1)
                info = service.findByCode(id);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return JsonResponse.ERROR(e.getMessage());
        }
        return JsonResponse.buildSingle(info);
    }

    /**
     * 内部列表查询方法
     *
     * @param service 管理服务
     * @param info    如果pagesize为-1，则不分页
     * @return 界面对象
     */
    protected JsonResponse _pageAll(IServiceLayer service, BaseInfo info) {
        long t = System.currentTimeMillis();
        try {
            if (info.getProperties().get("pageSize") == null ||
                    (info.getProperties().get("pageSize").toString()).equals("-1")) {
                return JsonResponse.build(service.listAll(info), t);
            } else {
                return JsonResponse.build(service.pageAll(info), t);
            }
        } catch (BreezeeException e) {
            e.printStackTrace();
            return JsonResponse.ERROR(e.getMessage());
        }
    }

    protected JsonResponse _delete(IServiceLayer service, String id) {
        try {
            service.deleteById(id);
        } catch (BreezeeException e) {
            return JsonResponse.ERROR(e.getMessage());
        }
        return JsonResponse.OK();
    }
}
