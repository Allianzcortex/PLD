
Problem description:

```

Given a fixed-length integer array arr, duplicate each occurrence of zero, shifting the remaining elements to the right.

Note that elements beyond the length of the original array are not written. Do the above modifications to the input array in place and do not return anything.

 

Example 1:

Input: arr = [1,0,2,3,0,4,5,0]
Output: [1,0,0,2,3,0,0,4]
Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
Example 2:

Input: arr = [1,2,3]
Output: [1,2,3]
Explanation: After calling your function, the input array is modified to: [1,2,3]
 

Constraints:

1 <= arr.length <= 104
0 <= arr[i] <= 9

```

Basic idea:

这道题如果只是要在新的数组上得出结果，还是挺简单的：

```Golang

 res := make([]int,len(arr))
    
    for i,j:=0,0;j<len(arr); {
        
        if arr[i]!=0 {
            res[j] = arr[i]
            j+=1
        } else {
            j+=2
        }
        
        i += 1
    }

```

更进一步的是，可以用 zero count 的方法从后往前比较，方法如下：

```Golang

func duplicateZeros(arr []int)  {
    
    var zerosCount int
    
    for _,val := range arr {
        if val==0 {
            zerosCount += 1
        }
    }
    
    right := len(arr)-1
    j := right
    
    for i:=right;i>=0;i-- {
        
        // for edge case :
        // If we find 0 at the right of array
        if i+zerosCount==right+1 && arr[i]==0 {
            arr[j]=0
            j-=1
            continue
        }
        
        if i+zerosCount<=right {
            if(arr[i]!=0) {
                arr[j]=arr[i]
                j-=1
            } else {
                arr[j]=0
                arr[j-1]=0
                j-=2
            }
        }
       
        if arr[i]==0 {
            zerosCount -= 1
        }
    }
}

```

题解里还有其他更通用的、不用考虑 edge case 的方法，后续再看