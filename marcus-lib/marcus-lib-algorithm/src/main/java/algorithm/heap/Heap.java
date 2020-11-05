package algorithm.heap;

public class Heap {
    private int[] a; // 数组，从下标1开始存储数据
    private int n;  // 堆可以存储的最大数据个数
    private int count; // 堆已经存储的数据个数

    public Heap(int capacity) {
        this.a = new int[capacity + 1];
        this.n = capacity;
        this.count = 0;
    }


    /**
     * 往堆中插入一个元素，时间复杂度为O(log n)
     * @param data
     */
    public void insert(int data) {
        // 堆满了
        if (count >= n){
            return;
        }
        ++count;
        a[count] = data;

        int i = count;
        // 从下往上调整
        while (i > 1) {
            int p = i / 2;
            if (a[p] >= a[i]) {
                break;
            }
            a[i] = a[p];
            a[p] = data;
            i = p;
        }
    }

    /**
     * 从堆顶删除一个元素，时间复杂度为O(log n)
     */
    public void removeMax() {
        if (count == 0) {
            return;
        }
        a[1] = a[count];
        a[count] = 0;
        --count;
        // 自上往下调整
        int i = 1;
        while(true) {
            int maxPos = i;
            int left = i * 2;
            int right = left + 1;
            if (left <= count && a[i] < a[left]) {
                maxPos = left;
            }
            if (right <= count && a[maxPos] < a[right]) {
                maxPos = right;
            }
            if (maxPos == i) {
                break;
            }

            int temp = a[maxPos];
            a[maxPos] = a[i];
            a[i] = temp;
            i = maxPos;
        }
    }


    /**
     * 数组从下标为2开始从下往上堆化，时间复杂度为O（nlogn）
     *
     * @param data
     */
    public static void buildHeap1(int[] data) {
        for (int i = 2; i < data.length; i++) {
            int temp = data[i];
            int j = i;
            while (j > 1) {
                int p = j / 2;
                if (data[p] >= data[j]) {
                    break;
                }
                data[j] = data[p];
                data[p] = temp;
                j = p;
            }
        }
    }

    /**
     * 数组从最后一个元素的父节点到第一个元素开始循环遍历，遍历的节点从上往下堆化，时间复杂度为O（n）
     *
     * @param data
     */
    public static void buildHeap2(int[] data) {
        int n = data.length - 1;
        for (int i = n / 2; i >= 1; --i) {
            int j = i;
            while(true) {
                int maxPos = j;
                int left = j * 2;
                int right = j * 2 + 1;

                if (left <= n && data[left] > data[i]) {
                    maxPos = left;
                }
                if (right <= n && data[right] > data[maxPos]) {
                    maxPos = right;
                }

                if (maxPos == j) {
                    break;
                }

                int temp = data[j];
                data[j] = data[maxPos];
                data[maxPos] = temp;
                j = maxPos;
            }
        }
    }

    /**
     * 堆排序，时间复杂度为O(nlogn)
     *
     * @param data
     */
    public static void sort(int[] data) {
        buildHeap2(data);
        // 开始排序
        for (int n = data.length - 1; n > 1; n--) {
            // 第1个元素和第n个元素开始交换
            int max = data[1];
            data[1] = data[n];
            data[n] = max;
            // 第1个元素到n-1个元素开始从上往下堆化
            int i = 1;
            int count = n - 1;
            while(true) {
                int maxPos = i;
                int left = i * 2;
                int right = left + 1;
                if (left <= count && data[i] < data[left]) {
                    maxPos = left;
                }
                if (right <= count && data[maxPos] < data[right]) {
                    maxPos = right;
                }
                if (maxPos == i) {
                    break;
                }

                int temp = data[maxPos];
                data[maxPos] = data[i];
                data[i] = temp;
                i = maxPos;
            }
        }
    }


    public void print() {
        System.out.printf("[");
        for (int data : a) {
            System.out.printf(data + ", ");
        }
        System.out.printf("]\n");
    }

    public static void main(String[] args) {
        Heap heap = new Heap(20);
        heap.insert(33);
        heap.insert(27);
        heap.insert(21);
        heap.insert(16);
        heap.insert(13);
        heap.insert(15);
        heap.insert(9);
        heap.insert(5);
        heap.insert(6);
        heap.insert(8);
        heap.insert(7);
        heap.insert(4);
        heap.insert(5);
        heap.insert(22);
        heap.print();


        int[] data = new int[]{0, 33, 27, 21, 16, 13, 15, 9, 5, 6, 8, 7, 4, 3, 22};
        buildHeap1(data);
        System.out.printf("[");
        for (int i : data) {
            System.out.printf(i + ", ");
        }
        System.out.printf("]\n");


        int[] data2 = new int[]{0, 33, 27, 21, 16, 13, 15, 9, 5, 6, 8, 7, 4, 3, 22};
        /*buildHeap2(data2);
        System.out.printf("[");
        for (int i : data2) {
            System.out.printf(i + ", ");
        }
        System.out.printf("]\n");*/
        sort(data2);
        System.out.printf("[");
        for (int i : data2) {
            System.out.printf(i + ", ");
        }
        System.out.printf("]\n");

    }
}
