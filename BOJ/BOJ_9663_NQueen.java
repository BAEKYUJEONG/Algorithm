import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//처음에는 두개의 hashSet을 만들어서 하나는 좌표값을 오름차순으로 모아서 하나의 케이스를 만들고
//하나는 그 케이스들을 다시 오름차순으로 줄세워서 넣어두면 겹치는 경우의 수 없이 찾을 수 있겠다고 생각하였다.
//너무 어려워 힌트를 참고하고 다시 생각나는 데로 천천히 풀어보았다.
public class BOJ_9663_NQueen {
	static int N, count;
	static int[] board;
	//맵을 그냥 단순히 열끼리가 숫자가  안겹쳐야하는 1차원 배열이라고 생각해도 된다!!
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		board = new int[N];
		
		count = 0;
		
		dfs(0);
		
		System.out.println(count);
	}

	private static void dfs(int col) {
		if(col==N) { //마지막 남은 행의 열을 채웠다면, 그래서 col(depth)가 N이 되었다면
			count++;
			return;
		}
		
		//행들을 무작위로 정하기
		for(int i=0; i<N; i++) {
			if(col==0) {
				board[col] = i;
				dfs(col+1);
			}else {
				if(isPossible(i,col)) {
					board[col] = i;
					dfs(col+1);
				}
			}
		}
	}

	private static boolean isPossible(int row, int col) {
		//같은 행에 있을 때
		for(int i=0; i<col; i++) {
			if(board[i]==board[col]) {
				return false;
			}
		}
		
		//대각선에 있을 때
		//i가 순서대로인 열, board[i]의 항목이 행
		for(int i=0; i<col; i++) {
			if(Math.abs(i-col)==Math.abs(board[i]-row)) {
				return false;
			}
		}
		
		return true;
	}
}
