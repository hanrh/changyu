/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.common.domain;

import java.util.List;

/**
 * 树状存储对象
 * Created by Silence on 2016/4/15.
 */
public class TreeInfo<T> extends BaseInfo {

    /**
     * 父对象
     */
    protected T parent;

    /**
     * 是否可选中
     */
    protected boolean clickable = true;

    /**
     * 存储所有的子对象
     */
    protected List<T> children = null;

    /**
     * 是否叶子节点
     */
    protected boolean leaf = true;

    protected String type = "leaf";

    public T getParent() {
        return parent;
    }

    public void setParent(T parent) {
        this.parent = parent;
    }

    public boolean isClickable() {
        return clickable;
    }

    public void setClickable(boolean clickable) {
        this.clickable = clickable;
    }

    public List<T> getChildren() {
        return children;
    }

    public void setChildren(List<T> children) {
        this.children = children;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    public String getType() {
        return isLeaf() ? "leaf" : "folder";
    }

    public void setType(String type) {
        this.type = type;
    }
}
