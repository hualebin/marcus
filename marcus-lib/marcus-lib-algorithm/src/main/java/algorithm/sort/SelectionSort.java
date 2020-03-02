package algorithm.sort;

/**
 * 选择排序
 * 原地排序算法，稳定的排序算法
 * 最好情况时间复杂度O(n2)
 * 最坏情况时间复杂度O(n2)
 * 平均情况时间复杂度O(n2)
 */
public class SelectionSort {

    public static void ascSort(int[] data) {
        if (data.length <= 1) {
            return;
        }
        for (int i = 0; i < data.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[minIndex] > data[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int tmp = data[i];
                data[i] = data[minIndex];
                data[minIndex] = tmp;
            }
        }
    }

    public static void descSort(int[] data) {
        if (data.length <= 1) {
            return;
        }
        for (int i = 0; i < data.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[minIndex] < data[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int tmp = data[i];
                data[i] = data[minIndex];
                data[minIndex] = tmp;
            }
        }
    }

    public static void sort(int[] data, Boolean isAsc) {
        if (isAsc) {
            ascSort(data);
        } else {
            descSort(data);
        }
    }

    public static void main(String[] args) {
        int[] data = {33, 11, 22, 34, 9, 100, 78, 2, 298, 1, 3, 5, 90};

        ascSort(data);
        for (int i : data) {
            System.out.println(i);
        }
        System.out.println("-------------------------------");
        descSort(data);
        for (int i : data) {
            System.out.println(i);
        }
    }
}
