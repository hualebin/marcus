package algorithm.sort;

/**
 * 插入排序
 * 原地排序算法，稳定的排序算法
 * 最好情况时间复杂度为O(n)
 * 最坏情况时间复杂度O(n2)
 * 平均情况时间复杂度O(n2)
 * 空间复杂度O(1)
 *
 */
public class InsertionSort {

    /**
     * 升序排序
     *
     * @param data
     */
    public static void ascSort(int[] data) {
        if (data.length <= 1) {
            return;
        }
        for (int i = 1; i < data.length; i++) {
            int value = data[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (data[j] > value) {
                    data[j + 1] = data[j];
                } else {
                    break;
                }
            }
            data[j + 1] = value;
        }
    }

    /**
     * 降序排序
     *
     * @param data
     */
    public static void descSort(int[] data) {
        if (data.length <= 1) {
            return;
        }
        for (int i = 1; i < data.length; i++) {
            int value = data[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (data[j] < value) {
                    data[j + 1] = data[j];
                } else {
                    break;
                }
            }
            data[j + 1] = value;
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
        int data[] = {78, 3, 89, 12, 33, 1, 98, 77, 7};
        ascSort(data);
        for (int i : data) {
            System.out.println(i);
        }
        System.out.println("----------------------");
        descSort(data);
        for (int i : data) {
            System.out.println(i);
        }

    }
}
