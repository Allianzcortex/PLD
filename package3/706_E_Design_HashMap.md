Below is accepted solution :

```Python

class ListNode(object):
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.next = None

class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.size = 2000
        self.hash_table = [None] * self.size

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        index = key % self.size
        if self.hash_table[index] is None:
            self.hash_table[index] = ListNode(key, value)
        else:
            head_node = self.hash_table[index]
            while True:
                if head_node.key == key:
                    head_node.value = value
                    return
                if head_node.next is None:
                    break
                head_node = head_node.next
            head_node.next = ListNode(key, value)


    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        index = key % self.size
        # if self.hash_table[index] is None:
        #     return -1
        # else:
        #     head_node = self.hash_table[index]
        #     while head_node.key != key:
        #         head_node = head_node.next
        #     return head_node.value
        head_node = self.hash_table[index]
        while head_node:
            if head_node.key == key:
                return head_node.value
            head_node = head_node.next
        return -1


    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        index = key % self.size
        head_node = self.hash_table[index]
        if head_node is None:
            return
        if head_node.key == key:
            self.hash_table[index] = head_node.next
            return
        # delete a node in middle
        next_node = head_node.next
        while next_node:
            if next_node.key == key:
                head_node.next = next_node.next
                return
            head_node,next_node = head_node.next, next_node.next

```
