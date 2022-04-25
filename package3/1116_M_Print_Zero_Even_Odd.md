
Problem description:

```

You have a function printNumber that can be called with an integer parameter and prints it to the console.

For example, calling printNumber(7) prints 7 to the console.
You are given an instance of the class ZeroEvenOdd that has three functions: zero, even, and odd. The same instance of ZeroEvenOdd will be passed to three different threads:

Thread A: calls zero() that should only output 0's.
Thread B: calls even() that should only output even numbers.
Thread C: calls odd() that should only output odd numbers.
Modify the given class to output the series "010203040506..." where the length of the series must be 2n.

Implement the ZeroEvenOdd class:

ZeroEvenOdd(int n) Initializes the object with the number n that represents the numbers that should be printed.
void zero(printNumber) Calls printNumber to output one zero.
void even(printNumber) Calls printNumber to output one even number.
void odd(printNumber) Calls printNumber to output one odd number.
 

Example 1:

Input: n = 2
Output: "0102"
Explanation: There are three threads being fired asynchronously.
One of them calls zero(), the other calls even(), and the last one calls odd().
"0102" is the correct output.
Example 2:

Input: n = 5
Output: "0102030405"
 

Constraints:

1 <= n <= 1000

```

Basic idea:

很直观的思路，开始把一个 chan<- 写入到 zero 函数里，
然后输出一个 0 后再依次写入 oddChan 或者 evenChan，然后
oddChan/evenChan 再写入到 zeroChan 里，如此循环往复


```Golang

package main

import (
	"fmt"
	"sync"
)

type ZeroEvenOdd struct {
	oddChan  chan int
	zeorChan chan int
	evenChan chan int

	cnt int
	wg  sync.WaitGroup
}

func (zeo *ZeroEvenOdd) zero() {
	defer zeo.wg.Done()

	for num := 0; num < zeo.cnt; num++ {
		<-zeo.zeorChan
		fmt.Print("0")
		if num%2 == 0 {
			zeo.oddChan <- num + 1
		} else {
			zeo.evenChan <- num + 1
		}
	}
}

func (zeo *ZeroEvenOdd) odd() {
	defer zeo.wg.Done()

	for i := 0; i < zeo.cnt; i += 2 {
		num := <-zeo.oddChan
		fmt.Print(num)
		zeo.zeorChan <- num
	}
}

func (zeo *ZeroEvenOdd) even() {
	defer zeo.wg.Done()

	for i := 1; i < zeo.cnt; i += 2 {
		num := <-zeo.evenChan
		fmt.Print(num)
		zeo.zeorChan <- num
	}

}

func main() {

	const N = 4
	zeo := &ZeroEvenOdd{
		oddChan:  make(chan int),
		evenChan: make(chan int),
		zeorChan: make(chan int, 1),
		cnt:      N,
		wg:       sync.WaitGroup{},
	}
	zeo.wg.Add(3)
	zeo.zeorChan <- 1
	go zeo.zero()

	go zeo.odd()
	go zeo.even()
	zeo.wg.Wait()
	fmt.Println("\n finish")
}


```