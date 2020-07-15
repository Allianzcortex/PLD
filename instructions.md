### bweever
**Algorithm Implement Library**

---

#### 项目起源

项目来源于某一天的一个脑洞：-D，思考是否可以用 Python 类里的 `__doc__` 来实现更加友好的提示，比如定义一个如下类：

```
class AlgorithmImplementation(object):

    @staticmethod
    def _get_doc():
        doc_cn = """some chinese illustration"""
        doc_en = """some english illustration"""
        help_doc = {'cn': doc_cn, 'en': doc_en}
        return help_doc

    def __doc__(self):
        return AlgorithmImplementation._get_doc().get('en')

    def __call__(self):
         """ now execute the real sort """ 

```

用 `__call__` 方法来调用实际的函数。同时避免用 `__doc__` 这样的方法来让用户查看提示，实现如下的一些帮助函数：

```
def help_cn(problem):
    return problem._get_doc().get('en')


def help_en(problem):
    return problem._get_doc().get('cn')
```

那么我们就可以使用这样的方法：

```
>>> from bweever import SomeAlgorithm,help_cn,help_en
>>> help_cn(SomeAlgorithm) # 查看中文解释
>>> help_en(SomeAlgorithm) # see explanation of Algorithm with en
>>> SomeAlgorithm(input)   # 执行函数

```

---

#### 目前进展

如果有时间的话还是挺想实现以前的想法的o(╯□╰)o，但目前可以完全把 bweever 当做一个算法集合库来看待，在其中实现了常用的 `字符串、图、树、链表` 等数据结构，以及 `DFS、BFS、DP、KMP` 等算法。

实现语言包括 `Java` 与 `Python`，一部分包含了 `Scala` 的实现。

---

**列表集合**

| 目录  | 内容 |
| ------------- | ------------- |
| **Others**   | [BigInteger](/Others/BigInteger)|
|              | [NQueuens](/Others/NQueuens)|
|              | [ReversePolishNotation](/Others/ReversePolishNotation)|
|              | [MinStack](/Others/MinStack)|
|**KMP**| [KMP](/KMP) |
|**LinkedList**| [KMP](/LinkedList) |
|**Graph**|[基本算法](/Graph/BasicGraph)|
|         |[Dijkstra](/Graph/Dijkstra)|
|         |[Prim](/Graph/Prim)|
|         |[Kruskal](/Graph/Kruskal)|
|**SortAndSearch**|[SortAndSearch](/SortAndSearch)|
|**Tree**|[基本树算法](/Tree/BaseTree)|
|        |[AVLTree](/Tree/AVLTree)|
|        |[RBTree](/Tree/RBTree)|
|        |[Trie](/Tree/Trie)|
|**DP**|[DP(LIS/LCS)](/DP)|
|**Design Pattern**|[单例模式-SingleTon](/design-patterns/单例模式-singleton)|
|                  |[状态模式-StatePattern](/design-patterns/状态模式-StatePattern)|
|                  |[装饰器模式-Decorators](/design-patterns/装饰器模式-decorators)|









