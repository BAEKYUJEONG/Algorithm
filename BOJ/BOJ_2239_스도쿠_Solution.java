import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] rowBits, colBits;
	static int[][] map, xBits;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		rowBits = new int[9];
		colBits = new int[9];
		xBits = new int[3][3];
		map = new int[9][9];
		
		for(int i = 0; i < 9; i++) {
			char[] chars = br.readLine().toCharArray();
			for(int j = 0; j < 9; j++) {
				if(chars[j] == '0') continue;
				int num = chars[j] - '0';
				rowBits[i] = rowBits[i] | (1 << num - 1);
				colBits[j] = colBits[j] | (1 << num - 1);
				xBits[i / 3][j / 3] = xBits[i / 3][j / 3] | (1 << num - 1);
				map[i][j] = num;
			}
		}
		
		dfs(0, 0);
	}
	
	public static void dfs(int row, int col) {
		if(row == 9) {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
			System.out.println(sb.toString());
			System.exit(0);
		}
		if(map[row][col] != 0) {
			if(col != 8) dfs(row, col + 1);
			else dfs(row + 1, 0);
			return;
		}
		
		// 1. 쓸수 있는걸 찾는다.
		ArrayList<Integer> arr = find(row, col);
		
		for(int i = 0; i < arr.size(); i++) {
			int num = arr.get(i);
			map[row][col] = num + 1;
			//비트도 넣었다가 뺀다.
			rowBits[row] = rowBits[row] | (1 << num);
			colBits[col] = colBits[col] | (1 << num);
			xBits[row / 3][col / 3] = xBits[row / 3][col / 3] | (1 << num);
			if(col != 8) dfs(row, col + 1);
			else dfs(row + 1, 0);
			
			map[row][col] = 0;
			rowBits[row] = rowBits[row] & (((1 << 9) - 1) - (1 << num));
			colBits[col] = colBits[col] & (((1 << 9) - 1) - (1 << num));
			xBits[row / 3][col / 3] = xBits[row / 3][col / 3] & (((1 << 9) - 1) - (1 << num));
		}
		
	}
	
	public static ArrayList<Integer> find(int row, int col) {
		ArrayList<Integer> arr = new ArrayList<>();
		int bits = rowBits[row] | colBits[col] | xBits[row / 3][col / 3];
		for(int i = 0; i < 9; i++) {
			if((bits & (1 << i)) > 0) continue;
			arr.add(i);
		}
		return arr;
	}
}
