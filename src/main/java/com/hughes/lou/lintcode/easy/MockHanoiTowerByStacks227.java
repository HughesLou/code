package com.hughes.lou.lintcode.easy;

import com.hughes.lou.level.Easy;
import com.hughes.lou.model.Tower;

/**
 * @author HughesLou
 * Created on 2022-03-20
 */
public class MockHanoiTowerByStacks227 implements Easy {

    public void mock(int n) {
        Tower[] towers = new Tower[3];
        for (int i = 0; i < 3; i++) {
            towers[i] = new Tower(i);
        }
        for (int i = n - 1; i >= 0; i--) {
            towers[0].add(i);
        }
        towers[0].moveDisks(n, towers[2], towers[1]);
    }
}
