package com.hughes.lou.lintcode.easy;

import java.util.List;

import com.hughes.lou.level.Easy;
import com.hughes.lou.model.NestedInteger;

/**
 * 给一个嵌套的整数列表, 返回列表中所有整数由它们的深度加权后的总和.
 * 每一个元素可能是一个整数或一个列表(其元素也可能是整数或列表)
 *
 * @author HughesLou
 * Created on 2022-03-31
 */
public class NestedListWeightSum551 implements Easy {

    public int depthSum(List<NestedInteger> nestedList) {
        return helper(nestedList, 1);
    }

    private int helper(List<NestedInteger> nestedList, int depth) {
        if (nestedList == null || nestedList.size() == 0) {
            return 0;
        }

        int sum = 0;
        for (NestedInteger ele : nestedList) {
            if (ele.isInteger()) {
                sum += ele.getInteger() * depth;
            } else {
                sum += helper(ele.getList(), depth + 1);
            }
        }

        return sum;
    }
}