package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 插入区间
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 */
public class InsertInterval {

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0){
            return new int[][]{newInterval};
        }
        if (newInterval.length < 2) {
            return intervals;
        }
        List<Integer> mergeIndexList = new ArrayList<>();
        int min = newInterval[0];

        int max = newInterval[newInterval.length - 1];
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            int intervalLength = interval.length;
            if ((interval[0] <= min && interval[intervalLength - 1] >= min) || (interval[0] <= max && interval[intervalLength - 1]  >= max) || (interval[0] >= min && interval[intervalLength - 1] <= max)) {
                mergeIndexList.add(i);
            }
        }

        int[][] result = new int[intervals.length - mergeIndexList.size() + 1][2];
        int j = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (mergeIndexList.size() > 0 && mergeIndexList.contains(i)) {
                if (mergeIndexList.get(0) == i) {
                    result[j][0] = min < intervals[i][0] ? min : intervals[i][0];
                }
                if (mergeIndexList.get(mergeIndexList.size() - 1) == i){
                    result[j++][1] = max > intervals[i][1] ? max : intervals[i][1];
                }
            } else {
                if (mergeIndexList.size() == 0 && j == i && intervals[i][0] > newInterval[1]) {
                    result[j++] = newInterval;
                }
                result[j++] = intervals[i];
                if (mergeIndexList.size() == 0 && (i  == intervals.length - 1) && (j == result.length - 2)) {
                    result[j] = newInterval;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 3},{6, 9}};
        int[] newInterval = new int[]{2, 5};

        int[][] result = insert(intervals, newInterval);
        for (int[] a: result) {
            System.out.printf("[");
            for (int b : a) {
                System.out.printf(b + ",");
            }
            System.out.printf("]\n");
        }

        int[][] intervals1 = new int[][]{{1, 2},{3, 5},{6, 7},{8, 10},{12, 16}};
        int[] newInterval1 = new int[]{4, 8};

        int[][] result1 = insert(intervals1, newInterval1);
        for (int[] a: result1) {
            System.out.printf("[");
            for (int b : a) {
                System.out.printf(b + ",");
            }
            System.out.printf("]\n");
        }

        int[][] intervals2 = new int[][]{{2, 5}, {6, 7}, {8, 9}};
        int[] newInterval2 = new int[]{0, 1};

        int[][] result2 = insert(intervals2, newInterval2);
        for (int[] a: result2) {
            System.out.printf("[");
            for (int b : a) {
                System.out.printf(b + ",");
            }
            System.out.printf("]\n");
        }
    }
}
