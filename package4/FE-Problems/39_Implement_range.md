

Below is my javascript solution

The key is to use generator which is a javascript feature

```javascript

/**
 * @param {integer} from
 * @param {integer} to
 */
function range(from, to) {
  // your code here
  function* gen() {
    while(from<=to) {
        yield from;
        from+=1;
    }
  }
  
  return gen();
}

```