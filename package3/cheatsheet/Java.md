
Java 的常见技巧：

面 Circle 要求必须熟悉 

1. 注意句子后面一定要带分号 `;`

2. 如何把一个 `int` 值转化为 `char`:

使用：`(char) (cnt+'0')` 可以把 `1` 转化为 `'1'`

3. 对一个 `ArrayList` 用 `list.indexOf()` 来获得
value 第一次出现的坐标。如果这个 value 不存在的话返回 -1.

4. 定义一个二维 list ，方法如下：

`List<List<Integer>> res = new ArrayList<>();`

然后在参数时也用同样的方法来定义：

`func(List<List<Integer>> res)`

5. java 如何定义一个二维数组：

`int[][] array = new int[10][20];`

6. java 如何复制一个 Array:

`List<Integer> newArray = new ArrayList<>(oldArray);`

7. Java 如何定义一个 HashMap:

`Map<Integer,Integer> map = new HashMap<>()`

对应的 HashMap 如何插入新值：
`map.put(1,'a');`

8. Java 中 List<> 对 aray 的转换：

这在 LC 中更是常见情况：

`res.toArray(new int[0][0]);`

9. Java 中在使用 `for(int i=0;i<k;i++)` 时经常会出现的一个错误：

比如定义下面的函数

```Java

public void test(int i) {
        int j=2;
        for(int j=2;j<3;j++) {
            
        }
        for(int i=0;i<4;i++) {
            System.out.println(i);
        }
    }

```

其中 i 作为参数传入，j 是在函数一开始时定义的，那么在后面的两个循环里尝试用
`for(int ....)` 来重新定义两个变量的方法都是不可行的，会提示 variable already
defined.

同时注意两点：

a. 对如下的代码片段：

```Java

int i= 2;
        for(;i<4;i++) {
            System.out.println(i);
        }
        System.out.println(i); // res is 4.
```

`i` 是最终会被更新为 `4` 的。

b. 但可以在 `for` 循环里这样定义，下面的 2 个 `i` 在 2 个不同的循环里，不冲突

```java

for(int i=2;i<3;i++) {
}

for(int i=2;i<3;i++) {
}

```

10. Java 里：

对 array，取得长度用 `arr.length`
对 string，取得长度用 `str.length()`
对集合如 list，取得长度用 `lst.size()`

11. Python 里 BFS 时用的双端队列是 `deque`，弹出时用的是 `popleft()`
对应的 Java 数据结构则是：

`Queue<Integer> queue = new LinkedList<>()`

要加入一个新值：`queue.add(val)`
要根据 FILO 弹出一个新值：`queue.poll()`

12. set/list 里判断某个 key 是否存在都用 `sth.contains()`
而 map 里判断某个 key/value 是否存在则用 `sth.containsKey()` 

13. 注意在 Java 的 `''` 和 `""` 是不一样的，也就是 char 和 string 是不一样的。
在 Python 里二者可以随意呼唤，但 Java 需要区分对待，比如：
`str.split(",")` 是对的，但 `str.split(',')` 就不对，会提示 character 的问题

