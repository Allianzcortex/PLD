
Problem description:

```

Suppose we have a class:

public class Foo {
  public void first() { print("first"); }
  public void second() { print("second"); }
  public void third() { print("third"); }
}
The same instance of Foo will be passed to three different threads. Thread A will call first(), thread B will call second(), and thread C will call third(). Design a mechanism and modify the program to ensure that second() is executed after first(), and third() is executed after second().

Note:

We do not know how the threads will be scheduled in the operating system, even though the numbers in the input seem to imply the ordering. The input format you see is mainly to ensure our tests' comprehensiveness.

 

Example 1:

Input: nums = [1,2,3]
Output: "firstsecondthird"
Explanation: There are three threads being fired asynchronously. The input [1,2,3] means thread A calls first(), thread B calls second(), and thread C calls third(). "firstsecondthird" is the correct output.
Example 2:

Input: nums = [1,3,2]
Output: "firstsecondthird"
Explanation: The input [1,3,2] means thread A calls first(), thread B calls third(), and thread C calls second(). "firstsecondthird" is the correct output.
 

Constraints:

nums is a permutation of [1, 2, 3].

```

Basic idea:

这是一道很经典的并发控制题目，我要用 Java & Golang 来完成

首先是 Java 解法：

Java 第一种解法是用 CountDownLatch。Java 里的 CountDownLatch 
就类似于 Golang 的 waitGroup.

解法如下：

```Java

import java.util.concurrent.*;

class Foo {

    private final CountDownLatch l2;
    private final CountDownLatch l3;
    
    public Foo() {
        l2 = new CountDownLatch(1);
        l3 = new CountDownLatch(1);
    }

    // 3 需要等待 l3 解锁
    // 2 需要等待 l2 解锁，运行完后解锁 l3
    // 1 可以直接运行，运行完后解锁 l2
    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        l2.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        l2.await();
        printSecond.run();
        l3.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        l3.await();
        printThird.run();
    }
}

```

对此 Golang 解法如下：

可以用 2 个 Group ，也可以用 2 个 channel 来实现
互相阻塞

下面是用 2 个 channel 的实现，当然最后还是要用一个 wg 来确保
等到所有的 goroutine 都执行完后才结束程序

Golang 解法如下：

```Golang

package main

import (
    "fmt"
     "sync"
)

var (
    wg  sync.WaitGroup
)

var ch1 = make(chan struct{})
var ch2 = make(chan struct{})

type Foo struct {   
}

func (f *Foo) first(){
    fmt.Print("first")
    ch1<-struct{}{}
}  

func (f *Foo) second(){
    <-ch1
    fmt.Print("second");
    ch2<-struct{}{}
}  

func (f *Foo) third(){
    <-ch2
    fmt.Println("third");
    wg.Done()
}  

func main() {

    f:=&Foo{}
    wg.Add(1)
    go f.third()
    go f.first()
    go f.second()
    
    wg.Wait()
}

```

WaitGroup 也是很像的实现