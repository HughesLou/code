package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;

/**
 * 楼有 n 层高，鸡蛋若从 k 层或以上扔，就会碎。从 k 层以下扔，就不会碎。
 * 现在给两个鸡蛋，用最少的扔的次数找到 k。返回最坏情况下次数。
 * <p>
 * 对于 n = 10， 一种找 k 的初级方法是从 1、2 ... k 层不断找。但最坏情况下要扔 10 次。
 * 注意有两个鸡蛋可以使用，所以可以从 4、7、9 层扔。这样最坏就只需要 4 次 (例如 k = 9 时)。
 *
 * @author HughesLou
 * Created on 2022-03-27
 */
public class DropEggs254 implements Easy {

    /**
     * 假设第一次扔在第x层：
     * 如果第一个鸡蛋碎了，那么第二个鸡蛋只能从第1层开始一层一层扔，一直扔到第x-1层。
     * 这样一来，我们总共尝试了x-1+1 = x次，刚刚好没有超出假设次数。
     * 因此，要想尽量楼层跨度大一些，又要保证不超过假设的尝试次数x，那么第一次扔鸡蛋的最优选择就是第x层。
     * 归纳
     * 如果第一次扔鸡蛋没有碎,我们的尝试消耗了一次,问题就转化成了两个鸡蛋在100-x层楼往下扔,要求尝试次数不得超过x-1次
     * 所以第二次尝试的楼层跨度是x-1层,绝对楼层是x+(x-1)层
     * 同理,如果鸡蛋还没有碎,第三次楼层跨度是x-2,第四次是x-3
     * 根据总结,可以列出一个楼层数的方程式:
     * x + (x-1) + (x-2) + ... + 1 = 100
     *
     * @param n: An integer
     * @return: The sum of a and b
     */
    public int dropEggs(int n) {
        long ans = 0;
        for (int i = 1; ; ++i) {
            ans += i;
            if (ans >= (long) n) {
                return i;
            }
        }
    }
}
