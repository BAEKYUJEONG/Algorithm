import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<ArrayList<Integer>> arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList<>();
		for(int Ni = 0; Ni < N; Ni++) arr.add(new ArrayList<>());
		
		for(int Mi = 0; Mi < M; Mi++) {
			st = new StringTokenizer(br.readLine());
			int friend1 = Integer.parseInt(st.nextToken());
			int friend2 = Integer.parseInt(st.nextToken());
			arr.get(friend1).add(friend2);
			arr.get(friend2).add(friend1);
		}
		
		for(int friend = 0; friend < N; friend++) {
			boolean[] visited = new boolean[N];
			visited[friend] = true;
			dfs(friend, 1, visited);
		}
		
		System.out.println(0);
	}
	
	public static void dfs(int friend, int cnt, boolean[] visited) {
		if(cnt == 5) {
			System.out.println(1);
			System.exit(0);
		}
		
		for(int nextFriend: arr.get(friend)) {
			if(visited[nextFriend]) continue;
			visited[nextFriend] = true;
			dfs(nextFriend, cnt + 1, visited);
			visited[nextFriend] = false;
		}
	}
}
