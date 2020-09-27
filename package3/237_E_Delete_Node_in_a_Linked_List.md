
Java Solution : 

```Java

class Solution {
    public void deleteNode(ListNode node) {
        if(node.next==null) {
            node=null;
            return;
        }
        // 4 5 1 9
        node.val=node.next.val;
        node.next=node.next.next;
        return;
    }
}

```