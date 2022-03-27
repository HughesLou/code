package com.hughes.lou.lintcode.easy;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 给出一个代表网址 host 的字符串 base_url，和代表查询参数的数组 query_params，你需要返回带查询参数的完整 URL。
 * 查询参数由一些包含两个元素的数组组成，第一个元素代表参数，第二个元素代表该参数对应的值。
 * 现在需要你拼接两个部分得到完整的 URL。base_url 和查询参数字符串之间使用 ? 拼接，
 * 在查询参数的参数和值之间通过 = 拼接，各个查询参数之间使用 & 拼接。查询参数需要根据字典序排序。
 *
 * @author HughesLou
 * Created on 2022-03-27
 */
public class UrlEdcode253 implements Easy {

    /**
     * @param base_url: the string of base_url
     * @param query_params: sequence of two-element tuples by query_params
     * @return: return a url query string
     */
    public String urlencode(String base_url, List<List<String>> query_params) {
        if (query_params == null || query_params.size() == 0) {
            return base_url;
        }

        // 也可以借助TreeMap来实现排序
        Collections.sort(query_params, Comparator.comparing(o -> o.get(0)));
        StringBuffer result = new StringBuffer(base_url + "?");
        for (int i = 0; i < query_params.size(); i++) {
            if (i > 0) {
                result.append("&");
            }
            result.append(query_params.get(i).get(0)).append("=").append(query_params.get(i).get(1));
        }
        return result.toString();
    }
}
