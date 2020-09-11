There should be multiple solutions,
Currently I only provide bucket one.

```Java
class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(char ch:s.toCharArray()) {
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        // +1 is important, almost always forget it 
        // its used to handle the case like `eeeee`
        LinkedList<Character>[] bucket = new LinkedList[s.length()+1];
        for(Map.Entry<Character,Integer> entry:map.entrySet()) {
            int frequence = entry.getValue();
            if(bucket[frequence]==null)
                bucket[frequence]=new LinkedList<>();
            bucket[frequence].add(entry.getKey());
        }

        StringBuilder res = new StringBuilder();
        for(int i=bucket.length-1;i>=0;i--) {
            if(bucket[i]!=null) {
                for(Character ch:bucket[i]) {
                    for(int j=0;j<i;j++)
                        res.append(ch);
                }
            }
        }

        return res.toString();
    }
}

```