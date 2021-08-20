import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_13023_ABCDE {
	static int N, M;
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		HashSet<Integer> person = new HashSet<>();
		boolean[][] friend = new boolean[N][N];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			friend[a][b] = true;
			friend[b][a] = true;
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(friend[i][j] == true) {
					person.add(i);
					person.add(j);
					
					dfs1(i, 0, person, friend);
					dfs2(j, 0, person, friend);
					break;
				}
			}
		}
		
		System.out.println(answer);
	}
	
	private static void dfs1(int r, int depth, HashSet person, boolean[][] friend) {
		for(int i=0; i<N; i++) {
			if(friend[r][i] == true) {
				friend[r][i] = false;
				friend[i][r] = false;
				
				person.add(i);
				
				if(person.size()>=5 && depth+1>=4) {
					answer = 1;
					break;
				}
				
				dfs1(i, depth+1, person, friend);
			}
		}
	}
	
	private static void dfs2(int c, int depth, HashSet person, boolean[][] friend) {
		for(int i=0; i<N; i++) {			
			if(friend[i][c] == true) {
				friend[i][c] = false;
				friend[c][i] = false;
				
				person.add(i);
				
				if(person.size()>=5 && depth+1>=4) {
					answer = 1;
					break;
				}
				
				dfs2(i, depth+1, person, friend);
			}
		}
	}
}
