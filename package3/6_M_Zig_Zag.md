
This is not a complex problem, while I make it too complicated... ( :

Java Solution:

This is my intuitive idea....mock the behaviour

```Java
class Solution {
    public String convert(String s, int numRows) {
        boolean isDown = true;
        int index = 0;
        List<List<Character>> res = new ArrayList<>();
        for(int i=0;i<numRows;i++)
            res.add(new ArrayList<Character>());
        
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            res.get(index).add(ch);
            if(isDown) {
                // go down
                if(index==numRows-1) {
                    index = Math.max(0,index-1);
                    isDown = false;
                }
                else
                    index+=1;
            } else {
                // go up
                if(index==0) {
                    isDown = true;
                    index = Math.min(index+1,numRows-1);
                }
                else 
                    index-=1;
            }
        }
        
        StringBuilder output = new StringBuilder();
        for(int i=0;i<numRows;i++) {
            for(Character ch:res.get(i)) {
                // System.out.print(ch+" ");
                output.append(ch);
            }
        }
        
        return output.toString();
    }
}

```

Actually there is no need for it,we can use a better way :

```Java

class Solution {
    public String convert(String s, int numRows) {
        int len = s.length();
        StringBuilder[] res = new StringBuilder[numRows];
        for(int i=0;i<numRows;i++)
            res[i] = new StringBuilder();
        
        int i=0;
        while(i<len) {
            for(int j=0;j<numRows && i<len;j++) {
                res[j].append(s.charAt(i++));
            }
            for(int j=numRows-2;j>=1 && i<len;j--) {
                res[j].append(s.charAt(i++));
            }
            
        }
        
        for(i=1;i<numRows;i++)
            res[0].append(res[i]);
        return res[0].toString();
        
        
//         There is no need to be so complex.
//         StringBuilder output = new StringBuilder();
//         for(StringBuilder builder:res) {
//             output.append(builder.toString());
//         }
        
//         return output.toString();
    }
}

```