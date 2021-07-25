

```Java


```

Python Solution :

```Python

class Solution:
    def destCity(self, paths: List[List[str]]) -> str:
        return (set(x[1] for x in paths)-set(x[0] for x in paths)).pop()

```