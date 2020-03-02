package algorithm.sort;

/**
 * 归并排序
 */
public class MergeSort {

    public static void sort(int[] data) {
        if (data.length <= 1) {
            return;
        }
        int[] temp = new int[data.length];
        mergeSort(data, temp, 0, data.length - 1);
    }

    public static void mergeSort(int[] data, int[] temp, int startIndex, int endIndex) {
        // 递归终止条件
        if (startIndex >= endIndex) {
            return;
        }
        int mid = (startIndex + endIndex) / 2;

        mergeSort(data, temp, startIndex, mid);
        mergeSort(data, temp, mid + 1, endIndex);

        merge(data, temp, startIndex, mid, endIndex);
    }

    public static void merge(int[] data, int[] temp, int startIndex, int mid, int endIndex) {
        int p = startIndex;
        int m = mid + 1;
        int i = startIndex;
        while (p <= mid && m <= endIndex) {
            temp[i++] = (data[p] <= data[m] ? data[p++] : data[m++]);
        }

        while(p <= mid) {
            temp[i++] = data[p++];
        }

        while(m <= endIndex) {
            temp[i++] = data[m++];
        }

        for (int j = startIndex; j < temp.length && j <= endIndex; j++) {
            data[j] = temp[j];
        }
    }

    public static void main(String args[]) {
        int[] data = {10, 7, 20, 8, 11, 99, 2, 3, 11, 100};
        sort(data);
        for (int i : data) {
            System.out.println(i);
        }
    }

}
