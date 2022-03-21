package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;

/**
 * 一个黑白显示屏由一个单独的字节数组组成，这个屏幕允许 8 个连续像素由一个字节进行存储。
 * 该显示屏宽 w ，w可被8整除（也就是说，任意字节都不可能被行切断）。
 * 该显示屏高，则取决于数组的长度及显示屏的宽。请设计一个函数
 * drawHorizontalLine(byte[] screen, int width, int x1, int x2, int y)
 * 从(x1, y) 到 (x2, y) 画出一条水平线。
 *
 * @author HughesLou
 * Created on 2022-03-21
 */
public class MonochromeScreen238 implements Easy {

    /**
     * @param screen an array of 8bit integer(byte)
     * @param width the width of screen
     * @param x1 an integer
     * @param x2 an integer
     * @param y an integer
     * @return nothing
     */
    public void drawHorizontalLine(byte[] screen, int width, int x1, int x2, int y) {
        // 找到起始点和终点的对应区域范围
        int start_offset = x1 % 8;
        int first_full_byte = x1 / 8;
        if (start_offset != 0) {
            first_full_byte++;
        }

        int end_offset = x2 % 8;
        int last_full_byte = x2 / 8;
        if (end_offset != 7) {
            last_full_byte--;
        }

        // Set full bytes
        for (int b = first_full_byte; b <= last_full_byte; b++) {
            screen[(width / 8) * y + b] = (byte) 0xFF;
        }

        // Create masks for start and end of line
        byte start_mask = (byte) (0xFF >> start_offset);
        byte end_mask = (byte) ~(0xFF >> (end_offset + 1));
        // Set start and end of line
        if ((x1 / 8) == (x2 / 8)) { // x1 and x2 are in the same byte
            byte mask = (byte) (start_mask & end_mask);
            screen[(width / 8) * y + (x1 / 8)] |= mask;
        } else {
            if (start_offset != 0) {
                int byte_number = (width / 8) * y + first_full_byte - 1;
                screen[byte_number] |= start_mask;
            }

            if (end_offset != 7) {
                int byte_number = (width / 8) * y + last_full_byte + 1;
                screen[byte_number] |= end_mask;
            }
        }
    }

    void drawHorizontalLine0(byte[] screen, int width, int x1, int x2, int y) {
        int cols = width / 8;

        int index1 = y * cols + x1 / 8;
        int index2 = y * cols + x2 / 8;

        for (int index = index1 + 1; index < index2; index++) {
            screen[index] |= 0xff;
        }

        if (index1 != index2) {
            screen[index1] |= 0xff >> (x1 % 8);
            screen[index2] |= 0xff << (7 - x2 % 8);
        } else {
            screen[index1] |= (0xff >> (x1 % 8)) & (0xff << (7 - x2 % 8));
        }
    }
}
