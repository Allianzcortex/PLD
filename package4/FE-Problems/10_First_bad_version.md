
Below is my solution :

Classic Binary Search

```javascript

/*
 type TypIsBad = (version: number) => boolean
 */

/**
 * @param {TypIsBad} isBad 
 */
function firstBadVersion(isBad) {
	// firstBadVersion receive a check function isBad
  // and should return a closure which accepts a version number(integer)
  return (version) => {
    // write your code to return the first bad version
    // if none found, return -1
    var left=1,right=version;
    while(left<right) {
       var middle = left+Math.floor((right-left)/2)
       if(isBad(middle))
         right=middle-1;
      else
        left=middle+1;
    }
    
    return isBad(left)?left:-1;
  }
}


```