import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14503_로봇청소기 {
	static int N,M;
	static int r,c,d;
	static int arr[][];
	static int visited[][];
	static boolean flag = true;
	static int dx[] = {-1,0,1,0};
	static int dy[] = {0,1,0,-1};
	
	static int clean = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		//0 위
		//1 오
		//2 아래
		//3 왼
		
		arr = new int[N][M];
		visited = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==1) visited[i][j] = 2; // 벽 처리
			}
		}
		
		//1. 현재 위치를 청소한다.
		visited[r][c] = 1;
		clean++;
		
		cleanup();
		
		System.out.println(clean);
		
	}

	private static void cleanup() {
		while(flag) {
			int tmp = 0; // 모든 방향을 확인할 변수
			
			for(int k=3; k>=0; k--) {
				int nr = r+dx[k];
				int nc = c+dy[k];
				if(visited[nr][nc]!=0) {
					tmp++;
				}
			}
			
			//모든 방향이 청소가 되어있거나 벽이면
			if(tmp==4) {
				int behind = (d+2)%4;
				
				int br = r+dx[behind];
				int bc = c+dy[behind];
				
				if(visited[br][bc]==2) { //뒤가 벽이라 후진을 할 수 없다면
					flag = false;
				} else { //아니라면 후진
					r = br;
					c = bc;
				}
			}
			
			//2. 현재 위치 기준 왼쪽부터 청소
			for(int k=1; k<=4; k++) {
				int left = (d-k+4)%4; //현재 기준 왼쪽
				
				int lr = r+dx[left];
				int lc = c+dy[left];
				
				if(visited[lr][lc]==0) {
					visited[lr][lc] = 1;
					clean++;
					r = lr;
					c = lc;
					d = left;
					cleanup();
				}
			}
		}
	}
}
