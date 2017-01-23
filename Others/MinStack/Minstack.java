package Test;

import java.util.Comparator;
import java.util.Stack;

/**
 * 用最小的来模拟
 */

// 这个 牵扯到 Java 的泛型......
public class MinStack<T extends Comparable<T>> {
    private Stack<T> container;
    private Stack<T> minContainer;

    public MinStack() {
        this.container = new Stack<T>();
        this.minContainer = new Stack<T>();
    }

    public void push(T t) {
        if (t == null)
            throw new IllegalArgumentException("参数为 null");
        if (container.isEmpty()) {
            container.push(t);
            minContainer.push(t);
        } else {
            container.push(t);
            if (minContainer.peek().compareTo(t) > 0)
                minContainer.push(t);
            else
                minContainer.push(minContainer.peek());
        }
    }

    public T pop() {
        if (container.isEmpty())
            throw new RuntimeException("栈为空");
        minContainer.pop();
        return container.pop();
    }

    public T getMin() {
        return minContainer.peek();
    }

    public static void main(String args[]) {
        MinStack<Integer> minStack = new MinStack<Integer>();
        minStack.push(2);
        minStack.push(1);
        minStack.push(3);
        System.out.println(minStack.getMin().equals(1));
    }
}

