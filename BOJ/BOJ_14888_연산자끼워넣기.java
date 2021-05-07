import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14888_연산자끼워넣기 {
	static int N;
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	static int[] n, arr, operator, op_arr; //숫자 나열, 연산자 수열, 연산자 갯수, 연산자 나열 수열
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		n = new int[N];
		arr = new int[N-1];
		visited = new boolean[N-1];
		operator = new int[4];
		op_arr = new int[N-1];
		
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			n[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}
		
		int tmp = 0;
		for(int i=0; i<4; i++) {
			for(int j=tmp; j<N-1; j++) {				
				while(operator[i]!=0) {
					op_arr[tmp] = i+1; //1 덧셈 2 뺄셈 3 곱셈 4 나누기
					tmp++;
					operator[i]--;
				}
			}
		}
		
		permutation(0);
		
		System.out.println(max);
		System.out.println(min);
	}

	private static void permutation(int depth) {
		if(depth==N-1) {
			cal();
			return;
		}
		
		for(int i=0; i<N-1; i++) {
			if(!visited[i]) {
				arr[depth] = op_arr[i];
				visited[i] = true;
				permutation(depth+1);
				visited[i] = false;
			}
		}
		
	}

	private static void cal() {
		int result = n[0];
		
		for(int i=0; i<N-1; i++) {
			if(arr[i]==1) {
				result += n[i+1];
			}else if(arr[i]==2) {
				result -= n[i+1];
			}else if(arr[i]==3) {
				result *= n[i+1];
			}else {
				result /= n[i+1];
			}
		}
		
		min = Math.min(min, result);
		max = Math.max(max, result);		
	}
}
