
Problem description:

```


```

Two solutions:

1. mock
2. get the math expression

Solution 1 :

```Java

class Solution {
    public int lastRemaining(int n, int m) {
    //  0 1 2 3 4 
        if(n==0||m==0)
		return -1;
     List<Integer> list=new ArrayList<>();
     for(int i=0;i<n;i++)
     	list.add(i);
     int c=(m-1)%n;
     while(list.size()!=1) {
     	list.remove(c);
     	c=(c+m-1)%list.size();  
     }
     return list.get(0);
    }
}


```


https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solution/huan-ge-jiao-du-ju-li-jie-jue-yue-se-fu-huan-by-as/

这个解释是最清楚的，逆推公式，只关注最后一个元素的变化：

Python 解法如下：

```Python

class Solution:
    def lastRemaining(self, n: int, m: int) -> int:
        pos = 0 # for f(1,m)

        for i in range(2,n+1):
            pos = (pos+m)%i 
        
        return pos

```

