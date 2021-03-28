Problem Description : 

```
Given a non-empty string containing an out-of-order English representation of digits 0-9, output the digits in ascending order.

Note:
Input contains only lowercase English letters.
Input is guaranteed to be valid and can be transformed to its original digits. That means invalid inputs such as "abc" or "zerone" are not permitted.
Input length is less than 50,000.
Example 1:
Input: "owoztneoer"

Output: "012"
Example 2:
Input: "fviefuro"

Output: "45"

```

Explanation: 

This problem is not realted with algorithm,it's more like about how to find the order :

So for the number, it can be splited into two types : odd & even

`even` :

```
zero   # z is special,only zero contains z
two    # w is special
four   # u is special
six    # x is special
eight  # g is special
```

`odd` :

```
one    # it can be calculated by O(n)-(O(zero)+O(two)+O(four)) = O(n)-(O(z+O(w)+O(u)))
three  # O(r)-(O(zero)+O(four)) = O(n)-(O(z)+O(u))
five   # others can be calculated by the same way
seven
nine
```

Then the answer will be :

```Python
class Solution:
    def originalDigits(self, s: str) -> str:
        from collections import Counter
        counter = Counter(s)
        res=[0 for _ in range(10)] 
        # map, get even count
        res[0] = counter['z']
        res[2] = counter['w']
        res[4] = counter['u']
        res[6] = counter['x']
        res[8] = counter['g']
        # get odd count
        res[1] = counter['o'] - (res[0]+res[2]+res[4])
        res[3] = counter['r'] - (res[0] + res[4])
        res[5] = counter['f'] - res[4]
        res[7] = counter['s'] - res[6]
        res[9] = counter['i'] - (res[5]+res[6]+res[8])

        return ''.join(str(index)*freq for index,freq in enumerate(res))

```