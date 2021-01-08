package algorithm.graph.adjacencymatrix;

/**
 * 无向图-邻接矩阵
 */
public class UnorientedGraph {
    private int n; // 顶点的个数
    private int[][] adj; //邻接矩阵

    public UnorientedGraph(int n) {
        this.n = n;
        this.adj = new int[n][n];
    }

    public void addEdge(int s, int t) {
        adj[s][t] = 1;
        adj[t][s] = 1;
    }
}
