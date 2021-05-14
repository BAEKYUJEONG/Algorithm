import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2638_치즈 {
	static int N, M, time, cheese;
	static int[][] arr;
	static boolean[][] visited;
	static int dx[] = {0,0,-1,1};
	static int dy[] = {-1,1,0,0};
	static Queue<Point> air = new LinkedList<>();
	static Queue<Point> melt = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];
		
		cheese = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==1) cheese++;
			}
		}
		
		time = 0;
		while(cheese!=0) {
			air.add(new Point(0,0));
			bfs();
			visited = new boolean[N][M]; //visited 초기화
			melt();
			time++;
			cheese_count();
		}
		
		System.out.println(time);
	}

	//바깥공기 판별기
	private static void bfs() {
		visited[0][0] = true;
		while(!air.isEmpty()) {			
			Point p = air.poll();
			int r = p.x;
			int c = p.y;
			
			for(int k=0; k<4; k++) {
				int nr = r+dx[k];
				int nc = c+dy[k];
				if(nr>=0 && nr<N && nc>=0 && nc<M && !visited[nr][nc] && arr[nr][nc]!=1) { //범위안 & 방문x & 치즈가 아님
					visited[nr][nc] = true;
					arr[nr][nc]  = 2; //바깥공기
					air.add(new Point(nr, nc));
				}
				
			}
		}
	}
	
	private static void melt() {
		int tmp = 0; //두군데 이상 닿나 보기 위함
		
		//녹일 것 담기
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j]==1) { // 치즈일 때
					for(int k=0; k<4; k++) { 
						int nr = i+dx[k];
						int nc = j+dy[k];
						if(nr>=0 && nr<N && nc>=0 && nc<M && arr[nr][nc]==2) { //범위안 & 바깥공기 닿을 때
							tmp++;
						}
					}
					if(tmp>=2) {
						melt.add(new Point(i,j));
					}
					tmp = 0; //초기화
				}
			}
		}
		
		//녹이기
		while(!melt.isEmpty()) {
			Point p = melt.poll();
			int r = p.x;
			int c = p.y;
			
			arr[r][c] = 2; //바깥공기로 바꾸기
		}
	}
	
	private static void cheese_count() {
		int cnt = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j]==1) cnt++;
			}
		}
		
		cheese = cnt;
	}
}