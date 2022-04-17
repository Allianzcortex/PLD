
Problem Description :

```
Given the head of a linked list, return the list after sorting it in ascending order.

Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?

 

Example 1:


Input: head = [4,2,1,3]
Output: [1,2,3,4]
Example 2:


Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]
Example 3:

Input: head = []
Output: []
 

```

这道题直接用归并排序。

首先找到 middle，然后把 middl.next 设为 None.
然后调用 mergeLinkedList() 的方法

Below is Java Solution :

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

Next is Python solution :


```Python

class Solution:
    def sortList(self, head: ListNode) -> ListNode:
        # 使用归并排序
        
        if head is None or head.next is None:
            return head
        
        slow,fast = head,head
        
        while fast.next is not None and fast.next.next is not None:
            fast = fast.next.next
            slow = slow.next
        
        newHead = slow.next
        slow.next = None
        
        return self.mergeList(self.sortList(head),self.sortList(newHead))
    
    def mergeList(self,l1,l2):
        
        dummy = ListNode()
        head = dummy
        
        while l1 and l2:
            if l1.val<l2.val:
                head.next = l1
                l1 = l1.next
            else:
                head.next = l2
                l2 = l2.next
            
            head = head.next
        
        head.next = l1 or l2
        return dummy.next

```