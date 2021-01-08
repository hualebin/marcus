package algorithm.dynamicprogramming;

public class Knapsack {

    // weight:物品重量，n:物品个数，w:背包可承载重量，基于二维数组的实现
    public int knapsack(int[] weight, int n, int w) {
        boolean[][] states = new boolean[n][w+1];
        // 第一行的数据要特殊处理，可以利用哨兵优化
        states[0][0] = true;
        if(weight[0] <= w) {
            states[0][weight[0]] = true;
        }
        // 动态规划状态转移
        for(int i = 1; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                if (states[i - 1][j] = true) {
                    states[i][j] = true;
                }
            }
            for (int j = 0; j < w - weight[i]; j++) {
                if (states[i - 1][j] == true) {
                    states[i][j + weight[i]] = true;
                }
            }
        }

        for (int i = w; i >= 0; --i) {
            if (states[n -1][i] == true) {
                return i;
            }
        }
        return 0;
    }

    // 基于一维数组的实现
    public int knapsack2(int[] weight, int n, int w) {
        boolean[] states = new boolean[w + 1];
        states[0] = true;
        if (weight[0] <= w) {
            states[weight[0]] = true;
        }
        // 动态规划状态转移
        for(int i = 1; i < n; i++) {
            for (int j = w - weight[i]; j >= 0; j--) {
                if (states[j] == true) {
                    states[j + weight[i]] = true;
                }
            }
        }

        for (int i = w; i >= 0; --i) {
            if (states[i] == true) {
                return i;
            }
        }
        return 0;
    }

    // 基于二维数组实现在背包承重下能放物品的最大价值
    public int knapsack3(int[] weight, int[] value, int n, int w) {
        int[][] states = new int[n][w + 1];
        if (weight[0] <= w) {
            states[0][weight[0]] = value[0];
        }
        // 动态规划状态转移
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                if (states[i - 1][j] > 0) {
                    states[i][j] = states[i - 1][j];
                }
            }
            if (weight[i] <= w) {
                states[i][weight[i]] = value[i] > states[i][weight[i]] ? value[i] : states[i][weight[i]];
            }
            for (int j = 0; j < w - weight[i]; j++) {
                if (states[i - 1][j] > 0) {
                    int state = states[i - 1][j] + value[i];
                    states[i][j + weight[i]] = state > states[i][j + weight[i]] ? state : states[i][j + weight[i]] ;
                }
            }
        }

        int maxValue = -1;
        for (int j = 0; j <= w; j++) {
            if (states[n - 1][j] > maxValue) {
                maxValue = states[n - 1][j];
            }
        }
        return maxValue;
    }

    // 基于一维数组实现在背包承重下能放物品的最大价值
    public int knapsack4(int[] weight, int[] value, int n, int w) {
        int[] states = new int[w + 1];
        if (weight[0] <= w) {
            states[weight[0]] = value[0];
        }
        // 动态规划状态转移
        for (int i = 1; i < n; i++) {
            for (int j = w - weight[i]; j >= 0; j--) {
                if (states[j] > 0) {
                    int val = states[j] + value[i];
                    if (val > states[j + weight[i]]) {
                        states[j + weight[i]] = val;
                    }

                }
            }
            if (weight[i] <= w && value[i] > states[weight[i]]) {
                states[weight[i]] = value[i];
            }
        }

        int maxValue = -1;
        for (int j = 0; j <= w; j++) {
            if (states[j] > maxValue) {
                maxValue = states[j];
            }
        }
        return maxValue;
    }
}
