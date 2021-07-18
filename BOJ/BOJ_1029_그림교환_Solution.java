import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int[][] pays;
	static int N, answer;
	static int[][][] memo;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		pays = new int[N][N];
		memo = new int[1 << N][10][N];
		
		for(int i = 0; i < N; i++) {
			char[] chars = br.readLine().toCharArray();
			for(int j = 0; j < N; j++) {
				pays[i][j] = chars[j] - '0';
			}
		}
		
		System.out.println(dfs(0, 0, 1, 1 << 0));
	}
	
	public static int dfs(int artist, int value, int buyNum, int visited) {
		int max = buyNum;
		if(memo[visited][value][artist] != 0) max = Math.max(max, memo[visited][value][artist]);
		else {
			for(int i = 1; i < N; i++) {
				if((visited & (1 << i)) > 0 || value > pays[artist][i]) continue;			
				max = Math.max(max, dfs(i, pays[artist][i], buyNum + 1, visited | 1 << i));
			}
			memo[visited][value][artist] = max;
		}
		return max;
	}
}