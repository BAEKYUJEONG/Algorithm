import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	final static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int N, answer, map[][], memo[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		memo = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		answer = 0;
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(memo[r][c] == 0) dfs(r, c, new Integer(1));
			}
		}
		
		System.out.println(answer);
	}
	
	public static int dfs(int row, int col, Integer cnt) {
		int max = 1;
		for(int[] d: dir) {
			int newRow = row + d[0];
			int newCol = col + d[1];
			
			if(newRow < 0 || newRow >= N ||
			   newCol < 0 || newCol >= N ||
			   map[newRow][newCol] <= map[row][col]) continue;
			
			if(memo[newRow][newCol] != 0) max = Math.max(max, memo[newRow][newCol] + 1);
			else max = Math.max(max, dfs(newRow, newCol, cnt));
		}
		memo[row][col] = max;
		answer = Math.max(answer, max);
		return max + 1;
	}
}