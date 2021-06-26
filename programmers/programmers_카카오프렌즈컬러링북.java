class Solution {
    static boolean visited[][];
    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {-1, 1, 0, 0};
    static int area_num;
    static int size;
    static int max_size;
    
    public int[] solution(int m, int n, int[][] picture) {
        area_num = 0;
        size = 1;
        max_size = 0;
        visited = new boolean[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(picture[i][j]==0) visited[i][j] = true;
            }
        }
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j]){
                    visited[i][j] = true;
                    size = 1;
                    max_size = Math.max(size, max_size);
                    dfs(m, n, i, j, picture);
                    area_num++;
                }
            }
        }
        
        int[] answer = new int[2];
        answer[0] = area_num;
        answer[1] = max_size;
        
        return answer;
    }
    
    static void dfs(int m, int n, int i, int j, int[][] picture){
        for(int k=0; k<4; k++){
            int nr = i+dx[k];
            int nc = j+dy[k];
                    
            if(nr>=0 && nc>=0 && nr<m && nc<n && !visited[nr][nc] && picture[nr][nc]==picture[i][j]){
                visited[nr][nc] = true;
                size++;
                max_size = Math.max(max_size, size);
                dfs(m, n, nr, nc, picture);
            }
        }
    }
}

//1 1 1 0
//1 2 2 0
//1 0 0 1
//0 0 0 1
//0 0 0 3
//0 0 0 3