package Test;

/**
 * 实现剑指 Offer 里的算法
 */
public class SwordToOffer {


    /*
    在一个二维数组中，每一行都按照从左到右递增的顺序排序，
    每一列都按照从上到下递增的顺序排序。请完成一个函数，
    输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
     */

    public int searchFortwoDimensionArray(int[][] arr, int target) {
        if (arr == null || arr.length < 1 || arr[0].length < 1)
            throw new IllegalArgumentException("输入矩阵不合法");


    }

    public void implementRegex(String input, Pattern input) {

    }

    // 面试12 打印 1 到最大的 n 位数
    // 用大数加法
    // TODO 考虑前导零的去除
    public String add(String input1, String input2) {
        int i = input1.length() - 1;
        int j = input2.length() - 1;

        StringBuilder builder = new StringBuilder();
        int carry = 0, num1, num2;
        while (i >= 0 || j >= 0) {
            if (i >= 0)
                num1 = input1.charAt(i) - '0';
            else
                num1 = 0;

            if (j >= 0)
                num2 = input2.charAt(j) - '0';
            else
                num2 = 0;

            int sum = num1 + num2 + carry;
            carry = sum / 10;
            builder.append(sum % 10);
            i--;
            j--;
        }

        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 3, 4},
                {6, 7, 8, 9},
                {12, 13, 14, 15},
                {18, 19, 20, 21},
        };
    }
}

