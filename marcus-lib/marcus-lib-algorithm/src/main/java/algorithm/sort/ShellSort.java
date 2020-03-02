package algorithm.sort;

/**
 * 希尔排序
 */
public class ShellSort {

    public static void sort(int[] data) {
        if (data.length <= 1) {
            return;
        }

        // 获取增量
        int gap = 1;
        while(gap < data.length) {
            gap = gap * 3 + 1;
        }

        while (gap > 0) {
            for (int i = gap; i < data.length; i++) {
                int value = data[i];
                int j = i - gap;
                while (j >= 0 && data[j] > value) {
                    data[j + gap] = data[j];

                    j = j - gap;
                }
                data[j + gap] = value;
            }
            gap = (int) Math.floor(gap / 3);
        }
    }

    public static void sort1(int[] data) {
        if (data.length <= 1) {
            return;
        }

        for (int gap = data.length / 2; gap > 0; gap = gap / 2) {
            for (int i = gap; i < data.length; i++) {
                int value = data[i];
                int j = i - gap;
                while(j >= 0 && data[j] > value) {
                    data[j + gap] = data[j];

                     j = j - gap;
                }
                data[j + gap] = value;
            }
        }
    }

    public static void main(String args[]) {
        int[] data = {4, 8, 1, 9, 3, 5, 6, 10, 3, 7};
        sort1(data);

        for (int i : data) {
            System.out.println(i);
        }
    }

}