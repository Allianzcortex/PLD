Problem Description :

```

TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk.

Design the encode and decode methods for the TinyURL service. There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.

```

---

Here I will only provide Python Solution :

Solution 1:using a counter 

```python

class Codec:
    
    def __init__(self):
        self.map = []
    
    def encode(self, longUrl: str) -> str:
        """Encodes a URL to a shortened URL.
        """
        self.map.append(longUrl)
        return f"http://tinyurl.com/{len(self.map)-1}"
        

    def decode(self, shortUrl: str) -> str:
        """Decodes a shortened URL to its original URL.
        """
        return self.map[int(shortUrl.split("/")[-1])]

```

Apparently there are some disadvantages for solution 1 , like :

```
- If I'm asked to encode the same long URL several times, it will get several entries. That wastes codes and memory.
- People can find out how many URLs have already been encoded. Not sure I want them to know.
- People might try to get special numbers by spamming me with repeated requests shortly before their desired number comes up.
- Only using digits means the codes can grow unnecessarily large. Only offers a million codes with length 6 (or smaller). Using six digits or lower or upper case letters would offer (10+26*2)6 = 56,800,235,584 codes with length 6.

```

Solution 2:using a random string generated function as HashMap

```Python

class Codec:
    
    def __init__(self) :
        self.url2code = {}
        self.code2url = {}
    
    def encode(self, longUrl: str) -> str:
        """Encodes a URL to a shortened URL.
        """
        # using while to avoid generating duplicated code for different urls
        while longUrl not in self.url2code:
            code = ''.join(random.choice(string.ascii_letters) for _ in range(6))
            if code not in self.code2url:
                self.url2code[longUrl] = code
                self.code2url[code] = longUrl
        return f'http://tinyurl.com/{self.url2code[longUrl]}'
        

    def decode(self, shortUrl: str) -> str:
        """Decodes a shortened URL to its original URL.
        """
        code = shortUrl.split('/')[-1]
        return self.code2url[code]

```

There is a related shortulr system design discussion : 

https://leetcode.com/discuss/interview-question/124658/Design-a-URL-Shortener-(-TinyURL-)-System/

