/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.oms.api.domain;

import java.util.Date;
import java.util.List;

/**
 * 实体域：计划信息对象
 * 历史处理记录由日志进行查询
 * Created by Silence on 2016/4/26.
 */
public class PlanInfo extends FlowInfo {

    /**
     * 计划月份
     */
    protected Date month;

    /**
     * 计划执行的比例
     */
    protected Double rated;

    /**
     * 计划行，一个计划至少有一个计划行
     */
    protected List<PlanLineInfo> lineInfoList;

    public Date getMonth() {
        return month;
    }

    public void setMonth(Date month) {
        this.month = month;
    }

    public Double getRated() {
        return rated;
    }

    public void setRated(Double rated) {
        this.rated = rated;
    }

    public List<PlanLineInfo> getLineInfoList() {
        return lineInfoList;
    }

    public void setLineInfoList(List<PlanLineInfo> lineInfoList) {
        this.lineInfoList = lineInfoList;
    }
}
