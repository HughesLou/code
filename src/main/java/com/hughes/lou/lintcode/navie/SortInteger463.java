package com.hughes.lou.lintcode.navie;

import java.util.Arrays;

import com.hughes.lou.level.Naive;
import com.hughes.lou.utils.Utils;

/**
 * Created by Hughes on 2016/8/14.
 */
public class SortInteger463 implements Naive {

    /**
     * @param A an integer array
     * @return void
     */
    public void sortIntegers(int[] A) {
        insert(A);
        System.out.print(Arrays.toString(A));
    }

    private void bubble(int[] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] > A[j]) {
                    Utils.swap(A, i, j);
                }
            }
        }
    }

    private void insert(int[] A) {
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1]) {
                int index = i - 1;
                int value = A[i];
                while (index >= 0 && value < A[index]) {
                    A[index + 1] = A[index];
                    index--;
                }
                A[index + 1] = value;
            }
        }
    }

    private void select(int[] A) {
        int key;
        for (int i = 0; i < A.length; i++) {
            key = selectMinKey(A, i, A.length);
            if (key != i) {
                Utils.swap(A, key, i);
            }
        }
    }

    private int selectMinKey(int[] A, int start, int end) {
        int key = start;
        for (int i = start + 1; i < end; i++) {
            if (A[i] < A[key]) {
                key = i;
            }
        }
        return key;
    }

    public static void main(String[] args) {
        int[] A = { 3, 2, 1, 4, 5 };
        new SortInteger463().sortIntegers(A);
    }
}
