
Problem description:

```

Throttling is a common technique used in Web Application, in most cases using lodash solution would be a good choice.

could you implement your own version of basic throttle()?

In case you forgot, throttle(func, delay) will return a throttled function, which will invoke the func at a max frequency no matter how throttled one is called.

Here is an example.

Before throttling we have a series of calling like

─A─B─C─ ─D─ ─ ─ ─ ─ ─ E─ ─F─G

After throttling at wait time of 3 dashes

─A─ ─ ─C─ ─ ─D ─ ─ ─ ─ E─ ─ ─G

Be aware that

call A is triggered right way because not in waiting time
function call B is swallowed because B, C is in the cooling time from A, and C is latter.
notes

please follow above spec. the behavior is not exactly the same as lodash.throttle()

```

Basic idea:

这道题是要实现 `throttle` 限流函数，也就是在固定的时间范围内只运行一次函数

`The func is invoked with the last arguments provided to the throttled function. Subsequent calls to the throttled function return the result of the last func invocation.`


Javascript 实现如下：

```javascript

function throttle(func, wait) {
  // your code here
  let waiting = false;
  let lastargs = null;

  return function(...args) {
    if (!waiting) {
      waiting = true;
      func.apply(this,args);

      setTimeout(()=>{
        waiting = false;
        if(lastargs!==null) {
          func.apply(this, lastargs);
        }
        args = null;
      },wait)
    } else {
      lastargs = args;
    }
  }

}

```