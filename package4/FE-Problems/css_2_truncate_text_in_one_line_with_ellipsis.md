
Problem description:

```

Truncate text in one line, if needed add ellipsis.

1.When no overflow

2.when there is need to truncate, add ellipsis


```

Basic idea:

添加代码如下：

```css

.one-line {

  text-overflow:ellipsis;
  overflow:hidden;
  white-space: nowrap;
}

```

// TODO : check why those 3 properties are important