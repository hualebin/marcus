package algorithm.sort;

public class QuickSort {

    public static void sort(int[] data) {
        if (data.length <= 1) {
            return;
        }
        quickSort(data, 0, data.length - 1);
    }

    public static void quickSort(int[] data, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }

        int p = partition(data, startIndex, endIndex);

        quickSort(data, startIndex, p - 1);
        quickSort(data, p + 1, endIndex);
    }

    public static int partition(int[] data, int startIndex, int endIndex) {
        // 取最后一个元素作为基准数据
        int temp = data[endIndex];

        int low = startIndex;
        int high = endIndex;

        while(low < high) {
            while(low < high && data[low] <= temp) {
                low++;
            }
            data[high] = data[low];
            while(low < high && data[high] >= temp ) {
                high--;
            }
            data[low] = data[high];
        }

        data[high] = temp;

        return high;
    }

    public static void main(String[] args) {
        int[] data = {18, 89, 213, 1, 23, 3, 76, 14, 99, 10};
        sort(data);
        for(int i : data) {
            System.out.println(i);
        }
    }
}
