
Very classic Stack problem , just like next greater element

```Java

class Solution {
    public int[] dailyTemperatures(int[] T) {
        
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];
        for(int i=0;i<T.length;i++) {
            while(!stack.isEmpty() && T[stack.peek()]<T[i]) {
                int j = stack.pop();
                // res[stack.pop()] = i-stack.peek();
                res[j] = i-j;
        }
            stack.push(i);
        }

        return res;
    }
}

```