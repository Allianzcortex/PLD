Problem Description : 

```md

Given a list of ascending three-digits integers representing a binary with the depth smaller than 5. You need to return the sum of all paths from the root towards the leaves.
If the depth of a tree is smaller than 5, then this tree can be represented by a list of three-digits integers.
For each integer in this list:
The hundreds digit represents the depth D of this node, 1 <= D <= 4.
The tens digit represents the position P of this node in the level it belongs to, 1 <= P <= 8. The position is the same as that in a full binary tree.
The units digit represents the value V of this node, 0 <= V <= 9.
Example 1:
Input: [113, 215, 221]
Output: 12
Explanation: 
The tree that the list represents is:
    3
   / \
  5   1

The path sum is (3 + 5) + (3 + 1) = 12.

Example 2:
Input: [113, 221]
Output: 4
Explanation: 
The tree that the list represents is: 
    3
     \
      1

The path sum is (3 + 1) = 4.

```

The key is to get the postion :

left most 2 digits are positions.

For node xy,its left child is (x+1)(y*2-1)? and right child is (x+1)(y*2)

for example : 11 -> level is 1 , position is 1 -> 
(1+1)*10 + (1*2-1) = 21.
(1+1)*10 + (1*2) = 22.

The whole structure is clear...yet the answer is not validated yet.


```Java

    int sum = 0;
    Map<Integer, Integer> tree = new HashMap<>();
    
    public int pathSum(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        for (int num : nums) {
            int key = num / 10;
            int value = num % 10;
            tree.put(key, value);
        }
        
        traverse(nums[0] / 10, 0);
        
        return sum;
    }
    
    private void traverse(int root, int preSum) {
        int level = root / 10;
        int pos = root % 10;
        int left = (level + 1) * 10 + pos * 2 - 1;
        int right = (level + 1) * 10 + pos * 2;
        
        int curSum = preSum + tree.get(root);
        
        if (!tree.containsKey(left) && !tree.containsKey(right)) {
            sum += curSum;
            return;
        }
        
        if (tree.containsKey(left)) traverse(left, curSum);
        if (tree.containsKey(right)) traverse(right, curSum);
    }

```