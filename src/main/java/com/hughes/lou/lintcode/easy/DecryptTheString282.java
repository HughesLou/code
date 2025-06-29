package com.hughes.lou.lintcode.easy;

import java.util.Collections;

import com.hughes.lou.level.Easy;

/**
 * 小Q想要给他的朋友发送一个神秘字符串，但是他发现字符串太长了，
 * 于是小Q发明了一种压缩算法对字符串中重复的部分进行了压缩，
 * 对于字符串中连续的m个相同字符串S将会压缩为[m|S](m为一个整数且1<=m<=100)，
 * 例如字符串ABCABCABC将会被压缩为[3|ABC]，现在小A收到了小Q发送过来的字符串，你能帮助他进行解压缩么？
 *
 * @author HughesLou
 * Created on 2022-03-28
 */
public class DecryptTheString282 implements Easy {

    /**
     * 1.采用递归的方法解决问题
     * 2.利用string的内置函数快速编程
     * 3.由内到外解压，当字符串中没有[]后，解压结束，否则递归解压
     * <p>
     * 输入 : "HG[3|B[2|CA]]F"
     * 输出 : "HGBCACABCACABCACAF"
     * 解释 : HG[3|B[2|CA]]F  −−>  HG[3|BCACA]F  −−>  HGBCACABCACABCACAF
     *
     * @param Message: the string xiao Q sent to xiao A.
     * @return: the string after decompress
     */
    public String DecompressString(String Message) {
        return handle(Message);
    }

    private String handle(String s) {
        // 查找最后一个[ , 该[后的第一个]
        int from = s.lastIndexOf("[");
        int to = s.indexOf("]", from);

        if (from < 0 || to < 0) {
            return s;
        }

        String sub = s.substring(from, to + 1);
        int index = sub.indexOf("|");
        // 解析
        String num = sub.substring(1, index);
        String str = sub.substring(index + 1, sub.length() - 1);
        String toReplace = String.join("", Collections.nCopies(Integer.parseInt(num), str));
        // 替换
        s = s.replace(sub, toReplace);

        return handle(s);
    }
}
