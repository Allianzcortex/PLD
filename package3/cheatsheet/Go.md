
Golang 的常见技巧：

1. Golang 中 WaitGroup 作为参数在函数中传递时，一定要用指针的形式，否则
object will be copied and `Done()` is not visible in main function

`func downloadFromURL(url string, wg sync.WaitGroup) error {}` 
应该被定义为
`func downloadFromURL(url string, wg &sync.WaitGroup) error`

2. 有一个 string，要转为 `rune[]`，方法为：`arr:=[]rune(str)`
要把 `rune[]` 转为 `string`，方法为：`str = string(arr)`

3. 关于 byte 和 rune 的区别：

byte 是字符， uint8 的 alias，可以用如下方法创建：`b := byte('a')`
rune 是 unicode，int32 的 alias

如果用 `str[index]` 的方法 retrieve 的值是 `byte`，如果用 
`for k,v := range s` 的方法 retrieve 的 v 是 `rune`，具体区别如下：

```Golang

s := "hello"

for index, val := range s {
	fmt.Println(reflect.TypeOf(val))      // int32,rune
	fmt.Println(reflect.TypeOf(s[index])) // uint8,byte
}

```

4. Python 里 str 和 int 之间的互相转换可以直接用 `str()` 和 `int()`
而 Go 里则要相应使用 `strconv.Atoi()` 以及 `strconv.Itoa()`

5. 在用 make 创建 slice 时，必须要指定 length，比如下面的语句是错的
`res := make([]string)` ，而应该用 `res:=make([]string,0)`

这个时候更好的一种方法是直接用 var 定义 `var res []string`

6. Golang 里如何创建 2d array :

```Golang

dp:=make([][]bool,length+1)

for i:=0;i<=length;i++ {
    dp[i] = make([]bool,target+1)
}

```