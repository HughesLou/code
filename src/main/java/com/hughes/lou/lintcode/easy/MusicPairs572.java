package com.hughes.lou.lintcode.easy;

import java.util.HashMap;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 给定一些音乐的时长，我们想从中选两个不同的歌曲，使得他们的总时长是60的倍数，请计算我们有多少种选法。
 *
 * @author HughesLou
 * Created on 2022-03-31
 */
public class MusicPairs572 implements Easy {

    /**
     * @param musics: the musics
     * @return: calc the number of pair of music
     */
    public long musicPairs(int[] musics) {
        long ans = 0;
        long[] nums = new long[61];
        for (int num : musics) {
            // 60倍数的转成0
            ans += nums[(60 - num % 60) % 60];
            nums[num % 60]++;
        }
        return ans;
    }

    public long musicPairs1(int[] musics) {
        long ret = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>(60);

        for (int music : musics) {
            // 加上判断属于60的部分
            music %= 60;
            int count = music == 0 ? hashMap.getOrDefault(music, 0) : hashMap.getOrDefault(60 - music, 0);
            ret += count;
            hashMap.put(music, hashMap.getOrDefault(music, 0) + 1);
        }

        return ret;
    }
}