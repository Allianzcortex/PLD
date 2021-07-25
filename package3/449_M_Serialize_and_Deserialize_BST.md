
The 1st idea is to not conider 

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