
Problem description:

```

Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

 

Example 1:


Input: root = [1,2,3,null,null,4,5]
Output: [1,2,3,null,null,4,5]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [1]
Output: [1]
Example 4:

Input: root = [1,2]
Output: [1,2]

```

idea :

这道题是关于数组的序列与反序列化，思路：

- 对序列化，哪怕是子节点的左右 children 也存储，所有 None 的节点用 "#" 特殊字符来存储

- 对反序列化，对第一个节点(给定输入的第一个值)用 root 表示，然后加入 deque 里。然后每
隔两个数，如果不为空就定义一个节点，设置对应的 left/right，并再次加入 deque 里。

Python 解法如下：

```Python

class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        if not root:
            return []
        
        queue = deque([root])
        res = []
        
        while queue:
            curr = queue.popleft()
            
            if curr is None:
                res.append("#")
            else:
                res.append(curr.val)
                queue.append(curr.left)
                queue.append(curr.right)

        return res
            
        

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        
        if not data:
            return None
        
        root = TreeNode(data[0])
        queue = deque([root])
        
        index = 1
        while index<len(data):
            curr = queue.popleft()
            
            if data[index]!='#':
                leftNode = TreeNode(data[index])
                curr.left = leftNode
                queue.append(leftNode)
            
            if data[index+1]!='#':
                rightNode = TreeNode(data[index+1])
                curr.right = rightNode
                queue.append(rightNode)
            
            index += 2
        
        return root


```

---

Java 解法如下：

```Java

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // why cannot use List<> = new LinkedList<>
        Queue<TreeNode> list = new LinkedList<TreeNode>();
        StringBuilder res = new StringBuilder();
        if(root==null)
            return "null"; // handle the corner case
        list.add(root);
        while(list.size()>0) {
            TreeNode current = list.poll();
            if(current==null){
                res.append("#").append(",");
            }
            else{
                res.append(current.val).append(",");
                list.add(current.left);
                list.add(current.right);
            }
        }
        return res.toString().trim();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
       if (data == "null") return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] values = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);
        for (int i = 1; i < values.length; i++) {
            TreeNode parent = q.poll();
            if (!values[i].equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                q.add(left);
            }
            if (!values[++i].equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(right);
            }
        }
        return root;
    }
}

```