
Since there are no brackets so only one stack is enough.

```Java

class Solution {
    public int calculate(String s) {
        Stack<Integer> stack=new Stack<Integer>();
        s=s.replaceAll(" ","");
        int res = 0;
        char[] arr=s.toCharArray();
        for(int i=0;i<arr.length;i++) {
        //    System.out.println(i +" index "+arr[i]);
           char op = i==0?'+':arr[i-1];
           while(i<arr.length && Character.isDigit(arr[i])) {
               res=res*10+arr[i]-'0';
               i++;
           }
           
           switch(op) {
               case '-':
                res = -res;
                break;
               case '*':
                res=stack.pop()*res;
                break;
               case '/':
                 res=stack.pop()/res;
                 break;
                default:
                  break;
           }
           stack.push(res);
           res = 0;
        }
        int sum=0;
        while(!stack.isEmpty())
            sum+=stack.pop();
        return sum;
    }
}


```