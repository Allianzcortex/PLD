
Below is my javascript solution

so simple...one-pass 

```javascript

function binarySearch(arr, target){
  // your code here
  var left=0,right=arr.length-1;
  while(left<=right) {
    var middle = left + Math.floor((right-left)/2);
    if(arr[middle]==target)
      return middle;
    else if(arr[middle]>target)
      right = middle-1;
    else
      left = middle+1;
  }
  return -1;
}


```