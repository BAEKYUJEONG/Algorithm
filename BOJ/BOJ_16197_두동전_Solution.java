import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	final static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[R][C];
		boolean[][][][] visited = new boolean[R][C][R][C];
		int[][] coinPos = new int[2][];
		int cnt = 0;
		
		for(int r = 0; r < R; r++) {
			char[] chars = br.readLine().toCharArray();
			for(int c = 0; c < C; c++) {
				map[r][c] = chars[c];
				if(map[r][c] == 'o') coinPos[cnt++] = new int[] { r, c };
			}
		}
		
		Queue<int[][]> q = new LinkedList<>();
		q.add(coinPos);
		int r1 = coinPos[0][0];
		int c1 = coinPos[0][1];
		int r2 = coinPos[1][0];
		int c2 = coinPos[1][1];
		
		visited[r1][c1][r2][c2] = true;
		visited[r2][c2][r1][c1] = true;
		
		int answer = 0;
		
		loop:
		while(!q.isEmpty()) {
			int qSize = q.size();
			if(++answer > 10) break;
			
			for(int qi = 0; qi < qSize; qi++) {
				int[][] coins = q.poll();
				dirloop:
				for(int[] d: dir) {
					int fall = 0;
					int[][] newCoins = new int[2][];
					int count = 0;
					
					for(int i = 0; i < 2; i++) {
						int[] coin = coins[i];
						int newRow = coin[0] + d[0];
						int newCol = coin[1] + d[1];
						
						if(newRow < 0 || newRow >= R || 
						   newCol < 0 || newCol >= C) {
							++fall;
							continue;
						}
						
						if(map[newRow][newCol] == '#') {
							if(count == 1 && newCoins[0][0] == coin[0] && newCoins[0][1] == coin[1]) continue dirloop;
							newCoins[count++] = new int[] { coin[0], coin[1] };
						}
						else {
							if(count == 1 && newCoins[0][0] == newRow && newCoins[0][1] == newCol) continue dirloop;
							newCoins[count++] = new int[] { newRow, newCol };
						}
					}
					
					if(fall == 1) {
						System.out.println(answer);
						return;
					}
					else if(fall == 2) continue;
					
					if(visited[newCoins[0][0]][newCoins[0][1]][newCoins[1][0]][newCoins[1][1]] ||
					   visited[newCoins[1][0]][newCoins[1][1]][newCoins[0][0]][newCoins[0][1]]) continue; 
					visited[newCoins[0][0]][newCoins[0][1]][newCoins[1][0]][newCoins[1][1]] = true;
					visited[newCoins[1][0]][newCoins[1][1]][newCoins[0][0]][newCoins[0][1]] = true;
					
					q.add(newCoins);
				}
			}
		}
		System.out.println(-1);
	}
}
