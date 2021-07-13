import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14499_주사위굴리기 {
	static int N, M, x, y, K;
	static int[][] map;
	static int left = 0, right = 0, up = 0, down = 0, top = 0, bottom = 0;
	static Dice dice;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M ;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		dice = new Dice();
		
		for(int i=0; i<K ;i++) {
			int c = Integer.parseInt(st.nextToken());
			command(c);
		}
		
	}

	private static void command(int dir) {
		if(dir==1) dice.rightRoll();
		else if(dir==2) dice.leftRoll();
		else if(dir==3) dice.upRoll();
		else dice.downRoll();
	}
	
	static class Dice{
		void setBottom() {
			if(map[x][y]!=0) {
				bottom = map[x][y];
				map[x][y] = 0;
			}
			else map[x][y] = bottom;
		}
		
		void leftRoll(){
			y = y-1;
			
			if(inRange()) {
				int tmp = top;
				top = right;
				right = bottom;
				bottom = left;
				left = tmp;
				
				setBottom();
				System.out.println(top);
			}else {
				y = y+1;
			}
		}
		
		void rightRoll() {
			y = y+1;
			
			if(inRange()) {
				int tmp = top;
				top = left;
				left = bottom;
				bottom = right;
				right = tmp;
				
				setBottom();
				System.out.println(top);
			}else {
				y = y-1;
			}
		}
		
		void downRoll() {
			x = x+1;
			
			if(inRange()) {
				int tmp = top;
				top = up;
				up = bottom;
				bottom = down;
				down = tmp;
				
				setBottom();
				System.out.println(top);
			}else {
				x = x-1;
			}
		}
		
		void upRoll() {
			x = x-1;
			
			if(inRange()) {
				int tmp = top;
				top = down;
				down = bottom;
				bottom = up;
				up = tmp;
				
				setBottom();
				System.out.println(top);
			}else {
				x = x+1;
			}
		}
	}
	
	private static boolean inRange() {
		boolean flag = true;
		
		if(x>=0 && x<N && y>=0 && y<M) {
			flag = true;
		}else {
			flag = false;
		}
		
		return flag;
	}
}
