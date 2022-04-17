
Problem description:

```
Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a Unix-style file system, convert it to the simplified canonical path.

In a Unix-style file system, a period '.' refers to the current directory, a double period '..' refers to the directory up a level, and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'. For this problem, any other format of periods such as '...' are treated as file/directory names.

The canonical path should have the following format:

The path starts with a single slash '/'.
Any two directories are separated by a single slash '/'.
The path does not end with a trailing '/'.
The path only contains the directories on the path from the root directory to the target file or directory (i.e., no period '.' or double period '..')
Return the simplified canonical path.

 

Example 1:

Input: path = "/home/"
Output: "/home"
Explanation: Note that there is no trailing slash after the last directory name.
Example 2:

Input: path = "/../"
Output: "/"
Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
Example 3:

Input: path = "/home//foo/"
Output: "/home/foo"
Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
Example 4:

Input: path = "/a/./b/../../c/"
Output: "/c"
 

Constraints:

1 <= path.length <= 3000
path consists of English letters, digits, period '.', slash '/' or '_'.
path is a valid absolute Unix path.

```

Basic idea:

这道题是栈的典型问题，Python 解法如下：
注意在遇到 `..` 的时候先检验栈是否为空再弹出

```Python

class Solution:
    def simplifyPath(self, path: str) -> str:
        
        res = []
        
        for direc in path.split("/"):
            if not direc:
                continue
            
            if direc=='.':
                continue
            elif direc=='..':
                if res:
                    res.pop()
            else:
                res.append(direc)
        
        return f"/{'/'.join(res)}"

```

The solution I use

```Java

class Solution {
    public String simplifyPath(String path) {
        Stack<String> s = new Stack<>();
        StringBuilder res = new StringBuilder();
        for(String p:path.split("/")) {
            if(p.equals("") || p.equals("."))
                continue;
            if(p.equals("..")){
                if(s.size()>0)
                    s.pop();
            }
            else
                s.push(p);    
        }
        
        
        for(String item:s) {
            res.append("/");
            res.append(item);
           
        }
        
        return res.length()==0?"/":res.toString();
        
    }
}

```