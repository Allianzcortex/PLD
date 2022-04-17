
Problem description:

```

Your are given a 2-D array of characters. There is a hidden message in it.

I B C A L K A
D R F C A E A
G H O E L A D 
The way to collect the message is as follows

start at top left
move diagonally down right
when cannot move any more, try to switch to diagonally up right
when cannot move any more, try switch to diagonally down right, repeat 3
stop when cannot neither move down right or up right. the character on the path is the message
for the input above, IROCLED should be returned.

notes

if no characters could be collected, return empty string

```

Basic idea:

没什么太难的，根据基本的步骤来，用一个 `toggle` 来标记方向，算是 easy 题

Below is my solution :

Just follow the logic and set 2 different directions.

```javascript

function decode(message) {

  if(!message || !message[0]) {
    return "";
  }
  const row = message.length;
  const column = message[0].length;

  let [i,j] = [0,0]
  let res = []
  let toggle  = true

  while(true) {
    if(j==column) {
      break;
    }

    res.push(message[i][j]);
    j+=1;

    if(toggle  && i==row-1) {
      // reach bottom,change direction and move i+1
      toggle  = false;
      i-=1;
    } else if(!toggle  && i==0) {
      // reach top,change direction and move i-1
      toggle  = true;
      i+=1;
    } else {
      // in all other cases
      if(toggle ) {
        i+=1;
      } else {
        i-=1;
      }
    }

  }

  return res.join("");

}

```