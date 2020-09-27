
Java Solution :

This is an intuitive one , but if let me do it again how I can guarantee
that my solution is correct ?

```Java

class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int len = 0;
        for(ListNode cur=root;cur!=null;cur=cur.next)
            len+=1;
        
        int a=len/k,b=len%k;
        
        ListNode[] res = new ListNode[k];
        ListNode node = root,pre=null;
        for(int i=0;node!=null && i<k;i++) {
            res[i] = node;
            for(int j=0;j<a+(b>0?1:0);j++) {
                pre = node;
                node = node.next;
            }
            b-=1;
            pre.next = null;
        }
        
        return res;
    }
}

```

TODO : check those 2 links :

https://leetcode.com/problems/split-linked-list-in-parts/discuss/283301/Intuitive-Java-Solution-With-Explanation

https://leetcode.com/problems/split-linked-list-in-parts/discuss/109284/Elegant-Python-with-Explanation-45ms

https://leetcode.com/problems/split-linked-list-in-parts/discuss/109296/JavaC%2B%2B-Clean-Code
