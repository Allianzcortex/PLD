

This is my Solution :

```Java

class Solution {
    public String reformat(String s) {
        List<Character> letters = new ArrayList<>();
        List<Character> digits = new ArrayList<>();
        
        for(char ch:s.toCharArray()) {
            if(Character.isDigit(ch))
                digits.add(ch);
            else
                letters.add(ch);
        }
        
        if(Math.abs(letters.size()-digits.size())>=2)
            return "";
        StringBuilder res = new StringBuilder();
        int i=0;
        // actually we can get the size() firstly and then compare
        for(;i<Math.min(letters.size(),digits.size());i++) {
            res.append(letters.get(i));
            res.append(digits.get(i));
        }
        
        if(i<letters.size())
            res.append(letters.get(i));
        if(i<digits.size())
            res.insert(0,digits.get(i));
        
        return res.toString();
    }
}

```

There is one way to reduce the space complexity without the use of 2 lists :

https://leetcode.com/problems/reformat-the-string/discuss/669082/Java-just-count-num-of-digits-and-letters

Maybe will check it later

---

This is a better Python solution :

https://leetcode.com/problems/reformat-the-string/discuss/586674/Python-Simple-solution

TODO : add Python solution