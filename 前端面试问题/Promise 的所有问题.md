
目标：

搞明白 javascript 的 `Promise` 到底是如何实现
以及各种奇奇怪怪的顺序问题

Promise 所说的异步执行，只是将 Promise 构造函数中 resolve，reject 方法和注册的 callback 转化为 eventLoop的 microtask/Promise Job，并放到 Event Loop 队列中等待执行，也就是 Javascript 单线程中的“异步执行”。



Promise 的中的同步与异步
new Promise((resolve) => {
  console.log('a')
  resolve('b')
  console.log('c')
}).then((data) => {
  console.log(data)
})

// a, c, b
使用过 Promise 的人都知道输出 a, c, b，但有多少人可以清楚地说出从创建 Promise 对象到执行完回调的过程？下面是一个完整的解释：

构造函数中的输出执行是同步的，输出 a, 执行 resolve 函数，将 Promise 对象状态置为 resolved，输出 c。同时注册这个 Promise 对象的回调 then 函数。整个脚本执行完，stack 清空。event loop 检查到 stack 为空，再检查 microtask 队列中是否有任务，发现了 Promise 对象的 then 回调函数产生的 microtask，推入 stack，执行。输出 b，event loop的列队为空，stack 为空，脚本执行完毕。