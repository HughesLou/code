package com.hughes.lou.lintcode.easy;

import java.util.Comparator;
import java.util.List;

import com.hughes.lou.lintcode.level.Easy;
import com.hughes.lou.lintcode.model.Interval;

/**
 * 给定一系列的会议时间间隔，包括起始和结束时间[[s1,e1]，[s2,e2]，…(si < ei)，确定一个人是否可以参加所有会议。
 *
 * @author HughesLou
 * Created on 2022-04-06
 */
public class MeetingRooms920 implements Easy {

    /**
     * @param intervals: an array of meeting time intervals
     * @return: if a person could attend all meetings
     */
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) {
            return true;
        }

        intervals.sort(Comparator.comparingInt(interval -> interval.start));

        for (int idx = 1; idx < intervals.size(); idx++) {
            if (intervals.get(idx).start < intervals.get(idx - 1).end) {
                return false;
            }
        }
        return true;
    }
}
