package algorithm.graph.adjacencymatrix;

/**
 * 带权无向图-邻接矩阵
 */
public class WeightedUnorientedGraph {
    private int n; // 顶点的个数
    private int[][] adj; //邻接矩阵

    public WeightedUnorientedGraph(int n) {
        this.n = n;
        this.adj = new int[n][n];
    }

    public void addEdge(int s, int t, int weight) {
        adj[s][t] = weight;
        adj[t][s] = weight;
    }
}
