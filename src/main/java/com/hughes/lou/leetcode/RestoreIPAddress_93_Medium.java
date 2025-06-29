package com.hughes.lou.leetcode;

import com.hughes.lou.level.Medium;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress_93_Medium implements Medium {

    public List<String> restoreIpAddresses(String s) {
        List<String> ret = new ArrayList<>();
        doRestore(0, "", s, ret);
        return ret;
    }

    private void doRestore(int k, String path, String s, List<String> ret) {
        if (k == 4 || s.isEmpty()) {
            if (k == 4 && s.isEmpty()) {
                ret.add(path);
            }
            return;
        }

        for (int i = 0; i < s.length() && i <= 2; i++) {
            if (i != 0 && s.charAt(0) == '0') break;
            String part = s.substring(0, i + 1);
            if (Integer.parseInt(part) <= 255) {
                doRestore(k + 1, !path.isEmpty() ? path + "." + part : part, s.substring(i + 1), ret);
            }
        }
    }
}
