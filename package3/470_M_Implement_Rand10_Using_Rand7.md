

```Java
/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        int res = 40;
        while(res>=40) {
            res = (rand7()-1)*7+rand7()-1;
        }
        
        return res%10+1;
    }
}

```

Explanations :

```
rand7()-1 = [0,1,2,3,4,5,6]
(rand7()-1)*7 = [0,7,14,21,28,35,42]
(rand7()-1)*7+rand7()-1 = [0,7,14,21,28,35,42] + [0,1,2,3,4,5,6]

iterate over : multiple : it will be :

[0,1,2,3,4,5,6,7,8...48]

we only use 0-19 and discard 40-48

```

And may need to check more explanations later.