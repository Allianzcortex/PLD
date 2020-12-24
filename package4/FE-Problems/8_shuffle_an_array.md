

My solution here : insipred by https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle#The_modern_algorithm

```Latex
-- To shuffle an array a of n elements (indices 0..n-1):
for i from 0 to n−1 do
     j ← random integer such that i ≤ j < n
     exchange a[i] and a[j]
```

```javascript

function shuffle(arr) {
  // modify the arr inline to change the order randomly
  var len = arr.length
  for(let i=0;i<len;i++) {
    const j = i+ Math.floor(Math.random()*(len-i))
    var temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp
  }
}

```

And another implementation will be :

```

```

