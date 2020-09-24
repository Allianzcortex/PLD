
This is my solution :

```Java

class Solution {
    public char findTheDifference(String s, String t) {
        int[] cnt = new int[26];
        for(char ch:s.toCharArray())
            cnt[ch-'a']+=1;
        for(char ch:t.toCharArray())
            cnt[ch-'a']-=1;
        
        for(int i=0;i<26;i++) {
            if(cnt[i]==-1)
                return (char)('a'+i);
        }
        
        return 'a';
    }
}

```

while it can be optimized from two ways :

1. Use only a variable to represent the char code.

```Java

class Solution {
    public char findTheDifference(String s, String t) {
        int code=(int)t.charAt(s.length());
        for(int i=0;i<s.length();i++) {
            code-=(int)s.charAt(i);
            code+=(int)t.charAt(i);
        }
        
        return (char)code;
    }
}

```

2. Use Bit Manipulation // TO Check it later

```Java
public char findTheDifference(String s, String t) {
	char c = 0;
	for (int i = 0; i < s.length(); ++i) {
		c ^= s.charAt(i);
	}
	for (int i = 0; i < t.length(); ++i) {
		c ^= t.charAt(i);
	}
	return c;
}

or

public char findTheDifference(String s, String t) {
	int n = t.length();
	char c = t.charAt(n - 1);
	for (int i = 0; i < n - 1; ++i) {
		c ^= s.charAt(i);
		c ^= t.charAt(i);
	}
	return c;
}

```

TODO : check more about bit manipulation and python solution