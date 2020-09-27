
Solution 1 :

Java Solution :

```Java
class Solution {
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        for(int num:G)
            set.add(num);
        int res = 0;
        
        while(head!=null) {
            if(set.contains(head.val) && (head.next==null || !set.contains(head.next.val)))
                res++;
            head = head.next;
        }
        
        return res;
    }
}

```

Solution 2 : A very similar idea

```Java

class Solution {
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        for(int num:G)
            set.add(num);
        int res = 0;
        
        while(head!=null) {
            if(set.contains(head.val)) {
                res += 1;
                while(head.next!=null && set.contains(head.next.val))
                    head = head.next;
            }
            head = head.next;
        }
        
        return res;
    }
}


```


TODO : add Python solution