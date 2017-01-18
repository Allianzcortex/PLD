package Test;

/*
测试图类
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Iterator;

public class Graph {
    private int value;
    private LinkedList<Integer> adj[];

    // 构造函数
    Graph(int newValue) {
        value = newValue;
        adj = new LinkedList[value];
        for (int i = 0; i < value; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }


    // 下面进行 DFS 的遍历
    public void DFS1(int v) {
        boolean visited[] = new boolean[v]; // 这里的 V
        traverse(visited, v);
    }

    public void traverse(boolean visited[], int v) {
        visited[v] = true;
        System.out.println("DFS v " + v);

        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n]) {
                traverse(visited, n);
            }
        }
    }


    public void DFS2(int v) {
        Stack<Integer> s = new Stack<Integer>();
        s.push(v);
        boolean[] visited = new boolean[value];  // default boolean is false
        while (!s.isEmpty()) {
            v = s.pop();
            visited[v] = true;
            System.out.println("访问 " + v);
            for (int i = 0; i < adj[v].size(); i++) {
                if (!visited[adj[v].get(i)])
                    s.push(adj[v].get(i));

            }
        }
    }

    /**
     * 用 FIFO Queue 来模拟 BFS
     *
     * @param v 开始运行的节点
     */
    public void BFS2(int v) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(v);
        boolean[] visited = new boolean[value];
        while (!q.isEmpty()) {
            v = q.poll();
            System.out.println("正在访问 " + v);
            visited[v] = true;
            for (int i = 0; i < adj[v].size(); i++) {
                if (!visited[adj[v].get(i)])
                    q.add(adj[v].get(i));
            }
        }
    }

//    /**
//     * dijkstra 算法实现
//     *
//     * @param v 开始遍历的节点
//     */
//    public void dijkstra(int v) {
//
//    }
//
//    /**
//     * kruscal 算法实现
//     *
//     * @param v 开始遍历的节点
//     */
//    public void kruscal(int v) {
//
//    }
//
//    /**
//     * prim 算法实现
//     *
//     * @param v 开始遍历的节点
//     */
//    public void prim(int v) {
//
//    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        // 使用递归来模拟 DFS
        graph.DFS1(2);  // 还没有检验正确性

        // 使用堆栈来模拟 DFS
        graph.DFS2(2);  // 2->3->0->1

        // 使用队列来模拟 BFS
        graph.BFS2(2);  // 2->0->3->1
    }

}
