/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.oms.state;

import org.breezee.common.domain.BizInfo;

/**
 * 状态信息处理类
 * //TODO:使用此枚举类处理业务
 * Created by Silence on 2016/6/11.
 */
public enum States implements State {
    ;

    @Override
    public boolean process(Context context) {
        return false;
    }
}

interface Context {

    BizInfo biz();

    State state();

    void state(State state);
}

interface State {
    /**
     * @return true to keep processing, false to read more data.
     */
    boolean process(Context context);
}
