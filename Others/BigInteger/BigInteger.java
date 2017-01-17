package Test;

/**
 * BigInteger 上的各种实现
 * 所以说我喜欢用 scala 的 BigInteger 类：-D
 */
public class BigInteger {
    /**
     * 返回两个字符串的乘积
     *
     * @param num1 数组1
     * @param num2 数组2
     * @return String 为数组 1 和 数组 2 的乘积
     */
    public String Multiplication(String num1, String num2) {
        String n1 = new StringBuilder(num1).reverse().toString();
        String n2 = new StringBuilder(num2).reverse().toString();

        int[] arr = new int[n1.length() + n2.length()];
        for (int i = 0; i < n1.length(); i++)
            for (int j = 0; j < n2.length(); j++) {
                arr[i + j] = (n1.charAt(i) - '0') * (n2.charAt(j) - '0');
            }

        // 计算进位
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            int mod = arr[i] % 10;
            int carry = arr[i] / 10;
            if (i + 1 < arr.length) {// 防止最后一位超出,或者用 if(carry>0) 来做先验判断
                arr[i + 1] += carry;
            }
            result.insert(0, mod);
        }

        // 移除前导零 leading-zero
        while (result.charAt(0) == '0' && result.length() > 1) {// 如果计算结果为 0，需要保留一位
            result.deleteCharAt(0);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        BigInteger bigInteger = new BigInteger();
        System.out.println(Integer.parseInt(bigInteger.Multiplication("1234", "9")) == 1234 * 9);
    }
}

