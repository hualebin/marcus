package algorithm.leetcode;

public class ValidMountainArray {
    public static boolean solution(int[] A) {
        if (A.length <= 2) {
            return false;
        }
        int i = 0;
        int j = A.length - 1;
        while(i < j && (A[i] < A[i + 1])){
            i++;
        }
        if (i == 0 || i == j) {
            return false;
        }
        while(i < j && (A[i] > A[i + 1])){
            i++;
        }
        return i == j;
    }

    public static void main(String[] args) {
        int[] A = new int[]{2, 1};
        System.out.println(solution(A));
        int[] B = new int[]{3, 5, 5};
        System.out.println(solution(B));
        int[] C = new int[]{0, 3, 2, 1};
        System.out.println(solution(C));
        int[] D = new int[]{0, 1, 2, 3, 2, 1, 0};
        System.out.println(solution(D));
        int[] E = new int[]{0, 1, 2, 3, 4, 5, 6};
        System.out.println(solution(E));
    }
}
