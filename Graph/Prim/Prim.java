package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 实现 prim 算法，MST
 * 这里直接用 ArrayList 来模拟已访问路径和未访问路径
 * 还可以用数组实现更好的模拟
 */
public class Prim {

    private static final int vertex = 5;
    private HashMap<Character, Integer> dict;
    private HashMap<String, Integer> map;

    Prim() {
        this.map = new HashMap<String, Integer>();
    }

    public int findMinDistance(ArrayList<Integer> visited, ArrayList<Integer> unvisited, int[][] distance) {
        int Min = Integer.MAX_VALUE;
        int index = -1;
//        for (int i = 0; i < visited.size(); i++) {
//            int target = visited[i];
//
//        }
        int temp = -1;
        for (Integer target : visited) {

            // 
            for (int i = 0; i < distance[target - 1].length; i++) {
                if (distance[target - 1][i] != -1 && !visited.contains(i + 1) && distance[target - 1][i] < Min) {
                    Min = distance[target - 1][i];
                    index = i + 1;
                    temp = target;
                }
            }
        }
        map.put(temp + "->" + index, Min);
        System.out.println(index);
        return index;
    }

    public void calculate(int[][] graph) {
        ArrayList<Integer> visited = new ArrayList<Integer>();
        ArrayList<Integer> unvisited = new ArrayList<Integer>();
//        unvisited.add("a");
//        unvisited.add("b");
//        unvisited.add("c");
//        unvisited.add("d");
//        unvisited.add("e");
        unvisited.add(1);
        unvisited.add(2);
        unvisited.add(3);
        unvisited.add(4);
        unvisited.add(5);

        int i = 0;
        int target = unvisited.get(i);
        unvisited.remove(new Integer(target));
        visited.add(target);
        System.out.println(visited);
        System.out.println(unvisited);
        while (!unvisited.isEmpty()) {
            int result = findMinDistance(visited, unvisited, graph);
            System.out.println("result is " + result);
            unvisited.remove(new Integer(result));
            visited.add(result);
            System.out.println("---");
            System.out.println("unvisited is " + unvisited);
            System.out.println("visited is " + visited);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }


    public static void main(String[] args) {
        /* Let us create the following graph
           2    3
        (0)--(1)--(2)
        |    / \   |
        6| 8/   \5 |7
        | /      \ |
        (3)-------(4)
             9          */
        Prim prim = new Prim();
        // 本身为 0，不可达为 -1
        int[][] graph = new int[][]{
                {0, 2, -1, 6, -1},
                {2, 0, 3, 8, 5},
                {-1, 3, 0, -1, 7},
                {6, 8, -1, 0, 9},
                {-1, 5, 7, 9, 0},
        };

        prim.calculate(graph);
        /*
        1->4 6
        2->5 5
        1->2 2
        2->3 3
         */

    }
}

