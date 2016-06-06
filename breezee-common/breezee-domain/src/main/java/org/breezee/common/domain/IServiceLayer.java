/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.common.domain;

import com.sun.istack.internal.NotNull;
import javafx.util.Callback;
import org.breezee.common.domain.constants.InfoStatusEnum;
import org.breezee.common.domain.exception.BreezeeException;
import org.breezee.common.domain.exception.EntityNotFoundException;

import java.util.List;

/**
 * 服务层高度抽象接口
 * 提供：保存，删除，按ID查找，按Code查找，列表查询，分页查询，条目数，状态更新
 * Created by Silence on 2016/4/15.
 */
public interface IServiceLayer<T extends BaseInfo, E> {

    /**
     * 持久化对象
     *
     * @return 持久域对象
     */
    IRepository<T> getRepository();

    /**
     * 获取持久域的类型
     *
     * @return 持久域类型
     */
    Class<E> getEntityClass();

    /**
     * 我不想把这个类放到baseEntity中实现子类继承的原因，是因为service类是单例
     * 获取实体域的类型
     *
     * @return 实体域类型
     */
    Class<T> getInfoClass();

    /**
     * 保存领域对象
     *
     * @param t        需要保存的对象
     * @param callback 回调函数
     * @return 保存后的对象
     * @throws BreezeeException
     */
    @SuppressWarnings("unchecked")
    default T saveInfo(T t, Callback<T, E>... callback) throws BreezeeException {
        return getRepository().saveInfo(t, getEntityClass(), callback);
    }

    /**
     * 删除指定主键的领域对象
     *
     * @param id 主键值
     * @throws BreezeeException
     */
    default void deleteById(String id) throws BreezeeException {
        if (id != null && id.trim().length() > 0)
            getRepository().deleteById(id);
    }

    /**
     * 获取指定主键的领域对象
     *
     * @param id 主键值
     * @return 返回结果
     * @throws EntityNotFoundException
     */
    default T findById(String id) throws EntityNotFoundException {
        return getRepository().findUnique(id, getInfoClass(), 0);
    }

    /**
     * 获取指定业务主键的领域对象
     *
     * @param code 业务主键值
     * @return 返回查询结果
     * @throws EntityNotFoundException
     */
    default T findByCode(String code) throws EntityNotFoundException {
        return getRepository().findUnique(code, getInfoClass(), 1);
    }

    /**
     * 根据条件获取领域对象列表
     * 查询条件作为BaseInfo的properties属性存在，以为了做校验
     *
     * @param t 带查询条件的对象
     * @return 返回列表对象
     * @throws BreezeeException
     */
    default List<T> listAll(@NotNull T t) throws BreezeeException {
        return getRepository().listAll(t, getInfoClass());
    }

    /**
     * 分页获取指定条件的领域对象集合
     * 查询条件作为BaseInfo的properties属性存在，以为了做校验
     *
     * @param t 带查询条件的对象
     * @return 分页结果
     * @throws BreezeeException
     */
    default InfoPage pageAll(@NotNull T t) throws BreezeeException {
        return getRepository().pageAll(t, getInfoClass());
    }

    /**
     * 获取指定条件的集合数目
     *
     * @param t 查询条件
     * @return 条数
     * @throws BreezeeException 异常
     */
    default long count(@NotNull T t) throws BreezeeException {
        return getRepository().count(t);
    }

    /**
     * 更新指定领域对象的状态
     *
     * @param id     对象唯一标识
     * @param status 状态值
     * @throws BreezeeException 异常
     */
    default void updateStatus(String id, InfoStatusEnum status) throws BreezeeException {
        T t = findById(id);
        t.setStatus(status.getValue());
        this.saveInfo(t);
    }
}
