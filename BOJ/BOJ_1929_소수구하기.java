import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1929_소수구하기 {
	static int M, N;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N+1];
		visited[1] = true;
		
		for(int i=2; i<=N; i++) {
			for(int j=2; i*j<=N; j++) { // 범위 중요 : i*j<=N
				visited[i*j] = true;
			}
		}
		
		for(int i=M; i<=N; i++) {
			if(!visited[i]) System.out.println(i);
		}
		
	}
}
