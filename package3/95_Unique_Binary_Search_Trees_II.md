
Problem description:

```

Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes of unique values from 1 to n. Return the answer in any order.

 

Example 1:


Input: n = 3
Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
Example 2:

Input: n = 1
Output: [[1]]
 

Constraints:

1 <= n <= 8

```


This is my initial thought ans AC solution :

```Java

class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n==0)
            return new ArrayList<TreeNode>();
        int[] input = new int[n];
        for(int i=0;i<n;i++)
            input[i]=i+1;
        
        return buildTree(input,0,n-1);
        
    }
    
    public List<TreeNode> buildTree(int[] input,int left,int right) {
        List<TreeNode> res = new ArrayList<>();
        if(left>right) {
            res.add(null);
            return res;
        }
        if(left==right) {
            res.add(new TreeNode(input[left]));
            return res;
        }
        
        int len=right-left+1;
        for(int i=0;i<len;i++) {
            for(TreeNode leftNode:buildTree(input,left,left+i-1)) {
                for(TreeNode rightNode: buildTree(input,left+i+1,right)) {
                    TreeNode root = new TreeNode(input[left+i]);
                    root.left = leftNode;
                    root.right = rightNode;
                    res.add(root);
                }
            }
        }
        
        return res;
    }
}

```

While apparently there is a better one :https://leetcode.com/problems/unique-binary-search-trees-ii/discuss/31494/A-simple-recursive-solution 

The same idea but whole structure is more clear.

While this problem has a `dp` tag.....

https://leetcode.com/problems/unique-binary-search-trees-ii/discuss/31493/Java-Solution-with-DP

Need to check it later : 

https://leetcode.wang/leetCode-95-Unique-Binary-Search-TreesII.html#%E8%A7%A3%E6%B3%95%E4%B8%89-%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92