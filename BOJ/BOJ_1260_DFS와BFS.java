import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited_dfs, visited_bfs;
    static int N, M, V;
    static int[][] map;
    static Queue<Integer> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[r-1][c-1] = map[c-1][r-1] = 1;
        }

        visited_dfs = new boolean[N];
        visited_bfs = new boolean[N];

        visited_dfs[V-1] = true;
        System.out.print(V+" ");
        dfs(N-1, V-1);

        System.out.println();

        q.add(V-1);
        visited_bfs[V-1] = true;
        bfs(N);
	}

    public static void dfs(int n, int x) {
        for (int i=0; i<N; i++) {
            if (map[x][i] == 1 && !visited_dfs[i]) {
                visited_dfs[i] = true;
                n--;

                if(n != 0) {
                    System.out.print((i+1)+" ");
                } else {
                    System.out.print(i+1);
                }

                dfs(n, i);
            }
        }
    }

    public static void bfs(int n) {
        while (!q.isEmpty()) {
            int x = q.poll();

            n--;
            
            if (n != 0) {
                System.out.print((x+1)+" ");
            } else {
                System.out.print((x+1));
            }

            for (int i=0; i<N; i++) {
                if (map[x][i] == 1 && !visited_bfs[i]) {
                    q.add(i);
                    visited_bfs[i] = true;
                }
            }
        }
    }
}