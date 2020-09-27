
Initially I want to use two nodes `head tail` to do it,but soon 
realize that it can be too complex when handling null value...
So use only `head` will be enough.

```Java

class MyLinkedList {

    /** Initialize your data structure here. */
    
    class LinkedNode {
        int val;
        LinkedNode next;
        
        public LinkedNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    
    private int length = 0;
    
    private LinkedNode head;
    
    public MyLinkedList() {
        head = null;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        
        if(index<0 || index>=length)
            return -1;
        LinkedNode cur = head;
        while(index-->0) {
            cur = cur.next;
        }
        return cur.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        LinkedNode newHead = new LinkedNode(val);
        length += 1;
        if(head==null) {
            head = newHead;    
            return;
        }
        newHead.next = head;
        head = newHead;
       
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        length += 1;
        LinkedNode newTail = new LinkedNode(val);
        if(head==null) {
            head = newTail;
            return;
        }
        LinkedNode tail=head;
        while(tail.next!=null)
            tail = tail.next;
        tail.next = newTail;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index<0 || index>length)
            return ;
        LinkedNode cur = head;
        if(index==0)
            addAtHead(val);
        else if(index==length)
            addAtTail(val);
        else {
            while(--index>0)
                cur = cur.next;
            LinkedNode temp = new LinkedNode(val);
            temp.next = cur.next;
            cur.next = temp;
            length += 1;
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index<0 || index>=length)
            return;
        
        length -= 1;
        if(index==0) {
            head = head.next;
            return;
        }
        LinkedNode cur = head;
        while(--index>0)
            cur = cur.next;
        cur.next = cur.next.next;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */


```

TODO : Add Python Solution