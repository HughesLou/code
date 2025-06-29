package com.hughes.lou.model;

/**
 * @author HughesLou
 * Created on 2022-03-21
 */
public class BitInteger {

    int value;

    public static int INTEGER_SIZE = 31;

    public BitInteger(int i) {
        value = i;
    }

    public int fetch(int j) {
        return (value >> j) & 1;
    }
}