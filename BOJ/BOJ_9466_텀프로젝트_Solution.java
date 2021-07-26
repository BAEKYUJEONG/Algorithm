import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int[] teamChoice;
	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int Ti = 0; Ti < T; Ti++) {
			n = Integer.parseInt(br.readLine());
			teamChoice = new int[n + 1];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= n; i++) {
				teamChoice[i] = Integer.parseInt(st.nextToken());
			}
			int successCnt = 0;
			int[] visited = new int[n + 1];
			for(int i = 1; i <= n; i++) {
				int choice = i;
				int cnt = 1;
				if(visited[choice] != 0) continue;
				Set<Integer> set = new HashSet<>();
				while(true) {
					if(visited[choice] != 0) {
						if(set.contains(choice)) successCnt += cnt - visited[choice];
						break;
					}
					visited[choice] = cnt++;
					set.add(choice);
					choice = teamChoice[choice];
				}
			}
			sb.append(n - successCnt).append("\n");
		}
		System.out.println(sb.toString());
	}
}