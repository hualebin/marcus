package algorithm.graph.adjacencylist;

import java.util.LinkedList;

/**
 * 带权无向图-邻接表
 */
public class WeightedUnorientedGraph {
    private int n; // 顶点的个数
    private LinkedList<EdgeElement> adj[]; //邻接表

    public WeightedUnorientedGraph(int n) {
        this.n = n;
        this.adj = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t, int weight) {
        adj[s].add(new EdgeElement(t, weight));
        adj[t].add(new EdgeElement(s, weight));
    }
}
