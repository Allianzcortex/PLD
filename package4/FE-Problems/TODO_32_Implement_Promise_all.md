
This problem is pretty hard , it requires that you should have a very deep
understanding about `Promise`.

Solution 1 :

change the definition of function

```
async function all(promises) {
  const results = [];

  for (let promise of promises) {
    results.push(await promise);
  }

  return results;
}
```

---

Solution 2 :

not sure how I can finish it tho

```

function all(promises) {
  return new Promise((resolve, reject) => {
    const result = [];

    if (promises.length === 0) {
      resolve(result);
      return;
    }

    let countPending = promises.length;

    promises.forEach((promise, index) => {
      Promise.resolve(promise).then((value) => {
        result[index] = value;
        countPending--;
        if (countPending === 0) {
          resolve(result);
        }
      }, reject);
    });

  });
}

```