/*
 * Copyright (C) 2017 Hughes Lou, Inc. All Rights Reserved.
 */

package com.hughes.lou.lintcode;

/**
 * Created by luzhiwei01 on 2017/12/16 22:25.
 */
public class Utils {
    public static <T> void swap(T a, T b) {
        T temp = a;
        a = b;
        b = temp;
    }
}
