
Problem description:

```

There are two kinds of threads: oxygen and hydrogen. Your goal is to group these threads to form water molecules.

There is a barrier where each thread has to wait until a complete molecule can be formed. Hydrogen and oxygen threads will be given releaseHydrogen and releaseOxygen methods respectively, which will allow them to pass the barrier. These threads should pass the barrier in groups of three, and they must immediately bond with each other to form a water molecule. You must guarantee that all the threads from one molecule bond before any other threads from the next molecule do.

In other words:

If an oxygen thread arrives at the barrier when no hydrogen threads are present, it must wait for two hydrogen threads.
If a hydrogen thread arrives at the barrier when no other threads are present, it must wait for an oxygen thread and another hydrogen thread.
We do not have to worry about matching the threads up explicitly; the threads do not necessarily know which other threads they are paired up with. The key is that threads pass the barriers in complete sets; thus, if we examine the sequence of threads that bind and divide them into groups of three, each group should contain one oxygen and two hydrogen threads.

Write synchronization code for oxygen and hydrogen molecules that enforces these constraints.

 

Example 1:

Input: water = "HOH"
Output: "HHO"
Explanation: "HOH" and "OHH" are also valid answers.
Example 2:

Input: water = "OOHHHH"
Output: "HHOHHO"
Explanation: "HOHHHO", "OHHHHO", "HHOHOH", "HOHHOH", "OHHHOH", "HHOOHH", "HOHOHH" and "OHHOHH" are also valid answers.
 

Constraints:

3 * n == water.length
1 <= n <= 20
water[i] is either 'H' or 'O'.
There will be exactly 2 * n 'H' in water.
There will be exactly n 'O' in water.

```

Basic idea:

这道题用 Golang 也是很经典的用 `WaitGroup` 和 `channel` 结合起来完成解法
注意对 `WaitGroup` 要用 pointer，而 `mu` 默认就是一个实例，初始化的时候不
用声明也可以

自己的实现如下：

```Golang

package main

import (
	"fmt"
	"math/rand"
	"sync"
)

type H2O struct {
	h1ch chan struct{}
	h2ch chan struct{}
	och  chan struct{}
	wg   *sync.WaitGroup
	mu   sync.Mutex
}

func NewH2O() *H2O {
	var wg sync.WaitGroup
	h := &H2O{
		h1ch: make(chan struct{}, 1),
		h2ch: make(chan struct{}, 1),
		och:  make(chan struct{}, 1),
		wg:   &wg,
	}
	return h
}

func (h2o *H2O) Hydrogen(releaseHydrogen func()) {
	defer h2o.wg.Done()
	select {
	case <-h2o.h1ch:
		defer func() { h2o.h2ch <- struct{}{} }()
		h2o.mu.Lock()
		releaseHydrogen()
		fmt.Printf("%d", 1)
		h2o.mu.Unlock()
	case <-h2o.h2ch:
		defer func() { h2o.h1ch <- struct{}{} }()
		h2o.mu.Lock()
		releaseHydrogen()
		fmt.Printf("%d", 2)
		h2o.mu.Unlock()
	}
}

func (h2o *H2O) Oxygen(releaseOxygen func()) {
	// releaseOxygen.run() outputs "O". Do not change or remove this line.
	defer h2o.wg.Done()
	releaseOxygen()
}

func (h2o *H2O) run() {
	h2o.wg.Add(3)

	randNum := rand.Intn(2)
	if randNum == 0 {
		h2o.h1ch <- struct{}{}
	} else {
		h2o.h2ch <- struct{}{}
	}

	releaseHydrogen := func() { fmt.Printf("H") }
	releaseOxygen := func() { fmt.Printf("O") }

	go h2o.Hydrogen(releaseHydrogen)
	go h2o.Hydrogen(releaseHydrogen)
	go h2o.Oxygen(releaseOxygen)

	h2o.wg.Wait()
	select {
	case <-h2o.h1ch:
		break
	case <-h2o.h2ch:
		break
	}

}

func main() {
	// rand.Seed(time.Now().Unix())
	h2o := NewH2O()
	for i := 0; i < 20; i++ {
		h2o.run()
		fmt.Println()
	}
}


```