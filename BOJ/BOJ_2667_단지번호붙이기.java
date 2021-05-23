import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2667_단지번호붙이기 {
	static int N;
	static int arr[][];
	static boolean visited[][];
	static int dx[] = {0,0,-1,1};
	static int dy[] = {-1,1,0,0};
	static int apt;
	static int aptSize[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		visited = new boolean[N][N];
		apt = 0;
		aptSize = new int[N*N];
		
		//입력에 주의
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				arr[i][j] = str.charAt(j)-'0';
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j]==1 && !visited[i][j]) {
					apt++; //아파트 단지 갯수
					dfs(i,j);
				}
			}
		}
		
		Arrays.sort(aptSize);
		
		System.out.println(apt);
		for(int i=0; i<aptSize.length; i++) {
			if(aptSize[i]==0) continue;
			System.out.println(aptSize[i]);
		}
		
	}

	private static void dfs(int i, int j) {
		visited[i][j] = true;
		aptSize[apt]++; // 단지 하나의 사이즈
		
		for(int k=0; k<4; k++) {
			int nx = dx[k] + i;
			int ny = dy[k] + j;
			if(nx>=0 && nx<N && ny>=0 && ny<N && !visited[nx][ny] && arr[nx][ny]==1) { //nx, ny가 범위 안 & !visited & 단지일때
				dfs(nx,ny);
			}
		}
	}
}
