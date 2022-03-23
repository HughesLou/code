package com.hughes.lou.lintcode.sort;

import java.util.List;

/**
 * @author HughesLou
 * Created on 2022-03-22
 */
public interface Sort {

    default int[] sort(int[] array) {
        return array;
    }

    default List<Integer> sort(List<Integer> list) {
        return list;
    }
}
