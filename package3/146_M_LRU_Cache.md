
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