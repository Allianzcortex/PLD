
My initial thought is as follows , its wrong :

``` java
class Solution {
    public String removeDuplicateLetters(String s) {
        if(s==null || s.length()==0)
            return s;
        StringBuilder res = new StringBuilder();
        int[] arr = new int[26];
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            if(arr[ch-'a']==0) {
                res.append(ch);
                arr[ch-'a']+=1;
            }
        }
        char[] ch = res.toString().toCharArray();
        Arrays.sort(ch);
        return String.valueOf(ch);
    }
}

```

And this is Stack solution

```Java

class Solution {
    public String removeDuplicateLetters(String s) {
        if(s==null || s.length()==0)
            return s;
        Deque<Character> stack = new ArrayDeque<>();
        boolean[] visited = new boolean[26];
        int[] count = new int[26];
        char[] arr = s.toCharArray();
        for(char ch:arr)
            count[ch-'a']+=1;
        
        for(char ch:arr) {
            int index = ch-'a';
            count[index]--;
            if(visited[index])
                continue;
            
            while(!stack.isEmpty() && ch<stack.peek() && count[stack.peek()-'a']>0)
                visited[stack.pop()-'a'] = false;
            stack.push(ch);
            visited[index] = true;
        }
        
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()) 
            res.append(stack.pop());
        return res.reverse().toString();
    }
}

```

---

Python Solution : # this is not checked

Still Stack Version

```Python

def removeDuplicateLetters(self, s):
	"""
	:type s: str
	:rtype: str
	"""
	last_index = {}
	for index, ch in enumerate(s):
		last_index[ch] = index 
	cur_result = []
	for i, ch in enumerate(s):
		if ch not in cur_result:
			while cur_result and ch < cur_result[-1] and i < last_index[cur_result[-1]]:
				cur_result.pop()
			cur_result.append(ch)
	return ''.join(cur_result)

```