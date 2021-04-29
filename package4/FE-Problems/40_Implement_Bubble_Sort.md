Problem Description:

```

Even for Front-End Engineer, it is a must to understand how basic sorting algorithms work.

Now you are asked to implement Bubble Sort, which sorts an integer array in ascending order.

Do it in-place, no need to return anything.

Follow-up

What is time cost for average / worst case ? Is it stable?

```

Solution:

```javascript

/**
 * @param {number[]} arr
 */
function bubbleSort(arr) {
  // your code here
  for(let i=0;i<arr.length;i++) {
    for(let j=0;j<arr.length-i-1;j++) {
        if(arr[j]>arr[j+1]) {
          let temp = arr[j];
          arr[j] = arr[j+1];
          arr[j+1] = temp;
        }
    }
  }
}

// let arr=[3,2,1]
// bubbleSort(arr)
// console.log(arr)

```