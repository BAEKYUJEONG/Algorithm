import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
    static int w, h, answer;
    static boolean flag = true;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0, 1, 1, -1, -1};
    static int[] dy = {0, -1, 0, 1, -1, 1, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
        while (flag) {
            st = new StringTokenizer(br.readLine());

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w==0 && h==0) {
                flag = false;
                break;
            }

            map = new int[h][w];
            visited = new boolean[h][w];
            answer = 0;

            // 입력
            for (int i=0; i<h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j=0; j<w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());

                    if (map[i][j] == 0) { // 바다라면
                        visited[i][j] = true;
                    }
                }
            }

            // 방문 안한 섬이라면 탐색 시작
            for (int i=0; i<h; i++) {
                for (int j=0; j<w; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        ++answer;
                    }
                }
            }

            System.out.println(answer);
        }
	}

	public static void dfs(int r, int c) {
        for (int k=0; k<8; k++) {
            int nr = r+dx[k];
            int nc = c+dy[k];

            if (nr>=0 && nc>=0 && nr<h && nc<w && map[nr][nc]==1 && !visited[nr][nc]) {
                visited[nr][nc] = true;
                dfs(nr, nc);
            }
        }
    }
}