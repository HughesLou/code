package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 设计一种方法，将一个字符串中的所有空格替换成 %20 。
 * 字符串以字符数组的形式给出，你可以假设该字符串有足够的空间来加入新的字符，且你得到的是“真实的”字符长度。
 * <p>
 * 你的程序还需要返回被替换后的字符串的长度。
 *
 * @author HughesLou
 * Created on 2022-03-20
 */
public class SpaceReplacement212 implements Easy {

    /*
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     */
    public int replaceBlank(char[] string, int length) {
        if(0==length) return 0;
        int num = 0;
        for(int i=0;i<length;i++){
            if(string[i] == ' ') num++;
        }

        int newLen = length + num*2;
        string[newLen] = 0;
        int j = 1;
        for(int i=length-1;i>=0;i--){
            if(string[i] != ' '){
                string[newLen - j] = string[i];
                j++;
            }
            else{
                string[newLen - j] = '0';
                j++;
                string[newLen - j] = '2';
                j++;
                string[newLen - j] = '%';
                j++;
            }
        }
        return newLen;
    }
}
