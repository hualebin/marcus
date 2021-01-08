package algorithm.graph.adjacencylist;

import java.util.LinkedList;

/**
 * 有向图-邻接表
 */
public class DirectedGraph {
    private int n; // 顶点的个数
    private LinkedList<Integer> adj[]; //邻接表

    public DirectedGraph(int n) {
        this.n = n;
        this.adj = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) {
        adj[s].add(t);
    }
}
