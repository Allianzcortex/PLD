package Test;

import java.util.Arrays;

/**
 * Created by hzcortex on 16-11-29.
 */

/*
在学习之前首先要对 DP 算法有一个整体的认识
能被动规解决的问题有以下两种性质：重叠子问题 Overlapping Subproblems 和
最优子结构 Optimal Substructure

关于重叠子问题，如何存储计算值以让
可以被复用，有两种方式：

Memorization(Top down 自顶向下）
Tabulation(Bottom Up 自底向上）

Memorization 是用打表来存储，一个典型的例子就是斐波那契数列的求解

def fin(n,lookup):
    if n==0 or n==1:
        lookup[n]=1
    return lookup[n] if lookup[n] else fin(n-1,lookup)+fin(n-1,lookup)

# Python program Tabulated (bottom up) version
def fib(n):

    # array declaration
    f = [0]*(n+1)

    # base case assignment
    f[1] = 1

    # calculating the fibonacci and storing the values
    for i in xrange(2 , n+1):
        f[i] = f[i-1] + f[i-2]
    return f[n]

同样都是打表，memorization 不一定会充满，而
tabulated 算法会一个一个充满


下面是关于最优子结构的问题：
也就是说子问题的最优解也是父问题的最优解


 */
public class DP {

    /*
    LIS 是指最长增长子序列  Longest Increasing Subsequence
    如 { 10, 22, 9, 33, 21, 50, 41, 60, 80 } is 6 and LIS is {10, 22, 33, 50, 60, 80}.
   */

    // 使用递归求解
    public int LIS1(int[] arr) {
        return 1;
    }

    // 使用记忆化搜索
    public int LIS2(int[] arr) {
        int i, j, max = 0;
        int n = arr.length;
        int[] list = new int[n]; // 存储长度
        Arrays.fill(list, 1);
        int[] index = new int[n]; // 存储距离
        Arrays.fill(index, -1);


        for (i = 1; i < n; i++)
            for (j = 0; j < i; j++) {
                if (arr[i] > arr[j] && list[i] < list[j] + 1) {
                    list[i] = list[j] + 1;
                    index[i] = j;
                }

            }

        // 选择出最大的
        int max_index = 0;

        for (i = 0; i < n; i++)
            if (list[i] > max) {
                max = list[i];
                max_index = i;
            }
        StringBuilder builder = new StringBuilder();
        builder.insert(0, arr[max_index]);
        // 其实用 Max_index 一个变量就好了,next_index 意义不大......
        int next_index = index[max_index];
        while (next_index != -1) {
            builder.insert(0, arr[next_index] + " ");
            next_index = index[next_index];
        }
        System.out.println(builder.toString());
        return max;

    }

    /*
    LCS 是指最长公共子序列
     */
//    public static int[] LCS(int[] arr1, int[] arr2) {
//        return {1};
//    }

    /*
    0-1 Package
     */

    static int max(int a, int b) {
        return a > b ? a : b;
    }

    public int Knapsack1(int[] value, int[] weight, int capacity, int number) {
        if (capacity <= 0 || number == 0)
            return 0;
        if (weight[number - 1] > capacity)
            return Knapsack1(value, weight, capacity, number - 1);
        else
            return max(value[number - 1] + Knapsack1(value, weight, capacity - weight[number - 1], number - 1),
                    Knapsack1(value, weight, capacity, number - 1));

    }

    public int Knapsack2(int[] value, int[] weight, int capacity, int index) {
        if (capacity <= 0 || index >= value.length)
            return 0;
        if (weight[index] > capacity)
            return Knapsack2(value, weight, capacity, index + 1);
        else
            return max(value[index] + Knapsack2(value, weight, capacity - weight[index], index + 1),
                    Knapsack2(value, weight, capacity, index + 1));
    }

    public int Knapsack3(int[] value, int[] weight, int capacity, int number) {
        // 采用记忆化搜索来解决
        int i, j;
        int table[][] = new int[][];
    }

    public static void main(String[] args) {
        DP dp = new DP();

        // LIS 问题
        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        System.out.println(dp.LIS2(arr));  // 6

        // KnapSack 问题
        int[] value = {60, 100, 120};
        int[] weight = {10, 20, 30};
        int capacity = 50;
        int number = value.length;
        System.out.println(dp.Knapsack1(value, weight, capacity, number)); // 220
        int index = 0;
        System.out.println(dp.Knapsack2(value, weight, capacity, index));  // 220
    }
}

