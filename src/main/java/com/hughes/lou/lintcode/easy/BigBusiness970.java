package com.hughes.lou.lintcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.jetbrains.annotations.NotNull;

import com.hughes.lou.level.Easy;

/**
 * 给出两个数组a，b。a[i]代表第i部影片的版权费，b[i]代表第i部影片能卖的钱，
 * 现在本金k，问最后最多能赚多少钱。（每部影片只需要买一次版权，只能卖一次。）
 *
 * @author HughesLou
 * Created on 2022-04-06
 */
public class BigBusiness970 implements Easy {
    /**
     * 考虑排序后从小到大开始贪心，当然这里我们只考虑赚钱的
     *
     * @param a: The cost of the film
     * @param b: The price of the selling of the film
     * @param k: The principal
     * @return: The answer
     */
    public int bigBusiness(int[] a, int[] b, int k) {
        // 排序后从小到大开始贪心
        List<Video> list = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            list.add(new Video(a[i], b[i]));
        }
        Collections.sort(list);
        for (Video t : list) {
            if (t.price - t.cost > 0 && k >= t.cost) {
                k += t.price - t.cost;
            }
        }
        return k;
    }
}

class Video implements Comparable<Video> {
    int cost = 0;
    int price = 0;

    public Video(int cost, int price) {
        this.cost = cost;
        this.price = price;
    }

    @Override
    public int compareTo(@NotNull Video video) {
        return this.cost - video.cost;
    }
}