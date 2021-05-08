```Java
class Solution {
    public double average(int[] salary) {
        // solution 1
        // Arrays.sort(salary);
        // double res=0;
        // for(int i=1;i<salary.length-1;i++)
        //     res+=salary[i];
        // return res/(salary.length-2);
        
        // solution 2
        double res=0;
        double min=salary[0],max=salary[0];
        for(int s:salary) {
            min=Math.min(min,s);
            max=Math.max(max,s);
            res+=s;
        }
        return (res-min-max)/(salary.length-2);
    }
}

```