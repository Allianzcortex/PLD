

Java Solution :

Apparently there are many solutions 

MergeSort is only one of them : 

```Java

// 最后就是要考链表的归并排序嘛
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null &&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        
        ListNode middle = slow.next;
        slow.next=null;
        
        return mergeSort(sortList(head),sortList(middle));
    }
    
    public ListNode mergeSort(ListNode h1,ListNode h2){
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while(h1!=null || h2!=null){
            if(h1!=null && (h2==null || h1.val<=h2.val)){
                head.next=h1;
                h1=h1.next;
            }else if(h2!=null && (h1==null || h2.val<=h1.val)){
                head.next=h2;
                h2=h2.next;
            }
            head=head.next;
        }
        head.next=null;
        return dummy.next;
    }
}

```

TODO : Add Python Solution