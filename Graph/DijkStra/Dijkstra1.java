package Test;

/**
 * Created by hzcortex on 17-1-18.
 */

/**
 * Dijkstra 算法的实现包括实现有向边，有向图
 */

public class DirectedEdge {
    private int from;
    private int to;
    private double weight;

    public DirectedEdge(int from, int to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    private int getFrom() {
        return from;
    }

    private int getTo() {
        return to;
    }

    private double getWeight() {
        return weight;
    }

}

public class DirectedGraph {
    private int V; //


}

