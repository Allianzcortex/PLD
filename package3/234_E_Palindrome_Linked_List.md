
Problem description :

```
Given the head of a singly linked list, return true if it is a palindrome.

 

Example 1:


Input: head = [1,2,2,1]
Output: true
Example 2:


Input: head = [1,2]
Output: false

```

思路就是 :

// 1 找到中点 find the middle
// 2 反转后半部分 reverse linked list

下面是 Python 解法：

```Python

class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        
        slow,fast = head,head
        
        while fast is not None and fast.next is not None:
            slow = slow.next
            fast = fast.next.next
        
        newHead = self.reverseList(slow)
        return self.isEqual(newHead,head)
    
    def reverseList(self,head):
        if head is None or head.next is None:
            return head
        
        nextHead = self.reverseList(head.next)
        head.next.next = head
        head.next = None
        return nextHead
    
    
    def isEqual(self,l1,l2):

        while l1 and l2:
            if l1.val != l2.val:
                return False
            
            l1 = l1.next
            l2 = l2.next
        
        return True

```

---

这是 Java 解法：

Java Solution : 

```Java

class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null)
            return true;
        ListNode slow=head,fast=head;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return compareLinkedList(head,reverseLinkedList(slow));
        
    }
    
    // reverse method 1
    // public ListNode reverseLinkedList(ListNode head) {
    //     if(head==null || head.next==null)
    //         return head;
    //     ListNode nextHead = reverseLinkedList(head.next);
    //     head.next.next = head;
    //     head.next = null;
    //     return nextHead;
    // }
    
    // reverse method 2
    public ListNode reverseLinkedList(ListNode head) {
    // pre   cur
        // 1 -2 -3 4
        ListNode pre=null,cur=head;
        while(cur!=null) {
            cur = head.next;
            head.next = pre;
            pre = head;
            head = cur;
        }
        
        return pre;
    }
    
    public boolean compareLinkedList(ListNode h1,ListNode h2) {
        while(h2!=null) {
            if(h1.val!=h2.val)
                return false;
            h1 = h1.next;
            h2 = h2.next;
        }
        
        return true;
    }
}

```

---

Python Solution : 

```Python


```