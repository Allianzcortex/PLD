
Problem description:

```
Currying is a useful technique used in JavaScript applications.

Please implement a curry() function, which accepts a function and return a curried one.

Here is an example

const join = (a, b, c) => {
   return `${a}_${b}_${c}`
}

const curriedJoin = curry(join)

curriedJoin(1, 2, 3) // '1_2_3'

curriedJoin(1)(2, 3) // '1_2_3'

curriedJoin(1, 2)(3) // '1_2_3'
more to read

https://javascript.info/currying-partials

https://lodash.com/docs/4.17.15#curry

```

Basic idea:

这道题要求实现柯里化。首先柯里化的定义参考如下：
https://zh.javascript.info/currying-partials

也就是一个函数 func(a,b,c) 允许以 func(a)(b)(c) 的方法来调用，有点类似链式操作

实现代码如下：

整体逻辑不算难，需要注意的是剩余参数 rest parameters https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Functions/Rest_parameters

`...args` 表示不确定数量的参数，在这个函数里 `args` 表示一个 array。

其中 fn.length 表示的是函数的参数的数量。

如果我们发现 `args.length>=fn.length` 那么说明函数可以跑这些参数，直接调 fn(...args) 就可以
如果不够的话，就要把当前的 `args` 参数和之后传进来的 `extra` 参数合并

```javascript

function curry(fn) {
  console.log(fn.length)
  return function curryInner(...args) {
    if (args.length>=fn.length) {
      return fn(...args);
    }
    return function(...extra) {
      return curryInner(...args,...extra);
    }
  }
}

```