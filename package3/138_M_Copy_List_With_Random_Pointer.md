
problem description :

```
A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.

Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.

For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.

Return the head of the copied linked list.

The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

val: an integer representing Node.val
random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
Your code will only be given the head of the original linked list.

 

Example 1:


Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
Example 2:


Input: head = [[1,1],[2,1]]
Output: [[1,1],[2,1]]
Example 3:



Input: head = [[3,null],[3,0],[3,null]]
Output: [[3,null],[3,0],[3,null]]
Example 4:

Input: head = []
Output: []
Explanation: The given linked list is empty (null pointer), so return null.
 

Constraints:

```

Idea : 这道题应该算是很经典的题型了，用一个 Map 来存储原始 Node 和新 Node 的对应
关系，然后再在第二轮循环里更新节点的 next 和 random 指针

Python 解法如下：

```Python

class Solution:
    def copyRandomList(self, head: 'Node') -> 'Node':
        
        if not head:
            return None

        maps = {}
        
        index1,index2 = head,head
        
        while index1:
            maps[index1] = Node(index1.val)
            index1 = index1.next
        
        while index2:
            curNode = maps[index2]
            curNode.next = maps.get(index2.next,None)
            curNode.random = maps.get(index2.random,None)
            
            index2 = index2.next
        
        return maps[head]
```

---

Golang 解法如下：

第一种是还是延续上面的解法来迭代：

```Golang

func copyRandomList(head *Node) *Node {
    
    m:=make(map[*Node]*Node)
    
    for index1:=head;index1!=nil;index1=index1.Next {
        // or we can omit some parameters when initializing structure
        // m[index1]=&Node{Val:index1.Val,Next:nil,random:nil}
        m[index1]=&Node{Val:index1.Val}
    }
    
    for index2:=head;index2!=nil;index2=index2.Next {
        m[index2].Next = m[index2.Next]
        m[index2].Random = m[index2.Random]   
    }
    
    return m[head]
    
}

```

第二种是仍然用 `map`，不过要用 DFS 来递归：

```Golang

func copyRandomList(head *Node) *Node {
    
    m:=make(map[*Node]*Node)
    
    return copyNode(head,m)
}

func copyNode(head *Node,m map[*Node]*Node) *Node {
    if head==nil {
        return nil
    }
    
    if node,ok:=m[head];ok {
        return node
    }
    
    copyHead := &Node{Val:head.Val}
    
    // 因为有 Random 指针，所以为了避免死循环要提前把 m[head] 放好
    m[head] = copyHead
    
    copyHead.Next = copyNode(head.Next,m)
    copyHead.Random = copyNode(head.Random,m)

    
    return copyHead
}

```


---

Java 解法如下：

```Java

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)
            return null;
        Map<Node,Node> map = new HashMap<Node,Node>();
        
        // loop 1 store all nodes
        Node node = head;
        while(node!=null){
            map.put(node,new Node(node.val,node.next,node.random));
            node = node.next;
        }
        
        // loop2 build new relationship
        node = head;
        while(node!=null){
            map.get(node).next=map.get(node.next);
            map.get(node).random=map.get(node.random);
            node=node.next;
        }
        
        return map.get(head);
        
    }
}

```
