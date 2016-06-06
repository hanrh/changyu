/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.facade.response;

import org.breezee.common.domain.BaseInfo;
import org.breezee.common.domain.InfoPage;

import java.io.Serializable;
import java.util.Collection;

/**
 * 返回给页面调用的json
 *
 * @author Zhong, An-Jing
 */
public final class JsonResponse<T extends Serializable> implements Response {

    private long total = 1;

    private boolean success = true;

    private String msg = "Success";

    /**
     * 返回列表时，使用此
     */
    private Collection<T> rows;

    /**
     * 返回单个字段时候，使用此
     */
    private T value;

    /**
     * 开始时间
     */
    private long start;

    /**
     * 结束时间
     */
    private long end;

    private long slipTime;

    private JsonResponse(long total, boolean success, Collection<T> rows) {
        this(total, success, rows, -1);
    }

    private JsonResponse(long total, boolean success, Collection<T> rows, long start) {
        this.total = total;
        this.success = success;
        this.rows = rows;
        this.start = start;
        this.end = System.currentTimeMillis();
    }

    private JsonResponse(boolean success, T value) {
        this(success, value, -1);
    }

    private JsonResponse(boolean success, T value, long start) {
        this.success = success;
        this.value = value;
        this.start = start;
        this.end = System.currentTimeMillis();
    }

    public static <T extends BaseInfo> JsonResponse build(InfoPage infoPage, long start) {
        return new JsonResponse<T>(infoPage.getTotal(), true, (Collection) infoPage.getContent(), start);
    }

    public static <T extends Serializable> JsonResponse build(InfoPage infoPage) {
        return new JsonResponse<T>(infoPage.getTotal(), true, (Collection) infoPage.getContent(), -1);
    }

    public static <T extends Serializable> JsonResponse build(Collection<T> values, long start) {
        return new JsonResponse<T>(values.size(), true, values, start);
    }

    public static <T extends Serializable> JsonResponse build(Collection<T> values) {
        return new JsonResponse<T>(values.size(), true, values);
    }

    public static <T extends Serializable> JsonResponse build(long total, Collection<T> values) {
        return new JsonResponse<T>(total, true, values);
    }

    public static <T extends Serializable> JsonResponse build(long total, Collection<T> values, long start) {
        return new JsonResponse<T>(total, true, values, start);
    }

    public static <T extends Serializable> JsonResponse buildSingle(T obj) {
        return new JsonResponse<T>(true, obj);
    }

    public static <T extends Serializable> JsonResponse buildSingle(T obj, long start) {
        return new JsonResponse<T>(true, obj, start);
    }

    public static <T extends Serializable> JsonResponse OK() {
        return new JsonResponse<T>(true, null);
    }

    public static <T extends Serializable> JsonResponse ERROR(String error) {
        return new JsonResponse<T>(false, null).buildMsg(error);
    }

    public JsonResponse buildMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public void clear() {
        this.success = true;
        msg = "操作成功.";
        this.total = 0;
        this.rows.clear();
        this.value = null;
    }

    public long getTotal() {
        return total;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMsg() {
        return msg;
    }

    public Collection<T> getRows() {
        return rows;
    }

    public T getValue() {
        return value;
    }

    public long getStart() {
        return start;
    }

    public long getEnd() {
        return end;
    }

    public long getSlipTime() {
        return (end - start);
    }
}
