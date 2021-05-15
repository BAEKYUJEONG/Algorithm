import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502_楷备家 {
	static int N, M;
	static int max = Integer.MIN_VALUE;
	static int[][] arr;
	static boolean[][] visited;
	static int dx[] = {0,0,-1,1};
	static int dy[] = {-1,1,0,0};
	static Queue<Point> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==1) visited[i][j] = true; // 寒 贸府
				if(arr[i][j]==2) { // 官捞矾胶 贸府
					q.add(new Point(i,j));
					visited[i][j] = true;
				}
			}
		}
		
		combination(0,0);
		
		System.out.println(max);
	}

	private static void combination(int depth, int start) {
		if(depth == 3) {
			bfs();
			count();
			return;
		}
		
		for(int i=start; i<N*M; i++) {
			int x = start/N;
			int y = start%N;
			
			if(!visited[x][y]) {
				visited[x][y] = true;
				combination(depth+1, start+1);
				visited[x][y] = false;
			}
		}
	}

	private static void bfs() {
		while(!q.isEmpty()) {
			Point p = q.poll();
			int r = p.x;
			int c = p.y;
			
			for(int k=0; k<4; k++) {
				int nr = r+dx[k];
				int nc = c+dy[k];
				
				if(nr>=0 && nr<N && nc>=0 && nc<M && !visited[nr][nc]) {
					visited[nr][nc] = true;
					q.add(new Point(nr,nc));
				}
			}
		}
	}
	
	private static void count() {
		int count = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(!visited[i][j]) count++;
			}
		}
		
		max = Math.max(max, count);
	}
}
