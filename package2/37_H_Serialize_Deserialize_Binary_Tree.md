There are two solutions:

1. For the tree like 

```
    1
   / \
  2   3
     / \
    4   5
```

Solution 1 what we get is `1,2,3,#,#,4,5,#,#,#,#,`

```Java

public class Codec {

    public String serialize(TreeNode root) {
        // TODO: why cannot use List<> = new LinkedList<>
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
        System.out.println(res.toString());
        return res.toString().trim();
        
    }

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

And Solution2 what we get is : `1,2,#,#,3,4,#,#,5,#,#`

```Java
public class Codec {

   public String serialize(TreeNode root) {
        String res = serial(new StringBuilder(), root).toString();
        System.out.println(res);
        return res;
    }
    
    // Generate preorder string
    private StringBuilder serial(StringBuilder str, TreeNode root) {
        if (root == null) return str.append("#");
        str.append(root.val).append(",");
        serial(str, root.left).append(",");
        serial(str, root.right);
        return str;
    }

    public TreeNode deserialize(String data) {
        return deserial(new LinkedList<>(Arrays.asList(data.split(","))));
    }
    
    // Use queue to simplify position move
    private TreeNode deserial(Queue<String> q) {
        String val = q.poll();
        if ("#".equals(val)) return null;
        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = deserial(q);
        root.right = deserial(q);
        return root;
    }
 
}



```