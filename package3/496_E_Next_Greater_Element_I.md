
Overall there I will provide 2 solutions:

The 1st one is most trikcy : O(N^2)

Use Map to get the index and compare , somehow like 2-sum

```Java
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if(nums1==null || nums2==null)
            return new int[]{};
        int[] res = new int[nums1.length];
        HashMap<Integer,Integer> counter = new HashMap<Integer,Integer>();
        for(int i=0;i<nums2.length;i++)
            counter.put(nums2[i],i);
        for(int i=0;i<nums1.length;i++){
            int position=-1;
            for(int j=counter.get(nums1[i])+1;j<nums2.length;j++){
                if(nums2[j]>nums1[i]){
                    position=nums2[j];
                    break;
                }
            }
            res[i]=position;
        }
        
        return res;
        
    }
}

```

Using stack is the best way to do it :

for an array like [5 4 3 6]
fristly we put 3 items in stack : [5,4,3]
and while `6 > any of [5,4,3]`,we can put the map:
(5,6)-(4,6)-(3,6)

```Java

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        Stack<Integer> s  = new Stack<>();
        
        for(int num:nums2) {
            while(!s.isEmpty() && s.peek()<num)
                map.put(s.pop(),num);
            s.push(num);
        }
        
        for(int i=0;i<nums1.length;i++)
            nums1[i] = map.getOrDefault(nums1[i],-1);
        
        return nums1;
    }
}

```

---

Python Solution:

```Python

class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        stack = []
        map = {}
        for num in nums2:
            while(len(stack)>0 and stack[-1]<num):
                map[stack.pop()] = num
            stack.append(num)
        
        res = []
        for num in nums1:
            res.append(map.get(num,-1))
        return res
        

```