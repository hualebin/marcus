package algorithm.graph.adjacencylist;

import java.util.LinkedList;

/**
 * 带权有向图-邻接表
 */
public class WeightedDirectedGraph {
    private int n; // 顶点的个数
    private LinkedList<EdgeElement> adj[]; //邻接表

    public WeightedDirectedGraph(int n) {
        this.n = n;
        this.adj = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t, int weight) {
        adj[s].add(new EdgeElement(t, weight));
    }
}
