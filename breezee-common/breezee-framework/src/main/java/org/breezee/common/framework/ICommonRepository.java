/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.common.framework;

import com.sun.istack.internal.NotNull;
import javafx.util.Callback;
import org.breezee.common.domain.BaseInfo;
import org.breezee.common.domain.IRepository;
import org.breezee.common.domain.InfoList;
import org.breezee.common.domain.InfoPage;
import org.breezee.common.domain.exception.BreezeeException;
import org.breezee.common.domain.exception.EntityNotFoundException;
import org.breezee.common.framework.page.PageInfo;
import org.breezee.common.framework.page.PageResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 通用的数据库查询类
 * Just for DB
 * Created by Silence on 2016/5/31.
 */
@NoRepositoryBean
public interface ICommonRepository<T extends BaseEntity, R extends BaseInfo, ID extends String>
        extends JpaRepository<T, ID>, JpaSpecificationExecutor<T>, IRepository<R> {

    /**
     * 根据code查找对象
     *
     * @param code
     * @return 指定code的对象
     */
    T findByCode(String code);

    /**
     * 查找唯一的对象
     *
     * @param obj 主键值
     * @param cla 返回对象类型
     * @param f   属性代码
     * @return 业务对象
     * @throws EntityNotFoundException
     */
    @Override
    default R findUnique(Object obj, Class<R> cla, int f) throws EntityNotFoundException {
        T t = null;
        if (f == 0) {
            t = this.findOne((ID) obj);
        } else if (f == 1) {
            t = this.findByCode(obj.toString());
        }
        if (t != null)
            return (R) t.toInfo(cla);
        throw new EntityNotFoundException(obj + "");
    }

    /**
     * 列表查询
     *
     * @param r   查询条件
     * @param cla 返回对象的类型
     * @return 列表
     * @throws BreezeeException
     */
    @Override
    default InfoList<R> listAll(@NotNull R r, Class<R> cla) throws BreezeeException {
        r.checkQuery(r.getProperties());
        List<T> l = this.findAll(DynamicSpecifications.createSpecification(r.getProperties()), new Sort(Sort.Direction.DESC, "updateTime"));
        return new InfoList<>(l, param -> {
            return (R) param.toInfo(cla);
        });
    }

    /**
     * 分页查询
     *
     * @param r   查询条件
     * @param cla 返回对象的类型
     * @return 分页结果
     * @throws BreezeeException
     */
    @Override
    default InfoPage pageAll(@NotNull R r, Class<R> cla) throws BreezeeException {
        r.checkQuery(r.getProperties());
        PageInfo pageInfo = new PageInfo(r.getProperties());
        pageInfo.setSort(new Sort(Sort.Direction.DESC, "updateTime"));
        Page<T> page = this.findAll(DynamicSpecifications.createSpecification(r.getProperties()), pageInfo);
        return new PageResult<>(page, param -> param.toInfo(cla)).copyTo();
    }

    /**
     * 默认保存信息对象的方法
     *
     * @param r        实体域对象
     * @param cla      持久域对象
     * @param callback 回调方法，处理信息对象
     * @return 处理后的实体域
     * @throws BreezeeException
     */
    @SuppressWarnings("unchecked")
    @Override
    default R saveInfo(R r, Class<?> cla, Callback<R, ?>... callback) throws BreezeeException {
        T t;
        if (StringUtils.isEmpty(r.getId())) {
            t = this.findByCode(r.getCode());
            if (t != null) throw new BreezeeException("code:" + r.getCode());
            try {
                t = (T) cla.newInstance();
            } catch (Exception e) {
                throw new BreezeeException(e.getMessage(), e);
            }
        } else {
            t = this.findOne((ID) r.getId());
            if (t == null) throw new BreezeeException(r.getClass().getName() + "@" + r.getId() + " does not exist");
        }
        for (Callback<R, ?> rCallback : callback) {
            try {
                rCallback.call(r);
            } catch (Exception e) {
                e.printStackTrace();
                throw new BreezeeException(e.getMessage(), e);
            }
        }
        try {
            t.parseInfo(r);
            this.saveAndFlush(t);
            r.setId(t.getId());
        } catch (Exception e) {
            e.printStackTrace();
            throw new BreezeeException(e.getMessage(), e);
        }
        return r;
    }

    /**
     * 删除指定主键的对象
     *
     * @param obj 主键值
     */
    @Override
    default void deleteById(Object obj) throws BreezeeException {
        try {
            this.delete(this.findOne((ID) obj));
        } catch (Exception e) {
            e.printStackTrace();
            throw new BreezeeException(e.getMessage(), e);
        }
    }

    /**
     * 根据查询条件获取查询的条目数
     *
     * @param r 查询条件
     * @return 查询的结果数
     * @throws BreezeeException
     */
    @Override
    default long count(R r) throws BreezeeException {
        return this.count(DynamicSpecifications.createSpecification(r.getProperties()));
    }
}
