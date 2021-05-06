import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15649_N과M1 {
	static int N,M;
	static int[] arr;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		visited = new boolean[N];
		
		combination(0);
	}

	private static void combination(int depth) {
		if(depth==M) {
			print();
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr[depth] = i+1;
				combination(depth+1);
				visited[i] = false;
			}
		}
	}

	private static void print() {
		for(int i=0; i<M; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}