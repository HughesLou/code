package com.hughes.lou.lintcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

import org.apache.commons.lang3.ArrayUtils;

import com.hughes.lou.lintcode.level.Easy;
import com.hughes.lou.lintcode.utils.ObjectMapperUtils;

/**
 * 在一个二维平面上有许多城市，所有的城市都有着自己的名字c[i]c[i]，以及位置坐标(x[i],y[i])(x[i],y[i])（都为整数）。
 * 有q组询问，每组询问给出一个城市名字，你需要回答离该城市距离最近的，x相同或者y相同的城市名称。
 *
 * @author HughesLou
 * Created on 2022-03-27
 */
public class ClosestCity280 implements Easy {
    /**
     * 考查HashMap的应用。建立两种映射：（城市名 -> 城市Id）和 （x/y坐标 -> 城市Id集合）
     *
     * @param x: an array of integers, the x coordinates of each city[i]
     * @param y: an array of integers, the y coordinates of each city[i]
     * @param c: an array of strings that represent the names of each city[i]
     * @param q: an array of strings that represent the names of query locations
     * @return: the closest city for each query
     */
    public String[] NearestNeighbor(int[] x, int[] y, String[] c, String[] q) {
        Map<String, Integer> cityIndexMap = new HashMap<>();
        Map<Integer, Set<Integer>> xMap = new HashMap<>(), yMap = new HashMap<>();
        String[] result = new String[q.length];
        for (int i = 0; i < x.length; i++) {
            cityIndexMap.put(c[i], i);

            Set<Integer> xSet = xMap.containsKey(x[i]) ? xMap.get(x[i]) : new HashSet<>();
            xSet.add(i);
            xMap.put(x[i], xSet);

            Set<Integer> ySet = yMap.containsKey(y[i]) ? yMap.get(y[i]) : new HashSet<>();
            ySet.add(i);
            yMap.put(y[i], ySet);
        }

        for (int i = 0; i < q.length; i++) {
            int index = cityIndexMap.get(q[i]);
            Set<Integer> xSet = xMap.get(x[index]);
            int minDist = Integer.MAX_VALUE, id = -1;
            for (int j : xSet) {
                if (j != index) {
                    int dist = Math.abs(y[index] - y[j]);
                    if (dist < minDist) {
                        minDist = dist;
                        id = j;
                    } else if (dist == minDist && c[j].compareTo(c[id]) < 0) {
                        id = j;
                    }
                }
            }

            Set<Integer> ySet = yMap.get(y[index]);
            for (int k : ySet) {
                if (k != index) {
                    int dist = Math.abs(x[index] - x[k]);
                    if (dist < minDist) {
                        minDist = dist;
                        id = k;
                    } else if (dist == minDist && c[k].compareTo(c[id]) < 0) {
                        id = k;
                    }
                }
            }
            if (id == -1) {
                result[i] = "NONE";
            } else {
                result[i] = c[id];
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String sx = scanner.nextLine();
        String sy = scanner.nextLine();
        String sc = scanner.nextLine();
        String sq = scanner.nextLine();

        Integer[] x = Stream.of(sx.split(" ")).map(Integer::valueOf).toArray(Integer[]::new);
        Integer[] y = Stream.of(sy.split(" ")).map(Integer::valueOf).toArray(Integer[]::new);
        String[] c = Stream.of(sc.split(" ")).toArray(String[]::new);
        String[] q = Stream.of(sq.split(" ")).toArray(String[]::new);

        System.out.println(ObjectMapperUtils.toJSON(
                new ClosestCity280().NearestNeighbor(ArrayUtils.toPrimitive(x), ArrayUtils.toPrimitive(y), c, q)));
    }
}
