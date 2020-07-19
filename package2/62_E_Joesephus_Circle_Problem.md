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