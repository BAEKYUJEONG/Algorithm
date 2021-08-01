import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	final static int[][] dir = { { -1, 0 }, { -1, -1 }, { 0, -1 }, { 1, -1 }, { 1, 0 }, { 1, 1 }, { 0, 1 }, { -1, 1 } };
	static int answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[][][] map = new int[4][4][2];
		int[][] fishPos = new int[16][2];
		
		for(int r = 0; r < 4; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < 4; c++) {
				int num = Integer.parseInt(st.nextToken()) - 1;
				int d = Integer.parseInt(st.nextToken()) - 1;
				map[r][c] = new int[] { num, d };
				fishPos[num] = new int[] { r, c };
			}
		}
		answer = 0;
		int[] shark = new int[] { 0, 0, 0 };
		dfs(map, fishPos, shark, 0);
		System.out.println(answer);
	}
	
	public static void dfs(int[][][] map, int[][] fishPos, int[] shark, int sum) {
		int sharkR = shark[0];
		int sharkC = shark[1];
		
		int[][][] newMap = new int[4][4][];
		for(int r = 0; r < 4; r++) {
			for(int c = 0; c < 4; c++) {
				newMap[r][c] = map[r][c].clone();
			}
		}
		
		int[][] newFishPos = new int[16][];
		for(int i = 0; i < 16; i++) newFishPos[i] = fishPos[i].clone();
		
		sum += map[sharkR][sharkC][0] + 1;
		int sharkD = eatFish(sharkR, sharkC, newMap, newFishPos);
		fishMove(newMap, newFishPos, sharkR, sharkC);
		
		int newRow = sharkR;
		int newCol = sharkC;
		int newDir = sharkD;
		
		while(true) {
			newRow += dir[sharkD][0]; 
			newCol += dir[sharkD][1]; 
			if(newRow < 0 || newRow >= 4 || 
			   newCol < 0 || newCol >= 4) break;
			if(newMap[newRow][newCol][0] == -1) continue;
			dfs(newMap, newFishPos, new int[] { newRow, newCol, newDir }, sum);
		}
		answer = Math.max(answer, sum);
	}
	
	public static int eatFish(int row, int col, int[][][] map, int[][] fishPos) {
		fishPos[map[row][col][0]][0] = -1;
		map[row][col][0] = -1;
		
		return map[row][col][1];
	}
	
	public static void showFishes(int[][][] map) {
		for(int row = 0; row < 4; row++) {
			System.out.println();
			for(int col = 0; col < 4; col++) {
				System.out.print("[" + (map[row][col][0] + 1) + "," + (map[row][col][1] + 1) +"]");
			}
		}
		System.out.println();
	}
	
	public static void fishMove(int[][][] map, int[][] fishPos, int sharkR, int sharkC) {
		for(int fi = 0; fi < 16; fi++) {
			if(fishPos[fi][0] == -1) continue;
			int row = fishPos[fi][0];
			int col = fishPos[fi][1];
			int fishDir = map[row][col][1];
			
			for(int d = 0; d < 8; d++) {
				int newDir = (fishDir + d) % 8;
				int newRow = row + dir[newDir][0];
				int newCol = col + dir[newDir][1];
				if(newRow < 0 || newRow >= 4 || 
				   newCol < 0 || newCol >= 4 ||
				   (newRow == sharkR && newCol == sharkC)) continue;
				map[row][col][1] = newDir;
				posSwap(row, col, newRow, newCol, map, fishPos);
				mapSwap(row, col, newRow, newCol, map);
				
				break;
			}
		}
	}
	
	public static void mapSwap(int r1, int c1, int r2, int c2, int[][][] map) {
		int[] temp = map[r1][c1];
		map[r1][c1] = map[r2][c2];
		map[r2][c2] = temp;
	}
	
	public static void posSwap(int r1, int c1, int r2, int c2, int[][][] map, int[][] fishPos) {
		int[] temp = fishPos[map[r1][c1][0]];
		if(map[r2][c2][0] != -1) {
			fishPos[map[r1][c1][0]] = fishPos[map[r2][c2][0]];
			fishPos[map[r2][c2][0]] = temp;
		} else {
			fishPos[map[r1][c1][0]][0] = r2;
			fishPos[map[r1][c1][0]][1] = c2;
		}
	}
}
