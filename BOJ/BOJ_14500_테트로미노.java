import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14500_테트로미노 {
	static int N, M, count, sum;
	static int max = 0;
	static int[][] paper;
	static boolean[][] visited;
	static int dx[] = {0,0,-1,1};
	static int dy[] = {-1,1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		paper = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				count = 0;
				sum = 0;
				
				visited[i][j] = true;
				dfs(i,j,count+1,sum+paper[i][j]);
				visited[i][j] = false;
				exception(i,j);
			}
		}
		
		System.out.println(max);
	}

	//백트래킹
	private static void dfs(int i, int j, int count, int sum) {
		if(count == 4) {
			max = Math.max(max, sum);
			return;
		}
		
		for(int k=0; k<4; k++) {
			int nx = i+dx[k];
			int ny = j+dy[k];
			
			if(isValid(nx, ny) && !visited[nx][ny]) {
				visited[nx][ny] = true;
				dfs(nx,ny,count+1,sum+paper[nx][ny]);
				visited[nx][ny] = false;
			}
		}
	}
	
	private static void exception(int i, int j) {
		int wing = 4; // 가운데에서의 상하좌우 날개
		int min = Integer.MAX_VALUE;
		int sum = paper[i][j];
		for (int k = 0; k < 4; k++) {
			int nx = i + dx[k];
			int ny = j + dy[k];

			// 날개가 2개이상 없다면 ㅗ 모양이 아니다. 그러므로 함수를 종료한다.
			if (wing <= 2)
				return;
			// 날개가 맵 바깥에 있는 경우
			if (!isValid(nx, ny)) {
				wing--;
				continue;
			}
			min = Math.min(min, paper[nx][ny]);
			sum = sum + paper[nx][ny];
		}
		// 날개가 4개일때 가장 작은 날개를 없애야 ㅗ,ㅏ,ㅓ,ㅜ 모양이 나온다.
		if (wing == 4) {
			sum = sum - min;
		}
		max = Math.max(max, sum);
	}
	
	public static boolean isValid(int row, int col) {
		if (row < 0 || row >= N || col < 0 || col >= M)
			return false;
		return true;
	}
}