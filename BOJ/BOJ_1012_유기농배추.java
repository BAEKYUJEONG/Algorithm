import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1012_유기농배추 {
	static int r, c;
	static int[][] field;
	static boolean[][] visited;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static Queue<Point> q = new LinkedList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int worm = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			int point = Integer.parseInt(st.nextToken());
			
			field = new int[r][c];
			visited = new boolean[r][c];
			
			for(int p=0; p<point; p++) {
				st = new StringTokenizer(br.readLine());
				int i = Integer.parseInt(st.nextToken());
				int j = Integer.parseInt(st.nextToken());
				field[i][j] = 1;
			}
			
			for(int i=0; i<r; i++) {
				for(int j=0; j<c; j++) {
					if(field[i][j]==0) visited[i][j] = true;
				}
			}
			
			for(int i=0; i<r; i++) {
				for(int j=0; j<c; j++) {
					if(visited[i][j]==false) {
						bfs(i, j);
						worm++;
					}
				}
			}
			
			System.out.println(worm);
		}
	}
	
	private static void bfs(int i, int j) {
		visited[i][j] = true;
		q.add(new Point(i, j));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			int pr = p.x;
			int pc = p.y;
			
			for(int k=0; k<4; k++) {
				int nr = pr+dx[k];
				int nc = pc+dy[k];
				
				if(nr>=0 && nc>=0 && nr<r && nc<c && !visited[nr][nc]) {
					q.add(new Point(nr, nc));
					visited[nr][nc] = true;
				}
			}
		}
	}
}
