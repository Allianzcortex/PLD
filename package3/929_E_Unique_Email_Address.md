
Problem description:

```

Every valid email consists of a local name and a domain name, separated by the '@' sign. Besides lowercase letters, the email may contain one or more '.' or '+'.

For example, in "alice@leetcode.com", "alice" is the local name, and "leetcode.com" is the domain name.
If you add periods '.' between some characters in the local name part of an email address, mail sent there will be forwarded to the same address without dots in the local name. Note that this rule does not apply to domain names.

For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.
If you add a plus '+' in the local name, everything after the first plus sign will be ignored. This allows certain emails to be filtered. Note that this rule does not apply to domain names.

For example, "m.y+name@email.com" will be forwarded to "my@email.com".
It is possible to use both of these rules at the same time.

Given an array of strings emails where we send one email to each email[i], return the number of different addresses that actually receive mails.

 

Example 1:

Input: emails = ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
Output: 2
Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails.
Example 2:

Input: emails = ["a@leetcode.com","b@leetcode.com","c@leetcode.com"]
Output: 3

```

Basic idea:

这道题自己 2018 年底的时候还用 Golang 做过，真的，时间都不知道怎么过的

```Golang

func numUniqueEmails(emails []string) int {
    if len(emails)==0 {
        return 0
    }
    
    var localname string
    var domainname string
    
    dict:=make(map[string]bool)
    for _,value:=range(emails){
        s:=strings.Split(value,"@")
        localname,domainname = s[0],s[1]
        
        // deal with localname
        if strings.Contains(localname,".") {
            localname=strings.Replace(localname,".","",-1)
        }
    
        
        if strings.Contains(localname,"+") {
            localname=strings.Split(localname,"+")[0]
        }
        
        dict[localname+domainname]=true
    
        
    }
    
    return len(dict)
    
}

```

这道题自己一开始的 Python 解法如下：

```Python

class Solution:
    def numUniqueEmails(self, emails: List[str]) -> int:
        s = set()
        
        for email in emails:
            local,domain = email.split('@')
            temp = []
            for ch in local:
                if ch=='+':
                    break
                if ch=='.':
                    continue
                temp.append(ch)
            s.add(f"{''.join(temp)}@{domain}")
        
        return len(s)

```

一种优化的方式是用 `replace+split` 来替换：

```Python

class Solution:
    def numUniqueEmails(self, emails: List[str]) -> int:
        s = set()
        
        for email in emails:
            local,domain = email.split('@')
            local = local.split('+')[0].replace('.','')
            s.add(f'{local}@{domain}')
        
        return len(s)

```