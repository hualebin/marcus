package algorithm.graph.adjacencylist;

import java.util.LinkedList;

/**
 * 无向图-邻接表
 */
public class UnorientedGraph {
    private int n; // 顶点的个数
    private LinkedList<Integer> adj[]; //邻接表

    public UnorientedGraph(int n) {
        this.n = n;
        this.adj = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) {
        adj[s].add(t);
        adj[t].add(s);
    }
}
