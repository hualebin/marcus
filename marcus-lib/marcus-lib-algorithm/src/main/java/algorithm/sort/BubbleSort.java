package algorithm.sort;

/**
 * 冒泡排序
 * 原地排序算法，稳定的排序算法
 * 最好情况时间复杂度为O(n)
 * 最坏情况时间复杂度O(n2)
 * 平均情况时间复杂度O(n2)
 * 空间复杂度O(1)
 *
 */
public class BubbleSort {

    /**
     * 升序排序
     *
     * @param data
     */
    public static void ascSort(int[] data) {
        if (data.length <= 1) {
            return;
        }
        // 每一次冒泡让至少一个元素移动到它应该到的位置，重复n次
        for (int i = data.length - 1; i >= 0; i--) {
            Boolean flag = false;
            for (int j = 0; j < i; j++) {
                // 相邻的两个值两两比较，前面的值大于后面值的则位置交换
                if (data[j] > data[j + 1]) {
                    int tmp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = tmp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
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
        // 每一次冒泡让至少一个元素移动到它应该到的位置，重复n次
        for (int i = data.length - 1; i >= 0; i--) {
            Boolean flag = false;
            for (int j = 0; j < i; j++) {
                // 相邻的两个值两两比较，前面的值大于后面值的则位置交换
                if (data[j] < data[j + 1]) {
                    int tmp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = tmp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
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
        int[] data = {4, 5, 600, 3, 2, 1, 10, 98, 76, 4, 87, 7, 210};
        ascSort(data);
        for (int i: data) {
            System.out.println(i);
        }
        System.out.println("----------------");
        descSort(data);
        for (int i: data) {
            System.out.println(i);
        }
    }
}
