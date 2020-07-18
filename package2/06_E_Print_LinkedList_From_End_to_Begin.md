```Java

class Solution {
    public int[] reversePrint(ListNode head) {
        List<Integer> res = new ArrayList<Integer>();
        recur(head,res);
        int[] n=new int[res.size()];
        for(int i=0;i<res.size();i++)
            n[i] = res.get(i);
        return n;
    }

    public void recur(ListNode head,List<Integer> res) {
        if(head==null)
            return;
        recur(head.next,res);
        res.add(head.val);
    }
}

```