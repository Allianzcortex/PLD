
Problem description:

```

Serialization is converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You need to ensure that a binary search tree can be serialized to a string, and this string can be deserialized to the original tree structure.

The encoded string should be as compact as possible.

 

Example 1:

Input: root = [2,1,3]
Output: [2,1,3]
Example 2:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 104].
0 <= Node.val <= 104
The input tree is guaranteed to be a binary search tree.

```

Basic idea:

相比于 297 要 encode binary tree，449 的题目本身其实已经是简化了

基本思路就是用中序遍历，按照 `中->左->右` 的序列来。

这里有两种方法来处理 Null Value:

1. 第一种是：

2. 第二种是：

The 1st idea is to not consider 

```Java
public class Codec {
    
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        serialize(root,res);
        return res.toString();
    }
    
    public void serialize(TreeNode root,StringBuilder sb) {
        if(root==null)
            sb.append("#").append(",");
        else {
            sb.append(root.val).append(",");
            serialize(root.left,sb);
            serialize(root.right,sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return deSerialize(queue);
    }
    
    public TreeNode deSerialize(Queue<String> queue) {
        String cur = queue.poll();
        if(cur.equals("#"))
            return null;
    
        TreeNode root = new TreeNode(Integer.parseInt(cur));
        root.left = deSerialize(queue);
        root.right = deSerialize(queue);
        return root;
    }
}

```