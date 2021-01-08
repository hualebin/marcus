package algorithm.leetcode;

import java.util.*;

public class UniqueOccurrences {

    // 利用hashMap和hashSet
    public static boolean solution(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int item : arr) {
            Integer count = map.getOrDefault(item, 0);
            map.put(item, ++count);
        }
        Set<Integer> set = new HashSet<>();
        for(Integer value : map.values()){
            set.add(value);
        }
        return map.size() == set.size();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1, -3, 3, 1, -1, 3, 3, -3};
        System.out.println(solution(arr));
    }
}
