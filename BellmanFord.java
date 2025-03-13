import java.util.Arrays;

public class BellmanFord{
    public static void main(String[] args) {
        int V = 3; // Number of vertices
        int[][] edges = {
            {0, 1, 1},  // Edge from vertex 0 to 1 with weight 1
            {1, 2, -1}, // Edge from vertex 1 to 2 with weight -1
            {2, 0, -1}  // Edge from vertex 2 to 0 with weight -1
        };

        int src = 0;
        int[] ans = bellmanFord(V, edges, src);
        for (int dist : ans) 
            System.out.print(dist + " ");
    }

    public static int[] bellmanFord(int V, int edges[][], int src){
        int[] dist = new int[V];
        Arrays.fill(dist, (int)1e8);
        dist[src] = 0;
        
        for(int i = 0; i < V; i++){
            for(int[] edge: edges){
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];
                if(dist[u] != 1e8 && dist[u] + wt < dist[v]){
                    if (i == V - 1){
                        return new int[]{-1};
                    }
                    dist[v] = dist[u] + wt;
                }
            }
        }
        return dist;
    }
}