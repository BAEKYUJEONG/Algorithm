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
	static Queue<Place> queue = new LinkedList<Place>();
	static int answer = Integer.MAX_VALUE;
	
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
		
		queue.add(new Place(0,0,1,0));
		visited[0][0] = true;
		
		bfs();
		
		if(answer == Integer.MAX_VALUE) answer = -1;
		
		System.out.println(answer);
	}

	private static void bfs() {
		while(!queue.isEmpty()) {
			
			Place p = queue.poll();
			int r = p.r;
			int c = p.c;
			int distance = p.distance;
			int wall = p.wall;
			
			if(r==N-1 && c==M-1) {
				answer = Math.min(distance, answer);
			}
			
			for(int i=0; i<4; i++) {
				int nr = r+dx[i];
				int nc = c+dy[i];
				
				if(nr>=0 && nr<N && nc>=0 && nc<M) {
					if(!visited[nr][nc]) {
						queue.add(new Place(nr, nc, distance+1, wall));
						visited[nr][nc] = true;
					}else if(wall==0) {
						queue.add(new Place(nr, nc, distance+1, wall+1));
						visited[nr][nc] = true;
					}
				}
			}
		}
	}
	
	static class Place {
		int r;
		int c;
		int distance;
		int wall;
		
		public Place(int r, int c, int distance, int wall) {
			this.r = r;
			this.c = c;
			this.distance = distance;
			this.wall = wall;
		}
	}
}
