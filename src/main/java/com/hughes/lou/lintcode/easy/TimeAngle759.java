package com.hughes.lou.lintcode.easy;

import com.hughes.lou.lintcode.level.Easy;

/**
 * @author HughesLou
 * Created on 2022-04-04
 */
public class TimeAngle759 implements Easy {
    /**
     * @param h: hours
     * @param m: minutes
     * @return: angle between hour hand and minute hand at X:Y in a clock
     */
    public float timeAngle(int h, int m) {
        float mAngle = m * 6;
        float hAngle = (h + m / 60.0f) * 30;
        float res = Math.abs(mAngle - hAngle);
        // 这里应该不是必须的，res肯定小于等于360
        //        res -= Math.floor(res / 360) * 360;
        if (res > 180) {
            res = 360 - res;
        }
        return res;
    }
}
