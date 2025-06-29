package com.hughes.lou.lintcode.easy;

import java.util.ArrayList;
import java.util.List;

import com.hughes.lou.level.Easy;

/**
 * 给定一个启动 IP 地址 ip 和我们需要覆盖的 IP 数量 n，
 * 返回一个 CIDR 块的列表（要求列表长度最小），使这些 CIDR 能恰好覆盖从 ip 开始的 n 个地址。
 *
 * @author HughesLou
 * Created on 2022-04-05
 */
public class IPToCIDR852 implements Easy {
    /**
     * 题目要求使用尽可能少的 CIDR 块，覆盖从初始 ip 开始的 n 个 ip 地址。
     * 而对于每个 CIDR 块，斜杠后面的数字越小，覆盖的 ip 地址越多，使用的 CIDR 越少，
     * 即要使每个 CIDR 最后可变化的位数尽可能多且不能覆盖任何小于 ip 的地址和大于 ip+n 的地址 。
     *
     * @param ip: the given start ip address
     * @param n: the number of ips we need to cover
     * @return: a representation of the range as a list (of smallest possible length) of CIDR blocks
     */
    public List<String> ipToCIDR(String ip, int n) {
        long x = 0;
        String[] ips = ip.split("\\.");
        for (String s : ips) {
            x = Integer.parseInt(s) + x * 256;
        }

        List<String> result = new ArrayList<>();
        while (n > 0) {
            long step = x & -x;
            while (step > n) {
                step /= 2;
            }
            result.add(longToIP(x, (int) step));
            x += step;
            n -= step;
        }

        return result;
    }

    private String longToIP(long x, int step) {
        int[] ans = new int[4];
        ans[0] = (int) (x & 255);
        x >>= 8;
        ans[1] = (int) (x & 255);
        x >>= 8;
        ans[2] = (int) (x & 255);
        x >>= 8;
        ans[3] = (int) x;
        int len = 33;
        while (step > 0) {
            len--;
            step >>= 1;
        }
        return ans[3] + "." + ans[2] + "." + ans[1] + "." + ans[0] + "/" + len;
    }
}
