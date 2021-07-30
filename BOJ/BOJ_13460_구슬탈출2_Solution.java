import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	final static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int[] parents;
	static boolean[][] map;
	static int endRow, endCol;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		map = new boolean[R][C];
		int redRow = 0, redCol = 0;
		int blueRow = 0, blueCol = 0;
		for(int r = 0; r < R; r++) {
			char[] chars = br.readLine().toCharArray();
			for(int c = 0; c < C; c++) {
				if(chars[c] == '#') {
					map[r][c] = true;
					continue;
				} else if(chars[c] == 'R') {
					redRow = r;
					redCol = c;
				} else if(chars[c] == 'B') {
					blueRow = r;
					blueCol = c;
				} else if(chars[c] == 'O') {
					endRow = r;
					endCol = c;
				}
			}
		}
		
		// 0, 1 red 2, 3 blue
		boolean[][][][] visited = new boolean[R][C][R][C];
		visited[redRow][redCol][blueRow][blueCol] = true;
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { redRow, redCol, blueRow, blueCol });
		
		int answer = -1;
		int cnt = 0;
		loop:
		while(!q.isEmpty()) {
			++cnt;
			int qsize = q.size();
			for(int qi = 0; qi < qsize; qi++) {
				int[] rb = q.poll();
				int rRow = rb[0];
				int rCol = rb[1];
				int bRow = rb[2];
				int bCol = rb[3];
				
				for(int d = 0; d < 4; d++) {
					int[] newBluePos = getEndPos(bRow, bCol, d);
					if(newBluePos == null) continue;
					int[] newRedPos = getEndPos(rRow, rCol, d);
					if(newRedPos == null) {
						answer = cnt;
						break loop;
					}
					int nrRow = newRedPos[0];
					int nrCol = newRedPos[1];
					int nbRow = newBluePos[0];
					int nbCol = newBluePos[1];
					if(nrRow == nbRow && nrCol == nbCol) {
						if(d == 0) { // À§·Î ±¼·¯°¬À» ¶§ °ãÃÆ´Ù¸é
							if(rRow > bRow) nrRow -= dir[0][0];
							else nbRow -= dir[0][0];
						} else if(d == 2) {
							if(rRow > bRow) nbRow -= dir[2][0];
							else nrRow -= dir[2][0];
						} else if(d == 1) {
							if(rCol > bCol) nbCol -= dir[1][1];
							else nrCol -= dir[1][1];
						} else {
							if(rCol > bCol) nrCol -= dir[3][1];
							else nbCol -= dir[3][1];
						}
					}
					if(visited[nrRow][nrCol][nbRow][nbCol]) continue;
					visited[nrRow][nrCol][nbRow][nbCol] = true;
					q.add(new int[] { nrRow, nrCol, nbRow, nbCol });
				}
			}
			if(cnt == 10) break;
		}
		System.out.println(answer);
	}
	
	public static int[] getEndPos(int r, int c, int d) {
		int[] direction = dir[d];
		while(true) {
			r += direction[0];
			c += direction[1];
			if(map[r][c]) break;
			if(r == endRow && c == endCol) return null;
		}
		return new int[] { r - direction[0], c - direction[1] };
	}
}