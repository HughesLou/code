package com.hughes.lou.lintcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.hughes.lou.lintcode.level.Easy;

/**
 * @author HughesLou
 * Created on 2022-03-29
 */
public class ExternalSortingPractising351 implements Easy {

    class IntegerFile {

        public int read() {
            return 0;
        }

        public void write(int element) {
            ;
        }

        public boolean isEmpty() {
            return true;
        }
    }

    /**
     * @param files: some files with integers need to be sorted
     * @param result: a file for writing numbers
     * @return: nothing
     */
    public void sortOnDisk(IntegerFile[] files, IntegerFile result) {
        List<Integer> list = new ArrayList<>();
        for (IntegerFile file : files) {
            while (!file.isEmpty()) {
                list.add(file.read());
            }
        }

        Collections.sort(list);
        for (Integer element : list) {
            result.write(element);
        }
    }
}
