/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.common.domain;

import javafx.util.Callback;
import org.breezee.common.domain.exception.BreezeeException;
import org.breezee.common.domain.exception.EntityNotFoundException;

import java.util.List;

/**
 * 数据持久化的基类
 * Created by Silence on 2016/6/5.
 */
public interface IRepository<R> {

    void deleteById(Object obj);

    R findUnique(Object obj, Class<R> cla, int f) throws EntityNotFoundException;

    List<R> listAll(R r, Class<R> cla) throws BreezeeException;

    InfoPage pageAll(R r, Class<R> cla) throws BreezeeException;

    @SuppressWarnings("unchecked")
    R saveInfo(R r, Class<?> cla, Callback<R, ?>... callback) throws BreezeeException;

    /**
     * 根据查询条件获取查询的条目数
     *
     * @param r 查询条件
     * @return 查询的结果数
     * @throws BreezeeException
     */
    long count(R r) throws BreezeeException;

}
