
My Solution:

```Java
class Solution {
    public boolean detectCapitalUse(String word) {
        int upperCount = 0;
        if(word==null || word.length()==0)
            return false;
        
        for(char ch:word.toCharArray()) {
            if(Character.isUpperCase(ch)) {
                upperCount+=1;
            }
        }
        
        return upperCount==0 || upperCount==word.length() || (upperCount==1 && Character.isUpperCase(word.charAt(0)));
    }
}

```

Its equal to :

```Java

 public boolean detectCapitalUse(String word) {
       return word.substring(1).equals(word.substring(1).toLowerCase())||word.equals(word.toUpperCase());
       }

```

---

Python version : 

```Python
class Solution:
    def detectCapitalUse(self, word: str) -> bool:
        return word[1:]==word[1:].lower() or word==word.upper()

```