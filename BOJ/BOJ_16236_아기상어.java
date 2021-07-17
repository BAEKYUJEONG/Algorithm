import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16236_아기상어 {
	static int N, eat, shark_size;
	static int[][] map;
	static boolean[][] visited;
	static int[] shark;
	static ArrayList<Point> fish;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		eat = 0;
		shark_size = 2;
		shark = new int[2];
		fish = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] != 0) {
					if(map[i][j] == 9) {
						map[i][j] = 0; // 자신을 장애물로 방해하지 않게 0으로 바꿔준다.
						shark[0] = i;
						shark[1] = j;
					}else {
						if(map[i][j] > 2) visited[i][j] = true;
						fish.add(new Point(i, j));
					}
				}
			}
		}
		
		System.out.println(babyShark());
	}

	private static int babyShark() {
		int sec = 0;
		int small = 0;
		int min_dis = Integer.MAX_VALUE;
		int min_idx = -1;
		int min_sharkx = 0;
		int min_sharky = 0;
		int index = -1;
		
		while(!fish.isEmpty()) {
			for(Point f : fish) {
				index++;
				
				if(shark_size > map[f.x][f.y]) { // 물고기 사이즈가 작다면
					int m = move(f.x, f.y);
					if(m != -1) { // 길을 갈 수 있다면
						small++;
						if(m < min_dis) { // 가장 거리가 가깝다면 (포인트를 담는 순서상 위 왼쪽부터 담아서 괜찮을 듯)
							min_dis = m;
							min_idx = index;
							min_sharkx = f.x;
							min_sharky = f.y;
						}
					}
				}
			}
			
			// 변수에 저장했다가 가장 작은 지점을 샤크로 바꿔준다.
			shark[0] = min_sharkx;
			shark[1] = min_sharky;
			
			if(small == 0) return sec; // 물고기는 있지만 나보다 작은 물고기가 없다면
			else {
				fish.remove(min_idx);
				sec += min_dis;
				eat++;
				small = 0;
				min_dis = Integer.MAX_VALUE;
				min_idx = -1;
				index = -1;
			}
			
			// 몸을 키워야하면
			if(shark_size == eat) {
				eat = 0;
				shark_size++;
				visited = new boolean[N][N];
				
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						if(map[i][j] > shark_size) visited[i][j] = true;
					}
				}
			}
		}
		
		return sec;
	}

	private static int move(int x, int y) {
		Queue<movePoint> q = new LinkedList<>();
		boolean[][] visited_move = new boolean[N][N];
		int[] dx = {0, -1, 0, 1};
		int[] dy = {-1, 0, 1, 0};
		
		q.add(new movePoint(shark[0], shark[1], 0));
		
		while(!q.isEmpty()) {
			movePoint p = q.poll();
			int r = p.x;
			int c = p.y;
			int dis = p.distance;
			
			for(int k=0; k<4; k++) {
				int nr = r+dx[k];
				int nc = c+dy[k];
				int ndis = dis+1;
				
				if(nr>=0 && nc>=0 && nr<N && nc<N && !visited[nr][nc] && !visited_move[nr][nc]) {
					q.add(new movePoint(nr, nc, ndis));
					visited_move[nr][nc] = true;
					
					if(nr==x && nc==y) return ndis;
				}
			}
		}
		
		return -1;
	}
	
	static class movePoint{
		int x;
		int y;
		int distance;
		
		public movePoint(int x, int y, int distance) {
			this.x = x;
			this.y = y;
			this.distance = distance;
		}
	}
}
