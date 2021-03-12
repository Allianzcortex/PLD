Problem Description :

```
输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

示例 1：

输入：head = [1,3,2]
输出：[2,3,1]
 
```

For all the solutions below,time complexity and space complexity are O(N)

```Java

class Solution {
    public int[] reversePrint(ListNode head) {
        List<Integer> res = new ArrayList<Integer>();
        recur(head,res);
        int[] n=new int[res.size()];
        for(int i=0;i<res.size();i++)
            n[i] = res.get(i);
        return n;
    }

    public void recur(ListNode head,List<Integer> res) {
        if(head==null)
            return;
        recur(head.next,res);
        res.add(head.val);
    }
}

```


Python Solution :

1. solution 1 : using recursive solution
```Python
class Solution:
    def reversePrint(self, head: ListNode) -> List[int]:
        res = []
        self.helper(head,res)
        return res
    
    def helper(self,head,res):
        if head is None:
            return
        self.helper(head.next,res)
        res.append(head.val)
```

2. solution 2 : using iterative solution ,stack

```Python

class Solution:
    def reversePrint(self, head: ListNode) -> List[int]:
        res = []
        while head:
            res.append(head.val)
            head = head.next
        return res[::-1]

```
