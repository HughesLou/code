package com.hughes.lou.lintcode.easy;

import java.util.ArrayList;
import java.util.List;

import com.hughes.lou.level.Easy;

/**
 * 有一个商品列表，该列表是由 L1、L2两个子列表拼接而成。当用户浏览并翻页时，需要从列表
 * L1、L2中获取商品进行展示。展示规则如下：
 * 用户可以进行多次翻页，用 offset 表示用户已经浏览过的商品数量。比如，
 * offset是4，表示用户已经看了4个商品。
 * n表示一个页面可以展示的商品数量。
 * 展示商品时首先使用列表L1，如果列表L1不够，再从列表L2中选取商品。
 * 从列表L2中补全商品时，也可能存在数量不足的情况。
 * 给定offset，n，列表 L1和L2的长度。请根据上述规则，计算列表
 * L1和L2中哪些商品在当前页面被展示了。
 * <p>
 * 你需要根据notice里的规则输出两个区间。
 *
 * @author HughesLou
 * Created on 2022-03-28
 */
public class ProductList306 implements Easy {

    /**
     * @param offset: the number of items that the customer has viewed
     * @param n: the number of items that can be displayed on a page
     * @param len1: the length of L1
     * @param len2: the length of L2
     * @return: returns the intervals of goods displayed in L1 and L2
     */
    public List<Integer> ProductList(int offset, int n, int len1, int len2) {
        List<Integer> result = new ArrayList<>();
        result.add(Math.min(offset, len1));
        result.add(Math.min(offset + n, len1));
        result.add(Math.max(offset - len1, 0));
        result.add(Math.min(Math.max(offset + n - len1, 0), len2));
        return result;
    }
}
