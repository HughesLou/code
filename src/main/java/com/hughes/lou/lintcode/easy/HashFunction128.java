package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;

/**
 * 在数据结构中，哈希函数是用来将一个字符串（或任何其他类型）转化为小于哈希表大小且大于等于零的整数。
 * 一个好的哈希函数可以尽可能少地产生冲突。一种广泛使用的哈希函数算法是使用数值 33，假设任何字符串都是基于 33 的一个大整数，比如：
 * hashcode("abcd")=(ascii(a)∗33^3+ascii(b)∗33^2+ascii(c)∗33+ascii(d))
 * =(ascii(a)∗33^3 +ascii(b)∗33^2+ascii(c)∗33+ascii(d)) % HASH_SIZE
 * =(97∗33^3 +98∗33^2 +99∗33+100) %  HASH_SIZE
 * =3595978 % HASH_SIZE
 * <p>
 * 其中HASH_SIZE表示哈希表的大小(可以假设一个哈希表就是一个索引  ~ HASH_SIZE - 1的数组)。
 * <p>
 * 给出一个字符串作为 key 和一个哈希表的大小，返回这个字符串的哈希值。
 *
 * @author HughesLou
 * Created on 2022-03-19
 */
public class HashFunction128 implements Easy {

    /**
     * @param key: A string you should hash
     * @param HASH_SIZE: An integer
     * @return: An integer
     */
    public int hashCode(String key, int HASH_SIZE) {
        long ans = 0;
        for (int i = 0; i < key.length(); i++) {
            ans = (ans * 33 + (int) key.charAt(i)) % HASH_SIZE;
        }
        return (int) ans;
    }
}
