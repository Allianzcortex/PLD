

Java Solution

```Java

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null)
            return null;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        for(int i=0;i<n;i++)
            second = second.next;
        while(second!=null && second.next!=null){
            first = first.next;
            second = second.next;
        }
        // 下面的问题是难点，自己花了很多时间试着在 first 和 second 之间建立联系
        // 最后发现其实没有必要，直接把 first.next.next 赋值给 first.next 就够了
        // if(second.next==null && (first==second || first.next==second))
        //     second = null;
        // first.next = second;
        first.next = first.next.next;
        return dummy.next;
        
    }
}

```


TODO: check discussion for other solutions & Python solution