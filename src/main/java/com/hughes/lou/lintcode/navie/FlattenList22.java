package com.hughes.lou.lintcode.navie;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hughes.lou.lintcode.level.Naive;
import com.hughes.lou.lintcode.model.NestedInteger;

/**
 * 给定一个列表，该列表中的每个元素要么是个列表，要么是整数。将其变成一个只包含整数的简单列表。
 *
 * @author HughesLou
 * Created on 2022-03-17
 */
public class FlattenList22 implements Naive {

    public List<Integer> flattenList(List<NestedInteger> nestedList) {
        List<Integer> result = new ArrayList<>();
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                result.add(nestedInteger.getInteger());
            } else {
                result.addAll(flattenList(nestedInteger.getList()));
            }
        }
        return result;
    }

    public List<Integer> flatten(List<NestedInteger> nestedList) {
        boolean isFlat = true;
        List<NestedInteger> ls = nestedList;
        while (isFlat) {
            isFlat = false;
            List<NestedInteger> newLs = new ArrayList<>();
            for (NestedInteger ni : ls) {
                if (ni.isInteger()) {
                    newLs.add(ni);
                } else {
                    newLs.addAll(ni.getList());
                    isFlat = true;
                }
            }
            ls = newLs;
        }
        List<Integer> r = new ArrayList<>();
        for (NestedInteger ni : ls) {
            r.add(ni.getInteger());
        }
        return r;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        FlattenList22 implementStrStr = new FlattenList22();
    }
}
