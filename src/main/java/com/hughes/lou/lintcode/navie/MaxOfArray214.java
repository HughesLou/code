package com.hughes.lou.lintcode.navie;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang3.ArrayUtils;

import com.hughes.lou.lintcode.level.Naive;

/**
 * 给一个浮点数数组，求数组中的最大值。
 *
 * @author HughesLou
 * Created on 2022-03-18
 */
public class MaxOfArray214 implements Naive {

    public float maxOfArray(float[] A) {
        float max = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] > max) {
                max = A[i];
            }
        }
        return max;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        List<Float> list = new ArrayList<>();
        for (String element : a.split(" ")) {
            list.add(Float.parseFloat(element));
        }

        MaxOfArray214 maxOfArray214 = new MaxOfArray214();
        System.out.println(maxOfArray214.maxOfArray(ArrayUtils.toPrimitive(list.toArray(new Float[0]))));
    }
}