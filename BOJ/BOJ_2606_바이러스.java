import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_2606_바이러스 {
	static int computer, connect, answer;
	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		computer = Integer.parseInt(br.readLine());
		connect = Integer.parseInt(br.readLine());
		graph = new ArrayList<ArrayList<Integer>>();
		visited = new boolean[computer+1];
		
		for(int i=0;i<computer+1; i++) graph.add(new ArrayList<>());
			
		for(int i=0;i<connect; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int com1, com2;
			com1 = Integer.parseInt(st.nextToken());
			com2 = Integer.parseInt(st.nextToken());
			
			graph.get(com1).add(com2);
			graph.get(com2).add(com1);
		}
		
		answer = 0;
		
		visited[1] = true;
		dfs(1);
		
		System.out.println(answer);
	}

	private static void dfs(int start) {
		for(int i=0; i<graph.get(start).size(); i++) {
			int tmp = graph.get(start).get(i);
			
			if(visited[tmp]==false) {
				visited[tmp] = true;
				answer++;
				dfs(tmp);
			}
		}
	}
}