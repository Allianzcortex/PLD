
Problem description:

```
You have the four functions:

printFizz that prints the word "Fizz" to the console,
printBuzz that prints the word "Buzz" to the console,
printFizzBuzz that prints the word "FizzBuzz" to the console, and
printNumber that prints a given integer to the console.
You are given an instance of the class FizzBuzz that has four functions: fizz, buzz, fizzbuzz and number. The same instance of FizzBuzz will be passed to four different threads:

Thread A: calls fizz() that should output the word "Fizz".
Thread B: calls buzz() that should output the word "Buzz".
Thread C: calls fizzbuzz() that should output the word "FizzBuzz".
Thread D: calls number() that should only output the integers.
Modify the given class to output the series [1, 2, "Fizz", 4, "Buzz", ...] where the ith token (1-indexed) of the series is:

"FizzBuzz" if i is divisible by 3 and 5,
"Fizz" if i is divisible by 3 and not 5,
"Buzz" if i is divisible by 5 and not 3, or
i if i is not divisible by 3 or 5.
Implement the FizzBuzz class:

FizzBuzz(int n) Initializes the object with the number n that represents the length of the sequence that should be printed.
void fizz(printFizz) Calls printFizz to output "Fizz".
void buzz(printBuzz) Calls printBuzz to output "Buzz".
void fizzbuzz(printFizzBuzz) Calls printFizzBuzz to output "FizzBuzz".
void number(printNumber) Calls printnumber to output the numbers.
 

Example 1:

Input: n = 15
Output: [1,2,"fizz",4,"buzz","fizz",7,8,"fizz","buzz",11,"fizz",13,14,"fizzbuzz"]
Example 2:

Input: n = 5
Output: [1,2,"fizz",4,"buzz"]
 

Constraints:

1 <= n <= 50

```

Basic idea:

这道题在 Golang 里用 channel 来传递信息就很容易做：

Golang 解法如下：

```Golang

package main

import (
	"fmt"
	"sync"
)

type FizzBuzz struct {
	fizzChan     chan int
	buzzChan     chan int
	fizzbuzzChan chan int
	printChan    chan int
	wg           sync.WaitGroup
}

func (fb *FizzBuzz) fizzbuzz() {
	val := <-fb.fizzbuzzChan
	if val%3 == 0 && val%5 == 0 {
		fmt.Println("FizzBuzz")
		fb.wg.Done()
	} else {
		fb.fizzChan <- val
	}
}

func (fb *FizzBuzz) fizz() {
	val := <-fb.fizzChan
	if val%3 == 0 {
		fmt.Println("Fizz")
		fb.wg.Done()
	} else {
		fb.buzzChan <- val
	}
}

func (fb *FizzBuzz) buzz() {
	val := <-fb.buzzChan
	if val%5 == 0 {
		fmt.Println("Buzz")
		fb.wg.Done()
	} else {
		fb.printChan <- val
	}
}

func (fb *FizzBuzz) print() {
	val := <-fb.printChan
	fmt.Println(val)
	fb.wg.Done()
}

func (fb *FizzBuzz) run(val int) {
	fb.wg.Add(1)

	go fb.fizzbuzz()
	go fb.fizz()
	go fb.buzz()
	go fb.print()

    // 这里注意要先启动 go fb.fizzbuzz()... 等一系列函数后再把
    // val 写入到 fizzbuzzChan 里，因为默认空的 channel 是无法写入的，
    // 要有一个 goroutine 在等待读取 <-chan 才可以
	fb.fizzbuzzChan <- val
	fb.wg.Wait()
}

func main() {
	fb := &FizzBuzz{
		fizzChan:     make(chan int),
		buzzChan:     make(chan int),
		fizzbuzzChan: make(chan int),
		printChan:    make(chan int),
	}

	for i := 1; i <= 20; i++ {
		fb.run(i)
	}
}


```