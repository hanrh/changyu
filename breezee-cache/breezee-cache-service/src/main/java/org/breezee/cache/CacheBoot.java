/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.cache;

import java.util.UUID;

/**
 * Created by Silence on 2016/6/6.
 */
public class CacheBoot {
    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString().replaceAll("-", ""));
    }
}
