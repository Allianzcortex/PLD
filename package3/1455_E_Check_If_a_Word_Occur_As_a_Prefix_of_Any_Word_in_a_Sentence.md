
What's the meaning of doint this problem....

```Java
class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int idx = 0;
        for(String word:sentence.split(" ")) {
            int index = word.indexOf(searchWord);
            if(index==0)
                return idx+1;
            idx += 1;
        }
        
        return -1;
    }
}

```

TODO : add Python solution : index()/find() to be used later