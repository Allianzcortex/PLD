
Problem description:

```

Suppose we have a file system that stores both files and directories. An example of one system is represented in the following picture:



Here, we have dir as the only directory in the root. dir contains two subdirectories, subdir1 and subdir2. subdir1 contains a file file1.ext and subdirectory subsubdir1. subdir2 contains a subdirectory subsubdir2, which contains a file file2.ext.

In text form, it looks like this (with ⟶ representing the tab character):

dir
⟶ subdir1
⟶ ⟶ file1.ext
⟶ ⟶ subsubdir1
⟶ subdir2
⟶ ⟶ subsubdir2
⟶ ⟶ ⟶ file2.ext
If we were to write this representation in code, it will look like this: "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext". Note that the '\n' and '\t' are the new-line and tab characters.

Every file and directory has a unique absolute path in the file system, which is the order of directories that must be opened to reach the file/directory itself, all concatenated by '/'s. Using the above example, the absolute path to file2.ext is "dir/subdir2/subsubdir2/file2.ext". Each directory name consists of letters, digits, and/or spaces. Each file name is of the form name.extension, where name and extension consist of letters, digits, and/or spaces.

Given a string input representing the file system in the explained format, return the length of the longest absolute path to a file in the abstracted file system. If there is no file in the system, return 0.

 

Example 1:


Input: input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"
Output: 20
Explanation: We have only one file, and the absolute path is "dir/subdir2/file.ext" of length 20.
Example 2:


Input: input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"
Output: 32
Explanation: We have two files:
"dir/subdir1/file1.ext" of length 21
"dir/subdir2/subsubdir2/file2.ext" of length 32.
We return 32 since it is the longest absolute path to a file.
Example 3:

Input: input = "a"
Output: 0
Explanation: We do not have any files, just a single directory named "a".
Example 4:

Input: input = "file1.txt\nfile2.txt\nlongfile.txt"
Output: 12
Explanation: There are 3 files at the root directory.
Since the absolute path for anything at the root directory is just the name itself, the answer is "longfile.txt" with length 12.
 

Constraints:

1 <= input.length <= 104
input may contain lowercase or uppercase English letters, a new line character '\n', a tab character '\t', a dot '.', a space ' ', and digits.

```

Basic idea:

一次 AC yeah ! !

自己一开始的想法是争取的，就是用 `\n` 来分割，之后数 `\t` 来获得 directory 的
level，用 map 存储。再然后得到绝对路径：

Python 解法如下：

```Python

class Solution:
    def lengthLongestPath(self, input: str) -> int:
        
        """
        So for this problem, the key is to parse the input
        
        create a map : {key:value}
        key is the count of `\t`
        value is directory
        """
        1
        direcs = defaultdict(list)
        max_res = 0
        
        for item in input.split('\n'):
            
            space_count = item.count("\t")
            name = item.strip("\t")
            
            if '.' not in item:
                # it's a dicrectory
                direcs[space_count].append(name)
            else:
                # it's a file,we want to generate the absolute path
                file_path = self.generate_path(direcs,space_count,name)
                max_res = max(max_res,len(file_path))
        
        return max_res
        
    def generate_path(self,direcs,space_count,name):
            """
            if space_count is 2
            we want to find all directories from space_count:0,space_count:1
            """
            res = []
            for i in range(space_count):
                res.append(direcs[i][-1])
            res.append(name)
            
            return "/".join(res)

```

可以优化的点就在于不用 `generate_path` 这种生成整个路径的方法，直接得到当前路径的
长度就可以。

