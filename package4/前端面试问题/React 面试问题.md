
1. 首先第一个也是最经典的 React Closure 闭包问题

比如如下的一个 component:

```javascript

import React,{useState} from "react";
import "./style.css";

export default function App() {
  const [count, setCount] = useState(0);

  function handleClickAsync() {
    setTimeout(function delay() {
      setCount(count + 1);
    }, 2000);
  }

  function handleClickSync() {
    
    setCount(count + 1);
  }

  return (
    <div>
      {count}
      <hr/>
      <button onClick={handleClickAsync}>Increase async</button>
      <button onClick={handleClickSync}>Increase sync</button>
    </div>
  )
}

```

可以在任何一个 React Online Editor 中打开




2. React 如何强迫更新