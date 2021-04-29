Problem Description :

```
Another basic algorithm even for Front End developers.

You are asked to reverse a linked list.

Suppose we have Node interface like this

class Node {
   new(val: number, next: Node);
   val: number
   next: Node
}
We can then chain nodes together to create a linked list.

const Three = new Node(3, null)
const Two = new Node(2, Three)
const One = new Node(1, Two)

//now we have  a linked list
// 1 → 2 → 3
Now how can you reverse it to 3 → 2 → 1 ? you can modify the next property of each node, but not the val.

Follow up

Could you solve it with and without recursion?

```

Solution：

With 2 solutions

```javascript

const reverseLinkedList = (list) => {
    
    if(list===null || list.next===null) {
        return list;
    }

    // Solution 1 recursive 
    // nextNode = reverseLinkedList(list.next);
    // list.next.next = list;
    // list.next = null;
    // return nextNode;

    // Solution 2 iterative
    let prev = null;
    let cur = list;

    while(cur) {
        list = cur.next;
        cur.next = prev;
        prev = cur;
        cur = list;
    }

    return prev;
}

```