
Problem description:

```

Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

 

Example 1:


Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]
Example 2:

Input: root = [1,null,3]
Output: [1,3]
Example 3:

Input: root = []
Output: []

```

Basic idea :

用 BFS，每一层去除最后一个元素，Python 解法如下：

```Python

class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        
        if root is None:
            return []
        
        res = []
        queue = Deque([root])
        
        while queue:
            length = len(queue)
            for i in range(length):
                root = queue.popleft()
                
                if root.left is not None:
                    queue.append(root.left)
                    
                if root.right is not None:
                    queue.append(root.right)
                    
                if i==length-1:
                    res.append(root.val)
        return res

```

另外一种解法就是用 DFS，在每次循环时候：

先遍历右边，再遍历左边。每次循环时 depth+= 1，用 depth 来判断是否要加入这个元素
然后对应的代码如下：

```Java

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null)
            return res;
        
        rightView(res,root,0);
        return res;
    }
    
    public void rightView(List<Integer> res,TreeNode root,int depth) {
        if(root==null)
            return;
        if(res.size()<=depth)
            res.add(root.val);
        rightView(res,root.right,depth+1);
        rightView(res,root.left,depth+1);
    }
    
}

```
---

发现自己还有 2015 年时候用的 C++ 解法，真是唤醒了尘封的记忆：

```C++

class Solution {
    private:
        vector<int> res;
        void rightSideView_(TreeNode *root, int level) {
            if (root) {
                if (res.size()<= level) 
                    res.push_back(root->val);
                rightSideView_(root->right, level+1);
                rightSideView_(root->left, level+1);
            }
        }

    public:
        vector<int> rightSideView(TreeNode *root) {
            res.clear();
            rightSideView_(root, 0);
            return res;
        }
    };

```