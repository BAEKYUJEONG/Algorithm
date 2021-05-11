import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//알파벳이 겹치면 어차피 가지 못하기 때문에 visited를 칸별로 관리할 필요 없음!
//알파벳이 같은지 아닌지로 visited 관리만 해도 된다.
public class BOJ_1987_알파벳 {
	static int R,C, answer, distance;
	static char[][] arr;
	static boolean[] visited_alphabet;
	static int dx[] = {0,0,-1,1};
	static int dy[] = {-1,1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		answer = 1;
		distance = 1;
		
		arr = new char[R][C];
		visited_alphabet = new boolean[26];
		
		//입력에 주의
		for(int i=0; i<R; i++) {
			arr[i] = br.readLine().toCharArray();
			for(int j=0; j<C; j++) {
				arr[i][j] = (char)(arr[i][j]-'A');
			}
		}
		
		/*
		for(int i=0; i<R; i++) {
			char[] line = br.readLine().toCharArray();
			for(int j=0; j<C; j++) {
				arr[i][j] = (char)(line[j]-'A');
			}
		}
		*/
		
		dfs(0,0);
		System.out.println(answer);
	}

	private static void dfs(int i, int j) {
		int idx = arr[i][j];
		visited_alphabet[idx] = true;
		
		for(int k=0; k<4; k++) {
			int nr = i+dx[k];
			int nc = j+dy[k];
			if(nr>=0 && nr<R && nc>=0 && nc<C) { //범위 안 & 방문x & 방문한 문자가 아니라면
				int next = arr[nr][nc];
				
				if(!visited_alphabet[next]) {					
					distance++;
					answer = Math.max(answer, distance);
					dfs(nr,nc);
				}
			}
		}
		
		//백트래킹
		visited_alphabet[idx] = false;
		distance--;
	}
}