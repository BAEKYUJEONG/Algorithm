import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int mapSize;
	static int answer;
	static boolean[][] map;
	static ArrayList<ArrayList<Integer>> canPos;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		mapSize = N * 2 - 1;
		map = new boolean[mapSize][mapSize];
		
		canPos = new ArrayList<>();
		for(int i = 0; i < mapSize; i++) canPos.add(new ArrayList<>());
			
		int center = (mapSize) / 2;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int r = j + i;
				int c = center + j - i;
				map[r][c] = "1".equals(st.nextToken()) ? true : false;
				canPos.get(r).add(c);
			}
		}
		answer = 0;
		
		dfs(0, 0, new boolean[mapSize]);
		System.out.println(answer);
	}
	
	public static void dfs(int row, int cnt, boolean[] visited) {
		if(answer >= cnt + mapSize - row) return;
		
		if(row == mapSize) {
			answer = Math.max(answer, cnt);
			return;
		}
		
		for(int col = 0; col < mapSize; col++) {
			if(map[row][col] && !visited[col]) {
				visited[col] = true;
				dfs(row + 1, cnt + 1, visited);
				visited[col] = false;
			}
		}
		dfs(row + 1, cnt, visited);
	}
}
