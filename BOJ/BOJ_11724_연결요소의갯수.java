import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] graph;
    static boolean[] visited;

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][N];
        visited = new boolean[N];
        int count = 0;

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u-1][v-1] = graph[v-1][u-1] = 1;
        }

        for (int i=0; i<N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i);
                count++;
            }
        }

        System.out.println(count);
	}

    public static void dfs(int i) {
        for (int j=0; j<N; j++) {
            if (graph[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(j);
            }
        }
    }
}