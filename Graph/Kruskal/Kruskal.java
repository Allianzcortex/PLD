import java.util.Arrays;

/**
 * 实现
 */
public class Kruskal {


    class Edge implements Comparable<Edge> {
        int from, to, value;

        public int compareTo(Edge other) {
            return this.value - other.value;
        }
    }

    class Subset {
        int parent;
        int rank;
    }

    private class Graph {

        int vertexIndex, edgeIndex;
        Edge edge[];

        public Graph(int v, int e) {
            this.vertexIndex = v;
            this.edgeIndex = e;
            this.edge = new Edge[e];

            // 进行初始化
            for (int i = 0; i < e; i++)
                this.edge[i] = new Edge();
        }


        public int findParent(Subset subsets[], int i) {
            // 对所有的首领来说，它们的首领就是自己
            // 要把路径扁平化
            if (subsets[i].parent != i)
                subsets[i].parent = findParent(subsets, subsets[i].parent);
            return subsets[i].parent;
        }

        // 合并两个连通集
        public void union(Subset[] subsets, int x, int y) {
            int xParent = findParent(subsets, x);
            int yParent = findParent(subsets, y);

            if (subsets[xParent].rank < subsets[yParent].rank)
                subsets[xParent].parent = yParent;
            else if (subsets[xParent].rank > subsets[yParent].rank)
                subsets[yParent].parent = yParent;
            else {
                // 随便取值
                subsets[yParent].rank++;
                subsets[xParent].parent = yParent;
            }


        }

        // 计算 Kruskal 算法
        public void calculate() {
            int i;
            Edge[] result = new Edge[vertexIndex];// 存储结果
            for (i = 0; i < vertexIndex; i++)
                result[i] = new Edge();

            // 进行排序
            Arrays.sort(edge);

            Subset subsets[] = new Subset[vertexIndex];
            for (i = 0; i < vertexIndex; i++)
                subsets[i] = new Subset();

            for (int j = 0; j < vertexIndex; j++) {
                subsets[j].parent = j;
                subsets[j].rank = 0;
            }

            i = 0; // 这个索引的作用是在于？？

            int edgeNumber = 0;
            Edge nextEdge;
            while (edgeNumber < vertexIndex - 1) {
                nextEdge = edge[i++];// 选择最小的一个排出来

                int x = findParent(subsets, nextEdge.from);
                int y = findParent(subsets, nextEdge.to);

                // 判断是否会造成循环
                if (x != y) {
                    result[edgeNumber++] = nextEdge;
                    union(subsets, x, y);
                }
            }

            for (i = 0; i < edgeNumber; i++)
                System.out.println(result[i].from + " -----> " + result[i].to +
                        " " + result[i].value);

        }


    }

    public static void main(String[] args) {
        int V = 4;
        int E = 5;
        Kruskal kruskal = new Kruskal();
        Graph graph = new Graph(V, E);

        // 绘制图
        // add edge 0-1
        graph.edge[0].from = 0;
        graph.edge[0].to = 1;
        graph.edge[0].value = 10;

        // add edge 0-2
        graph.edge[1].from = 0;
        graph.edge[1].to = 2;
        graph.edge[1].value = 6;

        // add edge 0-3
        graph.edge[2].from = 0;
        graph.edge[2].to = 3;
        graph.edge[2].value = 5;

        // add edge 1-3
        graph.edge[3].from = 1;
        graph.edge[3].to = 3;
        graph.edge[3].value = 15;

        // add edge 2-3
        graph.edge[4].from = 2;
        graph.edge[4].to = 3;
        graph.edge[4].value = 4;
    }
}
