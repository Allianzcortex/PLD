
Problem description:

```

请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。

 

例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：

[
  [3],
  [20,9],
  [15,7]
]

```

Idea : 这道题很显然，有两种解法，一是递归，二是迭代。

首先上迭代的解法：

这是 Python 版本，一次 AC:

```Python

class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        res = []
        if not root:
            return res

        queue = Deque([root])
        index = 0

        while queue:
            size = len(queue)
            if len(res)==index:
                res.append([])
            
            for _ in range(size):
                node = queue.popleft()
                if index%2==0:
                    res[index].append(node.val)
                else:
                    res[index].insert(0,node.val)
                
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            
            index += 1
        return res
```

而迭代版本的 Golang 解法如下：

```Golang

func levelOrder(root *TreeNode) [][]int {
    res:=[][]int{}
    if root==nil {
        return res
    }

    queue:=[]*TreeNode{root}
    index := 0

    for len(queue)>0 {
        size:=len(queue)
        temp:=[]int{}
        for i:=0;i<size;i++ {
            node:=queue[0]
            if index%2==0{
                temp=append(temp,node.Val)
            } else {
                /**
                应该注意下这里 Golang 对 slice 的 preappend
                更好的解决方法应该是
                temp:=make([]int,size)
                temp[size-i-i] = node.Val
                **/
                temp=append([]int{node.Val},temp...)
            }

            if(node.Left!=nil) {
                queue=append(queue,node.Left)
            }
            if(node.Right!=nil) {
                queue=append(queue,node.Right)
            }

            queue=queue[1:]
        }

        index += 1
        res=append(res,temp)
    }

    return res
}


```


---


Problem I

```Java

class Solution {
    public int[] levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        List<Integer> res=new ArrayList<Integer>();
        // Queue API
        // https://www.geeksforgeeks.org/queue-interface-java/
        while(!queue.isEmpty()) {
            TreeNode currentNode=queue.poll();
            if(currentNode==null)
                continue;
            res.add(currentNode.val);
            queue.add(currentNode.left);
            queue.add(currentNode.right);
        }

        int[] n=new int[res.size()];
        for(int i=0;i<res.size();i++)
            n[i] = res.get(i);
        return n;
    }
}

```


---

Problem II

```Java

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        traverse(root,res,1);
        return res;
    }

    public void traverse(TreeNode root,List<List<Integer>> res,int level) {
        if(root==null)
            return;
        if(level>res.size())
            res.add(new ArrayList<Integer>());
        res.get(level-1).add(root.val);
        traverse(root.left,res,level+1);
        traverse(root.right,res,level+1);   
    }
}

```

---

Problem III

Not the optimal one

```Java

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        traverse(root,res,1);
        return res;
    }

    public void traverse(TreeNode root,List<List<Integer>> res,int level) {
        if(root==null)
            return;
        if(level>res.size())
            res.add(new ArrayList<Integer>());
        if(level%2==1){
        res.get(level-1).add(root.val);
        } else {
            res.get(level-1).add(0,root.val);
        }

        traverse(root.left,res,level+1);
        traverse(root.right,res,level+1);   
        
    }
}

```