import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15654_N과M5 {
	static int N, M;
	static int[] arr, answer;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		answer = new int[M];
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		permutation(0);
	}

	private static void permutation(int depth) {
		if(depth==M) {
			print();
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				answer[depth] = arr[i];
				visited[i] = true;
				permutation(depth+1);
				visited[i] = false;
			}
		}
	}

	private static void print() {
		for(int i=0; i<M; i++) {
			System.out.print(answer[i]+" ");
		}
		System.out.println();
	}
}
