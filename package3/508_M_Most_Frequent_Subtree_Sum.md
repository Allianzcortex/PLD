
Problem description:

```

Given the root of a binary tree, return the most frequent subtree sum. If there is a tie, return all the values with the highest frequency in any order.

The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself).

 

Example 1:


Input: root = [5,2,-3]
Output: [2,-3,4]
Example 2:


Input: root = [5,2,-5]
Output: [2]

```

Basic idea:

这道题的题意阐述是非常模糊的，但大概也能知道是在说什么
就是对每个结点，left node / right node / left + right + root
三个值，然后用一个 counter 来纪录

对应的 Python 解法如下：

```Python

class Solution:
    def findFrequentTreeSum(self, root: Optional[TreeNode]) -> List[int]:
        
        counter = defaultdict(lambda:0)
        
        self.max = 0
        self.dfs(root,counter)
        
        return [key for key in counter if counter[key]==self.max]
    
    
    def dfs(self,root,counter):
        if not root:
            return 0
        
        val = root.val+self.dfs(root.left,counter)+self.dfs(root.right,counter)
        counter[val] += 1
        if counter[val]>self.max:
            self.max = counter[val]
        
        return val

```