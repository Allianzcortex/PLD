
There can be multiple solutions for it :

1. Use recursive solution : 

``` javascript
function flat(arr, depth = 1) {
  // your imeplementation here
  
  if(depth===0  || !Array.isArray(arr)) {
    return arr;
  } 
  let res = [];
  for(item of arr) {
      res = res.concat(flat(item,depth-1));
    }
  
  return res;
}

```

2. Use iterateive solution :

```javascript

// TODO

```