package algorithm.search;

/**
 * 二分查找
 *
 * 时间复杂度O(logn)
 */
public class BinarySearch {

    /**
     *  查找其中一个等于给定值的元素
     *
     * @param data
     * @param value
     * @return
     */
    public static int search(int[] data, int value) {
        if (data.length <= 0) {
            return -1;
        }
        int low = 0;
        int high = data.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (data[mid] == value) {
                return mid;
            } else if (data[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 查找第一个值等于给定值的元素
     *
     * @param data
     * @param value
     * @return
     */
    public static int searchFirst(int[] data, int value) {
        if (data.length <= 0) {
            return -1;
        }
        int low = 0;
        int high = data.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (data[mid] == value) {
                if (mid == 0 || data[mid - 1] != value) {
                    return mid;
                }
                high = mid - 1;
            } else if (data[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个值等于给定值的元素
     *
     * @param data
     * @param value
     * @return
     */
    public static int searchLast(int[] data, int value) {
        if (data.length <= 0) {
            return -1;
        }
        int low = 0;
        int high = data.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (data[mid] == value) {
                if (mid == (data.length - 1) || data[mid + 1] != value) {
                    return mid;
                }
                low = mid + 1;
            } else if (data[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 查找第一个大于等于给定值的元素
     *
     * @param data
     * @param value
     * @return
     */
    public static int searchGeFirst(int[] data, int value) {
        if (data.length <= 0) {
            return -1;
        }
        int low = 0;
        int high = data.length - 1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if (data[mid] >= value) {
                if (mid == 0 || data[mid - 1] < value) {
                    return mid;
                }
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static int searchLeLast(int[] data, int value) {
        if (data.length <= 0) {
            return -1;
        }
        int low = 0;
        int high = data.length - 1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if (data[mid] <= value) {
                if (mid == (data.length - 1) || data[mid + 1] > value) {
                    return mid;
                }
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 8, 8, 9, 10, 11};
        System.out.println(searchLeLast(data, 4));
    }
}
