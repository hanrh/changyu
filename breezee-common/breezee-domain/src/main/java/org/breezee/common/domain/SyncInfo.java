/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.common.domain;

import java.util.Date;

/**
 * 需要与外部系统同步的对象
 * Created by Silence on 2016/6/9.
 */
public class SyncInfo extends BaseInfo {

    /**
     * 同步时间，假设存在同步的话
     */
    protected Date syncTime;

    /**
     * 同步结果
     */
    protected Boolean syncResult;

    /**
     * 结果信息
     */
    protected String syncMessage;

    /**
     * 第三方系统标识
     */
    protected String dn;

    public Date getSyncTime() {
        return syncTime;
    }

    public void setSyncTime(Date syncTime) {
        this.syncTime = syncTime;
    }

    public Boolean getSyncResult() {
        return syncResult;
    }

    public void setSyncResult(Boolean syncResult) {
        this.syncResult = syncResult;
    }

    public String getSyncMessage() {
        return syncMessage;
    }

    public void setSyncMessage(String syncMessage) {
        this.syncMessage = syncMessage;
    }

    public String getDn() {
        return dn;
    }

    public void setDn(String dn) {
        this.dn = dn;
    }
}
