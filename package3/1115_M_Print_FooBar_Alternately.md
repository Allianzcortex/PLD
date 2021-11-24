
Problem description:

```

Suppose you are given the following code:

class FooBar {
  public void foo() {
    for (int i = 0; i < n; i++) {
      print("foo");
    }
  }

  public void bar() {
    for (int i = 0; i < n; i++) {
      print("bar");
    }
  }
}
The same instance of FooBar will be passed to two different threads:

thread A will call foo(), while
thread B will call bar().
Modify the given program to output "foobar" n times.

 

Example 1:

Input: n = 1
Output: "foobar"
Explanation: There are two threads being fired asynchronously. One of them calls foo(), while the other calls bar().
"foobar" is being output 1 time.
Example 2:

Input: n = 2
Output: "foobarfoobar"
Explanation: "foobar" is being output 2 times.
 

Constraints:

1 <= n <= 1000

```

Basic idea:

自己用 Golang 的解法如下：

```Golang

package main

import (
	"fmt"
	"sync"
)

type S struct {
}

var wg sync.WaitGroup
var ch1 = make(chan int)
var ch2 = make(chan int)

func (s *S) foo(n int) {
	for i := 0; i < n; i++ {
		<-ch1
		fmt.Print("foo")
		ch2 <- 1
	}
	wg.Done()
}

func (s *S) bar(n int) {
	for i := 0; i < n; i++ {
		<-ch2
		fmt.Print("bar")
        // 这里用 i!=n-1 是保证到了最后循环的时候不被卡住
        // 或者也可以用 ch1 := make(chan int,1) 这样的带 buffer channel
		if i != n-1 {
			ch1 <- 1
		}
	}
	wg.Done()
}

func main() {
	s := &S{}
	wg.Add(2)
	go s.foo(5)
	go s.bar(5)
	ch1 <- 1
	wg.Wait()
}

```