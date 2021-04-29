Problem Description:

```
Even for Front-End Engineer, it is a must to understand how basic sorting algorithms work.

Now you are asked to implement Quick Sort, which sorts an integer array in ascending order.

Do it in-place, no need to return anything.

Follow-up

What is time cost for average / worst case ? Is it stable?
```

Solution:

```javascript

/**
 * @param {number[]} arr
 */
function quickSort(arr) {
  // your code here
  if(arr.length===0) {
    return;
  }

  Sort(arr,0,arr.length-1);
}

function Sort(arr,left,right) {
  if(left>=right) {
    return;
  }
  const pivot = findPivot(arr,left,right);
  Sort(arr,left,pivot-1);
  Sort(arr,pivot+1,right);
}

function findPivot(arr,left,right) {
  const pivot = arr[left];
  while(left<right) {
  while(left<right && arr[right]>=pivot) {
    right-=1;
  }
  arr[left] = arr[right];

  while(left<right && arr[left]<=pivot) {
    left+=1;
  }
    arr[right] = arr[left];
    swap(arr,left,right);
  }

  arr[left] = pivot;
  return left;

}

function swap(arr,left,right) {
  let temp = arr[left];
  arr[left] = arr[right];
  arr[right] = temp;
}

```