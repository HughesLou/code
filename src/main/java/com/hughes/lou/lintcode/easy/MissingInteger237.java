package com.hughes.lou.lintcode.easy;

import java.util.ArrayList;

import com.hughes.lou.level.Easy;
import com.hughes.lou.model.BitInteger;

/**
 * 在数组 A 中，包含 0 到 n 的整数，其中缺失了一个数。在
 * 这一问题中，我们难以仅用一个操作审查数组 A 中的所有整数。
 * A 中的元素用二进制表示，只能使用固定时间的操作 - "fetch the jth bit of A[i]" 来审查数组 。
 * 请编写代码，以查找数组中缺失的整数。你可以在 O(n) 的时间复杂度实现吗？
 *
 * @author HughesLou
 * Created on 2022-03-20
 */
public class MissingInteger237 implements Easy {

    /**
     * @param array a BitInteger list
     * @return an integer
     */
    public int findMissing(ArrayList<BitInteger> array) {
        /* Start from the least significant bit, and work our way up */
        return findMissing(array, 0);
    }

    public int findMissing(ArrayList<BitInteger> input, int column) {
        if (column >= BitInteger.INTEGER_SIZE) { // We're done!
            return 0;
        }
        ArrayList<BitInteger> oneBits = new ArrayList<>();
        ArrayList<BitInteger> zeroBits = new ArrayList<>();
        for (BitInteger t : input) {
            if (t.fetch(column) == 0) {
                zeroBits.add(t);
            } else {
                oneBits.add(t);
            }
        }

        if (zeroBits.size() <= oneBits.size()) {
            int v = findMissing(zeroBits, column + 1);
            return (v << 1);
        } else {
            int v = findMissing(oneBits, column + 1);
            return (v << 1) | 1;
        }
    }
}
