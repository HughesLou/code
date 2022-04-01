package com.hughes.lou.lintcode.easy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 给一个用户看过的电影的列表信息 graph， graph[i] 表示第 i 个用户看过的电影。
 * 为每个用户推荐他可能喜欢的其他电影。
 * 假如某个用看过的电影有 A，B，C：那么我们在看过电影 A，B 或者 C 的人中查看这些人看过的电影有哪些，
 * 将出现频率最高的最多前5个电影推荐给该用户，被推荐的电影需要按照出现频率从高到低排序，相同频率电影按照序号大小排序。
 *
 * @author HughesLou
 * Created on 2022-03-31
 */
public class MovieRecommendation506 implements Easy {

    /**
     * @return: nothing
     */
    public List<List<Integer>> minMalwareSpread(List<List<Integer>> graph) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        int n = graph.size();
        // 假设出现的电影id范围 1~99
        int[][] ans = new int[100][n];
        int[][] vis = new int[n][100];
        // userId+movieId维度的数组
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < graph.get(i).size(); j++) {
                int movieId = graph.get(i).get(j);
                ans[movieId][i] = 1;
                vis[i][movieId] = 1;
            }
        }

        for (int user = 0; user < n; user++) {
            int[] recommendMovie = new int[100];
            for (int movieIndex = 0; movieIndex < graph.get(user).size(); movieIndex++) {
                for (int otherUser = 0; otherUser < n; otherUser++) {
                    if (ans[graph.get(user).get(movieIndex)][otherUser] == 0) {
                        continue;
                    }
                    if (otherUser == user) {
                        continue;
                    }
                    // 用户 user 和 otherUser 都看过电影 graph.get(user).get(movieIndex)，找出用户 otherUser 看过的其他电影
                    for (int l = 0; l < graph.get(otherUser).size(); l++) {
                        // 对用户 otherUser 看过的电影，都进行+1
                        recommendMovie[graph.get(otherUser).get(l)]++;
                    }
                }
            }
            recommendMovie[0] = -1;
            int[] v = new int[100];
            List<Integer> tt = new LinkedList<>();
            for (int j = 0, d = 9999, id = 0; j < 5; j++, id = 0) {
                for (int movieId = 1; movieId <= 80; movieId++) {
                    // 用户user看过电影k，或者和电影k没有交集
                    if (vis[user][movieId] == 1 || recommendMovie[movieId] == 0) {
                        continue;
                    }
                    if (d >= recommendMovie[movieId] && recommendMovie[movieId] > recommendMovie[id]) {
                        if (v[movieId] == 1) {
                            continue;
                        }
                        id = movieId;
                    }
                }
                if (id > 0) {
                    d = recommendMovie[id];
                    v[id] = 1;
                    tt.add(id);
                } else {
                    break;
                }
            }
            res.add(tt);
        }
        return res;
    }

    public List<List<Integer>> minMalwareSpread1(List<List<Integer>> graph) {
        List<List<Integer>> result = new ArrayList<>();
        int userCount = graph.size();
        int maxMovieId = graph.stream().map(list -> list.stream().max(Comparator.comparingInt(id -> id)).orElse(0))
                .max(Comparator.comparingInt(id -> id)).orElse(0);
        int[][] userMovie = new int[userCount][maxMovieId + 1];

        for (int i = 0; i < userCount; i++) {
            for (int j = 0; j < graph.get(i).size(); j++) {
                int movie = graph.get(i).get(j);
                userMovie[i][movie] = 1;
            }
        }

        for (int user = 0; user < userCount; user++) {
            // Note: 这里按照提交答案的情况看，不按user维度去重
            //            Set<Integer> otherUserSet = new HashSet<>();
            List<Integer> otherUserList = new ArrayList<>();
            for (int movie = 1; movie <= maxMovieId; movie++) {
                if (userMovie[user][movie] == 1) {
                    for (int otherUser = 0; otherUser < userCount; otherUser++) {
                        if (otherUser != user && userMovie[otherUser][movie] == 1) {
                            otherUserList.add(otherUser);
                        }
                    }
                }
            }

            Map<Integer, Integer> movieCount = new HashMap<>();
            for (Integer otherUser : otherUserList) {
                for (int movie = 1; movie <= maxMovieId; movie++) {
                    if (userMovie[user][movie] != 1 && userMovie[otherUser][movie] == 1) {
                        movieCount.put(movie, movieCount.getOrDefault(movie, 0) + 1);
                    }
                }
            }

            result.add(movieCount.entrySet().stream().sorted(comparator()).limit(5)
                    .map(Map.Entry::getKey).collect(java.util.stream.Collectors.toList()));
        }
        return result;
    }

    private Comparator<Map.Entry<Integer, Integer>> comparator() {
        return (a, b) -> {
            if (a.getValue() == b.getValue()) {
                return a.getKey().compareTo(b.getKey());
            } else {
                return b.getValue().compareTo(a.getValue());
            }
        };
    }
}