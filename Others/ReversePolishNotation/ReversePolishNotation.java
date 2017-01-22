package Test;

import java.util.Stack;

/**
 * 后缀表达式，逆波兰式，用一个堆栈存储数字，用另一个堆栈来存储操作符。遇到右括号就弹出，计算出新的值并压入到原有堆栈中
 */
public class ReversePolishNotation {

    public int calculate() {
        //String exec = "1+((2*3)+(4/2)-2)";
        String exec = "1+2-3";

        Stack<Character> number = new Stack<Character>();
        Stack<Character> operator = new Stack<Character>();
        for (int i = 0; i < exec.length(); i++) {
            Character target = exec.charAt(i);
            if (Character.isDigit(target) || target == '(')
                number.push(target);
            else if (isOperator(target)) {
                operator.push(target);
            } else {
                throw new IllegalArgumentException("操作式不合法");
            }

        }

        // 下面开始计算
        int result;
        while (!number.isEmpty() && !operator.isEmpty()) {
            int input1 = number.pop() - '0';
            int input2 = number.pop() - '0';
            Character opera = operator.pop();
            // input1 和 input2 的顺序还是很重要的
            result = perform(input2, input1, opera);
            if (number.isEmpty())
                return result;
            else
                number.push((char) (result + '0'));
            System.out.println((char) (-1 + '0'));
        }

        return -1;
    }

    public int perform(int input1, int input2, Character opera) {
        if (opera == '+') return input1 + input2;
        if (opera == '-') return input1 - input2;
        if (opera == '*') return input1 * input2;
        if (opera == '/') return input1 / input2;
        return -1;
    }

    public Boolean isOperator(Character input) {
        return (input == '*' || input == '+' || input == '-' || input == '/');
    }

    public static void main(String[] args) {
        ReversePolishNotation reversePolishNotation = new ReversePolishNotation();
        System.out.println(reversePolishNotation.calculate());
    }

}

