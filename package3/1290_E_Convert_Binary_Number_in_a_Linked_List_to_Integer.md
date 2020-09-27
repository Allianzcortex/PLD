
Simple like a cake...

Java Solution

```Java

class Solution {
    public int getDecimalValue(ListNode head) {
        int sum=0;
        while(head!=null) {
            // num <<= 1; LOL
            sum = sum*2+head.val;
            head = head.next;
        }
        
        return sum;
    }
}

```

And surely using `Stack` can also be an option :

```Java

public int getDecimalValue(ListNode head) {
        ListNode current = head;
        Stack<Integer> stack = new Stack<>();
        while (current != null) {
            stack.add(current.val);
            current = current.next;
        }
        int sum = 0;
        int index = 0;
        while (!stack.isEmpty()) {
            if (stack.pop() == 1) {
                sum = sum + (int)Math.pow(2, index);
            }
            index++;
        }
        return sum;
    }

```