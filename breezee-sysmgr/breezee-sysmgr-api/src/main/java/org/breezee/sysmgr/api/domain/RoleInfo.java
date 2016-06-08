/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.sysmgr.api.domain;

import org.breezee.common.domain.BaseInfo;

/**
 * 实体域：角色信息对象
 * Created by Silence on 2016/4/26.
 */
public class RoleInfo extends BaseInfo {

    /**
     * 权限串
     */
    protected String permits;

    public String getPermits() {
        return permits;
    }

    public void setPermits(String permits) {
        this.permits = permits;
    }
}
