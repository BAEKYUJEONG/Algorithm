import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1929_소수구하기 {
	static int M, N;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		M = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N+1];
		
		for(int i=2; i<=N; i++) {
			for(int j=i; j<=N; j++) {
				if(!visited[j] && j%i==0) { // 4%2==0
					if(j!=i) {
						visited[j] = true;
					}
				}
			}
		}
		
		for(int i=M; i<=N; i++) {
			if(!visited[i]) System.out.println(i);
		}
		
	}
}
