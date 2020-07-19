
```Java

class Solution {
    public String minNumber(int[] nums) {

        // A more effective way
//         class Solution {
//     public String minNumber(int[] nums) {
//         List<String> list = new ArrayList<>();
//         for (int num : nums) {
//             list.add(String.valueOf(num));
//         }
//         list.sort((o1, o2) -> (o1 + o2).compareTo(o2 + o1));
//         return String.join("", list);
//     }
// }

        String[] input=new String[nums.length];
        for(int i=0;i<nums.length;i++){
            input[i]=String.valueOf(nums[i]);
        }
        Arrays.sort(input,(x,y)->(x+y).compareTo(y+x));
        StringBuilder res=new StringBuilder();
        for(String str:input)
            res.append(str);
        return res.toString();
    }
}

```