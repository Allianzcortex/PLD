Problem Description:

```
This is a variation of 37. implement Binary Search (unique).

Your are given a sorted ascending array of number, but might have duplicates, you are asked to return the last index of a target number.

If not found return -1.

note

Please don't use Array.prototype.lastIndexOf(), it is not our goal.

```

The basic idea is the same with Problem 48

Solution

```javascript

/**
 * @param {number[]} arr - ascending array with duplicates
 * @param {number} target
 * @return {number}
 */
function lastIndex(arr, target){
   if(arr===null || arr.length===0){
      return -1;
  }
  let left=0,right=arr.length-1,result = -1;

  while(left<=right) {
    const middle = left + Math.floor((right-left)/2);
    if(arr[middle]>target) {
      right = middle-1;
    } else if(arr[middle]<target) {
      left = middle+1;
    } else {
      result = middle;
      left = middle+1;
    }
  }

  return result;
}


```