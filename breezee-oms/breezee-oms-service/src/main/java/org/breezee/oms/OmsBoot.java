/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.oms;

import org.breezee.common.dubbo.start.Startup;
import org.breezee.common.framework.ContextUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * 计划与订单服务启动类
 * <p>
 * Created by Silence on 2016/6/12.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan("org.breezee")
@ImportResource(value = {"classpath:/oms-provider.xml"})
public class OmsBoot extends Startup {

    /**
     * 启动本服务
     *
     * @param args 传入参数
     * @throws Exception 异常信息
     */
    public static void main(String[] args) throws Exception {
        ContextUtil.current = SpringApplication.run(OmsBoot.class, args);
        startup(OmsBoot.class);
    }
}
