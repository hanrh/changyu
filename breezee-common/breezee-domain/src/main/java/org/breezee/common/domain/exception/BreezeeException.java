/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.common.domain.exception;

/**
 * 系统基础异常类
 * 供系统其他异常集成
 * Created by Silence on 2016/2/11.
 */
public class BreezeeException extends RuntimeException {

    public BreezeeException(String message) {
        super(message);
    }

    public BreezeeException(String message, Throwable cause) {
        super(message, cause);
    }
}
