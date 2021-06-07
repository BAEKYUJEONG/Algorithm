
public class programmers_네트워크 {
    static boolean[] visited;
    
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                answer++;
                dfs(i, n, computers);
            }
        }
        
        return answer;
    }
    
    public static void dfs(int r, int n, int[][] computers){
        for(int i=0; i<n; i++){
            if(!visited[i] && computers[r][i]==1){
                visited[i] = true;
                
                if(r!=i){
                    dfs(i, n, computers);
                }
            }
        }
    }
    
	public static void main(String[] args) {
		int n = 3;
		int[][] computers = {{1,1,0}, {1,1,0}, {0,1,1}};
		
		System.out.println(solution(n, computers));
	}
}
