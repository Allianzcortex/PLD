
Problem Description :

```

Given two integer arrays nums1 and nums2, return the maximum length of a subarray that appears in both arrays.

Example 1:

Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
Output: 3
Explanation: The repeated subarray with maximum length is [3,2,1].
Example 2:

Input: nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
Output: 5
 

Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 100

```

This problem is equal to `longest common substring` , so the structure is very similar to 
`longest common subsequence` , the difference is equation :

when `nums1[i-1] != nums2[j-1]` , we should set `dp[i][j] = 0`

Below is Java Solution :

```Java
class Solution {
    public int findLength(int[] A, int[] B) {
        if(A==null || B==null || A.length==0 || B.length==0)
            return 0;
        int m=A.length;
        int n=B.length;
        int[][] dp=new int[m+1][n+1];
        int max=0;
        for(int i=0;i<=m;i++) {
            for(int j=0;j<=n;j++) {
                if(i==0 || j==0){
                    dp[i][j]=0;
                } else if(A[i-1]==B[j-1]) {
                    dp[i][j]=1+dp[i-1][j-1];
                    max = Math.max(dp[i][j],max);
                }
                
            }
        }

        return max;
    }
}
```

Below is Python Solution :

```Python

class Solution:
    def findLength(self, nums1: List[int], nums2: List[int]) -> int:
        """
        This is used to find Longest common substring
        """
        l1,l2 = len(nums1),len(nums2)
        
        dp = [ [0]*(l2+1) for _ in range(l1+1) ]
        
        res = 0

        for i in range(1,l1+1):
            for j in range(1,l2+1):
                if nums1[i-1] == nums2[j-1]:
                    dp[i][j] = dp[i-1][j-1] + 1
                    res = max(dp[i][j],res)
                else:
                    dp[i][j] = 0
        
        return res
        # or it's equal to : 
        # return max(max(item) for item in dp)

```