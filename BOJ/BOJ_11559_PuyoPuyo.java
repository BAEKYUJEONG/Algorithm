import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_11559_PuyoPuyo {
	static char[][] field = new char[12][6];
	static char[][] compare_field = new char[12][6];
	static boolean[][] visited = new boolean[12][6];
	static boolean[][] if_visited = new boolean[12][6];
	static Queue<Point> q = new LinkedList<>();
	static Queue<Point> if_q = new LinkedList<>();
	static boolean flag = true;
	static int pang = 0;
	static int dx[] = {0,0,-1,1};
	static int dy[] = {-1,1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<12; i++) {
			char[] line = br.readLine().toCharArray();
			for(int j=0; j<6; j++) {
				field[i][j] = line[j];
			}
		}
		
		for(int i=0; i<12; i++) {
			for(int j=0; j<6; j++) {
				if(field[i][j]=='.') compare_field[i][j] = 'd';
			}
		}
		
		down();
		pang--;
		
		while(true) {
			if_visited = new boolean[12][6];
			visited = new boolean[12][6];
			compare_field = new char[12][6];
			puyo();
			if(!flag) break;
			down();
		}
		
		System.out.println(pang);
	}

	private static void puyo() {
		int empty = 0; //전체에서 지워질 뿌요가 없는지 확인할 변수
		
		for(int i=0; i<12; i++) {
			for(int j=0; j<6; j++) {
				if(field[i][j]!='.') {
					int tmp = 0; //4개이상 확인할 변수
					
					if_q.add(new Point(i,j));
					if_visited[i][j] = true;
					tmp++;
					
					while(!if_q.isEmpty()) {
						Point p = if_q.poll();
						int r = p.x;
						int c = p.y;
						
						for(int k=0; k<4; k++) {
							int nr = r+dx[k];
							int nc = c+dy[k];
							
							if(nr>=0 && nr<12 && nc>=0 && nc<6 && if_visited[nr][nc]!=true && field[r][c]==field[nr][nc]) {
								if_q.add(new Point(nr,nc));
								if_visited[nr][nc] = true;
								tmp++;
							}
						}
					}
					
					if(tmp>=4) {
						q.add(new Point(i,j));
						visited[i][j] = true;
						compare_field[i][j] = 'd';
						empty++;
						
						while(!q.isEmpty()) {
							Point p = q.poll();
							int r = p.x;
							int c = p.y;
							
							for(int k=0; k<4; k++) {
								int nr = r+dx[k];
								int nc = c+dy[k];
								
								if(nr>=0 && nr<12 && nc>=0 && nc<6 && visited[nr][nc]!=true && field[r][c]==field[nr][nc]) {
									q.add(new Point(nr,nc));
									visited[nr][nc] = true;
									compare_field[nr][nc] = 'd';
								}
							}
						}
					}
					
					tmp = 0;
				}
			}
		}
		
		if(empty==0) {
			flag = false;
			return;
		}
		
		empty = 0;
	}

	private static void down() {
		for(int i=0; i<12; i++) {
			for(int j=0; j<6; j++) {
				if(compare_field[i][j]=='d') {
					for(int k=i; k>=1; k--) {						
						field[k][j] = field[k-1][j];
					}
					field[0][j] = '.';
				}
			}
		}
		
		pang++;
	}
}