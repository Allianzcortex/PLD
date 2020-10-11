
Silly Question :

Java :

```Java

class Solution {
    public String defangIPaddr(String address) {
        return address.replace(".","[.]");
    }
}

```

---

Python :

```Python
class Solution:
    def defangIPaddr(self, address: str) -> str:
        return '[.]'.join(address.split('.'))

```