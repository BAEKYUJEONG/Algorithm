import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15686_치킨배달 {
	static int N, M, answer;
	static int[][] arr;
	static boolean[][] visited;
	static ArrayList<Point> chicken;
	static ArrayList<Point> home;
	static boolean[] visited_open;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][N];
		visited = new boolean[N][N];
		chicken = new ArrayList<>();
		home = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==2) chicken.add(new Point(i,j));
				if(arr[i][j]==1) home.add(new Point(i,j));
			}
		}
		
		//치킨집 갯수만큼 오픈할 가게 지정
		visited_open = new boolean[chicken.size()];
		answer = Integer.MAX_VALUE;
		
		combination(0,0);
		System.out.println(answer);
		
	}
	
	//백트래킹 : 조건이 있는 dfs
	//r = 조합의 길이(조합해서 뽑을 갯수), cnt
	private static void combination(int start, int r) { 
		if(r == M) {
			int result = 0;
			
			for(int i=0; i<home.size(); i++) {
				int tmp = Integer.MAX_VALUE;
				
				//최소거리 구하기
				for(int j=0; j<chicken.size(); j++) {
					if(visited_open[j]) { //가게가 열었다면
						int distance = getDistance(home.get(i), chicken.get(j));
						//연 가게 중에서 가장 거리가 짧은 거리
						tmp = Math.min(tmp, distance);
					}
				}
				//한 조합마다의 최소 거리 더한 모음
				result += tmp;
			}
			//전체 조합 중에서 최소 거리
			answer = Math.min(answer, result);
			return;
		}
		
		//백트래킹
		//1,2,3,4가 있다면
		//1,2를  true로 뽑고 난 뒤
		//2를 뽑은 부분에서 false로 빠져나와
		//1을 들고 있는 상태에서 3을 true로 해 1,3을 뽑는 형식으로 for문의 순서가 진행된다.
		for(int i=start; i<chicken.size(); i++) {
			visited_open[i] = true;
			combination(i+1, r+1);
			visited_open[i] = false;
		}
	}
	
	private static int getDistance(Point p1, Point p2) {
		return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
	}

}
