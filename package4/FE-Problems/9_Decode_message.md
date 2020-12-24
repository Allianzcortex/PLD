
Below is my solution :

Just follow the logic and set 2 different directions.

```javascript
function decode(message) {
  // your code here
  var flag = true
  var res = ""
  var row = message.length
  if(row==0)
    return "";
  var column = message[0].length
  var x=0,y=0;
  while(true) {
      if(x<0 || x>=row || y<0 || y>=column)
        break;
      res+=message[x][y];
      if(flag) {
        x+=1;
        y+=1;
      } else {
        x-=1;
        y+=1;
      }
      if(x==0)
        flag=true;
      else if(x==row-1)
        flag=false;
  }
  
  return res;
}

```

TODO: add other solutions