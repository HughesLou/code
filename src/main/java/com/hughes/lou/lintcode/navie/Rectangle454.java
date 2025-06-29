package com.hughes.lou.lintcode.navie;

import com.hughes.lou.level.Naive;

/**
 * @author HughesLou
 * Created on 2022-03-18
 */
public class Rectangle454 implements Naive {
    public int width;
    public int height;

    public Rectangle454(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getArea() {
        return width * height;
    }
}
