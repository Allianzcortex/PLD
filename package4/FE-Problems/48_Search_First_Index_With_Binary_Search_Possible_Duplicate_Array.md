Problem Description:

```
This is a variation of 37. implement Binary Search (unique).

Your are given a sorted ascending array of number, but might have duplicates, you are asked to return the first index of a target number.

If not found return -1.

note

Please don't use Array.prototype.indexOf(), it is not our goal.

```

Solution:

```javascript


/**
 * @param {number[]} arr - ascending array with duplicates
 * @param {number} target
 * @return {number}
 */
function firstIndex(arr, target){
  if(arr===null || arr.length===0){
      return -1;
  }
  let left=0,right=arr.length-1,result = -1;
  while(left<=right) {
    const middle = left + Math.floor((right-left) / 2);
    if(arr[middle]>target) {
      right = middle-1;
    } else if(arr[middle]<target) {
      left = middle+1;
    } else {
      // Now we know middle is an available answer
      // But we will still wanna figure out whether there
      // is a target at the left side
      result = middle;
      right = middle-1;
    }
  }

  return result;
}


```