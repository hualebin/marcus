package algorithm.graph.adjacencylist;

import java.util.LinkedList;
import java.util.Queue;

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

    public void bfs(int s, int t) {
        if (s == t) {
            return;
        }

        boolean[] visited = new boolean[n];
        visited[s] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);

        int[] prev = new int[n];
        for (int i = 0; i < n; i++) {
            prev[i] = -1;
        }
        while(queue.size() > 0) {
            int w = queue.poll();
            for (int i = 0; i < adj[w].size(); i++) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    prev[q] = w;
                    if (q == t) {
                        // 打印
                        print(prev, s, t);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }

            }
        }
    }

    public void print(int[] prev, int s, int t) {
        if (prev[t] != -1 && s != t) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }
}
