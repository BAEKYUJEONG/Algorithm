import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//내부공기와 바깥공기를 구분하는 것에 헷갈렸는데, bfs나 dfs나 더이상 조건에 만족하지 않으면 (겉에서 치즈를 만나는 순간) 짤이 되기 때문에 생각할 필요 없었다.
//이중 for문으로 하고 if문을 두면 불가능하지만 bfs나 dfs로는 가능하다.

public class BOJ_2636_치즈 {
	static int r,c,time,last;
	static int[][] arr;
	static boolean[][] visited;
	static Queue<Point> air_q;
	static Queue<Point> melt_q;
	static boolean flag = true;
	static int dx[] = {0,0,-1,1};
	static int dy[] = {-1,1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new int[r][c];
		visited = new boolean[r][c];
		air_q = new LinkedList<>();
		melt_q = new LinkedList<>();
		time = 0;
		last = 0;
		
		for(int i=0; i<r; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<c; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(flag){
			air_bfs();
			melt();
			/*
			for(int i=0; i<r; i++) {
				for(int j=0; j<c; j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
			System.out.println();
			*/
		}
		
		System.out.println(time);
		System.out.println(last);
		
	}

	private static void air_bfs() {
		visited = new boolean[r][c];
		
		if(air_q.isEmpty()) {
			air_q.add(new Point(0,0)); // 아무것도 없으므로 첫 포인트를 넣어준다.
			visited[0][0] = true;
		}
		
		while(!air_q.isEmpty()) {
			Point nq = air_q.poll();
			int r = nq.x;
			int c = nq.y;
			visited[r][c] = true;
			
			for(int k=0; k<4; k++) {
				int nr = r+dx[k];
				int nc = c+dy[k];
				if(inRange(nr,nc) && arr[nr][nc]!=1 && visited[nr][nc]!=true) { //범위 안 & 치즈가 아님 & 방문 x
					visited[nr][nc] = true;
					arr[nr][nc] = 2; // 바깥 공기
					air_q.add(new Point(nr,nc));
				}
			}
		}
	}


	private static void melt() {
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(arr[i][j]==1) { // 치즈일 때
					for(int k=0; k<4; k++) {
						int nr = i+dx[k];
						int nc = j+dy[k];
						if(inRange(nr,nc) && arr[nr][nc]==2 && visited[i][j]!=true) { // 범위안 & 바깥 공기 닿음 & 방문 x
							visited[i][j] = true;
							melt_q.add(new Point(i,j)); //녹일 치즈 넣기
						}
					}
				}
			}
		}
		
		if(melt_q.isEmpty()) {
			flag = false;
			return;
		}

		time++;
		last = melt_q.size(); // 마지막으로 녹이는 치즈 갯수 저장
		
		while(!melt_q.isEmpty()) {
			Point melt_cheese = melt_q.poll();
			int mr = melt_cheese.x;
			int mc = melt_cheese.y;
			arr[mr][mc] = 2; // 치즈를 바깥공기로 바꿔주기 -> 녹임
		}
		
		
	}
	
	private static boolean inRange(int nr, int nc) {
		if(nr>=0 && nc>=0 && nr<r && nc<c) {
			return true;
		}
		return false;
	}
}
