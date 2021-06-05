import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206_벽부수고이동하기 {
	static int N, M;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static Queue<Point> queue = new LinkedList<Point>();
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(line.substring(j,j+1));
				if(arr[i][j]==1) visited[i][j] = true;
			}
		}
		
		queue.add(new Point(0,0));
		bfs();
		
	}

	private static void bfs() {
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			int r = p.x;
			int c = p.y;
			
		}
	}
}
