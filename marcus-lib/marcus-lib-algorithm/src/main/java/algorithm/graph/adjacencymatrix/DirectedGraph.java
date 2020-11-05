package algorithm.graph.adjacencymatrix;

/**
 * 有向图-邻接矩阵
 */
public class DirectedGraph {
    private int n; // 顶点的个数
    private int[][] adj; //邻接矩阵

    public DirectedGraph(int n) {
        this.n = n;
        this.adj = new int[n][n];
    }

    public void addEdge(int s, int t) {
        adj[s][t] = 1;
    }
}
