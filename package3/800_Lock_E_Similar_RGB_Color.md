
Problem Description :

```

In the following, every capital letter represents some hexadecimal digit from 0 to f.
The red-green-blue color "#AABBCC" can be written as "#ABC" in shorthand.  For example, "#15c" is shorthand for the color "#1155cc".
Now, say the similarity between two colors "#ABCDEF" and "#UVWXYZ" is -(AB - UV)^2 - (CD - WX)^2 - (EF - YZ)^2.
Given the color "#ABCDEF", return a 7 character color that is most similar to #ABCDEF, and has a shorthand (that is, it can be represented as some "#XYZ"
Example 1:
Input: color = "#09f166"
Output: "#11ee66"
Explanation:  
The similarity is -(0x09 - 0x11)^2 -(0xf1 - 0xee)^2 - (0x66 - 0x66)^2 = -64 -9 -0 = -73.
This is the highest among any shorthand color.
Note:
color is a string of length 7.
color is a valid RGB color: for i > 0, color[i] is a hexadecimal digit from 0 to f
Any answer which has the same (highest) similarity as the best answer will be accepted.
All inputs and outputs should use lowercase letters, and the output is 7 characters.

```

TODO : As usual, not validated yet.

```Java

class Solution {
    public String similarRGB(String color) {
        if (color == null || color.length() == 0) {
            return "";
        }
 
        String[] dict = new String[]{"00", "11", "22", "33", "44", "55", "66", "77", "88", "99", 
                                     "aa", "bb", "cc", "dd", "ee", "ff"};
        int minDistance = Integer.MAX_VALUE;
        String ans = "";
 
        for (String R : dict) {
            for (String G: dict) {
                for (String B : dict) {
                    String s = "#" + R + G + B;
                    int distance = getDistance(s, color);
                    if (distance < minDistance) {
                        ans = s;
                        minDistance = distance;
                    }
                }
            }
        }
 
        return ans;
    }
 
    private int getDistance(String a, String b) {
        int distance = 0;
        for (int i = 1; i < 7; i += 2) {
            int n1 = Integer.parseInt(a.substring(i, i + 2), 16);
            int n2 = Integer.parseInt(b.substring(i, i + 2), 16);
            distance += (n1 - n2) * (n1 - n2);
        }
 
        return distance;
    }
}

```

Aonther Article :

https://duoertai.gitbooks.io/leetcode-solutions/content/string/similar-rgb.html


