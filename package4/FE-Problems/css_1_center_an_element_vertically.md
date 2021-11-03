
Problem description:

```

This is a very basic question and good to be the first CSS problem on BFE.dev.

Suppose you have an HTML structure as below

<div class="outer">
  <div class="inner">
</div>
Please center the inner div vertically without changing their dimensions and colors.

1.Should be centered vertically

2.even if container size changes


```

这是给的模板：

```css

.outer {
  width: 100%;
  height: 100%;
  background-color: #efefef;
  /* add your code here */
}

.inner {
  width: 100px;
  height: 100px;
  background-color: #f44336;
}

```

这是解法，基本思路是给父元素添加一个 `display:flex`，然后设置 `justify-content` 和 `align-items` :

```css

.outer {
  width: 100%;
  height: 100%;
  background-color: #efefef;
  display: flex;
  align-items: center;
  justify-content: center;
}

.inner {
  width: 100px;
  height: 100px;
  background-color: #f44336;
}

```