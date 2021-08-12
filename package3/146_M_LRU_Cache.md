
Problem description:

```

Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.

 

Example 1:

Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]

Explanation
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4

```


The basic idea is to use HashMap + Double Two Way LinkedList

key ideas :

1. All use Public variables

2. Make sure the logic is clear

```Java

class LRUCache {
    
    public class DoubleLinkedNode {
         public int key;
         public int value;
         DoubleLinkedNode pre;
         DoubleLinkedNode post;
        
        public DoubleLinkedNode(int key,int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    class DoubleLinkedList {
         DoubleLinkedNode head,tail;
         int size;
        
        public DoubleLinkedList() {
            head = new DoubleLinkedNode(-1,-1);
            tail = new DoubleLinkedNode(-1,-1);
            
            head.post = tail;
            tail.pre = head;
            
            size = 0;
        }
        
        // add recently used.
        public void addLast(DoubleLinkedNode x) {
            
            x.post = tail;
            tail.pre.post = x;
            
            x.pre = tail.pre;
            tail.pre = x;
            
            size ++;
        }
        
        // remove a random node
        public void remove(DoubleLinkedNode x) {
            DoubleLinkedNode pre = x.pre,post = x.post;
            
            pre.post = post;
            post.pre = pre;
            
            size--;
        }
        
        // remove least recently used
        public DoubleLinkedNode removeFirst() {
            if(head.post==tail)
                return null;
            DoubleLinkedNode first = head.post;
            remove(first);
            return first;
        }
      
    }
    
    private Map<Integer,DoubleLinkedNode> map;
    private DoubleLinkedList dList;
    private int cap;
    
    public LRUCache(int capacity) {
        map = new HashMap<Integer,DoubleLinkedNode>();
        dList = new DoubleLinkedList();
        this.cap = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        // map contains key,we should put it into recently used
        DoubleLinkedNode node = map.get(key);
        dList.remove(node);
        dList.addLast(node);
        return node.value;
        
    }
    
    public void put(int key, int value) {
        // two conditions:
        // 1. map contains key already
        // 2. map doesnot contain key
        
        // for 1
        if(map.containsKey(key)) {
           DoubleLinkedNode node = map.get(key);
           dList.remove(node);
           node.value = value;
           dList.addLast(node);
           map.put(key,node);
        } else {
            // for 2
            DoubleLinkedNode node = new DoubleLinkedNode(key,value);
            dList.addLast(node);
            if(this.cap<dList.size) {
                DoubleLinkedNode firstNode = dList.removeFirst();
                map.remove(firstNode.key);
            }
            map.put(key,node);
        }
        
    }
}

```

idea : 构造双向链表

While when I review this answer, I need to say Java solution is a good one, however
very difficult to come up with it during the interview. 

What we need is a more reasonable solution.

Here is my Python version :

Use solution like double-linked-list:

We put the [LRU item] at the end of LRUCache.

Logic:

Get:
    a. if key doesn't exist, return -1
    b. if key exists : 
       1. move the item to the end(delte it firslty & add it)
       2. return value

Put:
    a. if key exists, remvoe it
    b. add the (Key:Value) pair(and move it to the end of LRU Cache)
    c. if it exceeds the cap limit, remove the head item

```Python

class Node(object):
    def __init__(self,key,value):
        self.key = key
        self.value = value
        self._prev = None
        self._next = None

class LRUCache:

    def __init__(self, capacity: int):
        
        self.capacity = capacity
        self.dict = {}
        self.head = Node(0,0)
        self.tail = Node(0,0)
        self.head.next = self.tail
        self.tail.prev = self.head
        

    def get(self, key: int) -> int:

        if key not in self.dict:
            return -1
        node = self.dict[key]
        self._remove(node)
        self._add(node)
        return self.dict[key].value

    def put(self, key: int, value: int) -> None:
        """
        If we find the key exist, we remove the key
        """
        if key in self.dict:
            self._remove(self.dict[key])
        new_node = Node(key,value)
        self._add(new_node)
        if len(self.dict) > self.capacity:
            self._remove(self.head.next)
    
    def _add(self,node):
        """
        tail.prev   tail
        
        wanna insert node to the middle of [tail.prev] and [tail]
        """
        prev_node = self.tail.prev
        # do 4 steps
        # firstly , handle prev_node and middle node
        prev_node.next = node
        node.prev = prev_node
        # secondly , handle middle node and tail
        node.next = self.tail
        self.tail.prev = node
        self.dict[node.key] = node
    
    def _remove(self, node):

        prev_node,next_node = node.prev,node.next
        prev_node.next = next_node
        next_node.prev = prev_node
        del self.dict[node.key]

```

Obviously there will be 2 ways to optimize it :

1. There is no need for Node object. We can use 2 dicts(prev={},next={})
   to store the relationship : https://leetcode.com/problems/lru-cache/discuss/45926/Python-Dict-+-Double-LinkedList/185966

2. We can use a Python built-in data structure called `OrderedDict`.

It will be like below:

```Python

from collections import OrderedDict
class LRUCache:
    def __init__(self, Capacity):
        self.size = Capacity
        self.cache = OrderedDict()

    def get(self, key):
        if key not in self.cache: return -1
        val = self.cache[key]
        self.cache.move_to_end(key)
        return val

    def put(self, key, val):
        if key in self.cache: del self.cache[key]
        self.cache[key] = val
        if len(self.cache) > self.size:
            self.cache.popitem(last=False)
```

---

下面是构造双向链表的 `Golang` 解法，关键是注意在初始化的时候要把
`head.next=tail` 和 `tail.prev=head` 给设置，代码如下：

```Go

type Node struct {
    prev *Node;
    next *Node;
    
    key int;
    val int;
}

type LRUCache struct {
    head *Node;
    tail *Node;
    record map[int]*Node;
    cap int;
}

func (this *LRUCache) init(cap int) {
    
    this.head = &Node{}
    this.tail = &Node{}
    
    this.head.next = this.tail
    this.tail.prev = this.head
    
    this.cap = cap
    this.record = make(map[int]*Node)
}



func Constructor(capacity int) LRUCache {

    root := LRUCache{}
    root.init(capacity)
    
    return root
}


func (this *LRUCache) Get(key int) int {
    
    node,ok := this.record[key]
    
    if !ok {
        return -1
    }
    
    this.removeFromChain(node)
    this.addNodeToHead(node)
    return node.val
}


func (this *LRUCache) Put(key int, value int)  {
    
    node,ok := this.record[key]
    
    if !ok {
        node = &Node{key:key,val:value}
        this.addNodeToHead(node)
    } else {
        node.val = value
        this.removeFromChain(node)
        this.addNodeToHead(node)
    }
      
    if(len(this.record) > this.cap) {
       
        this.removeFromChain(this.tail.prev)
    }
    
    this.record[key] = node
}

func (this *LRUCache) removeFromChain(node *Node) {
    
    prevNode:=node.prev
    nextNode:=node.next
    
    prevNode.next = nextNode
    nextNode.prev = prevNode
    delete(this.record,node.key)
}

func (this *LRUCache) addNodeToHead(node *Node) {
    //
    // head  (node)  head.next
    // 
    nextNode:=this.head.next
    
    // build relationship between head and node
    this.head.next = node
    node.prev = this.head
    
    // build relationship between node and next
    nextNode.prev = node
    node.next = nextNode
    
    // add key
    this.record[node.key] = node
}

```