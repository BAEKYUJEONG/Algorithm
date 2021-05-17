import java.util.*;
import java.io.*;

public class BOJ_2573_ºù»ê {
    static int r;
    static int c;
    static int[][] map;
    static int[][] visited;
    static int[][] melt;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new int[r][c];
        visited = new int[r][c];
        melt = new int[r][c];
 
        for(int i=0; i<r; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
 
        solution();
    }
 
    static void solution() {
        int year = 0;
 
        while(true) {
            // dfs ·Î ºù»ê µ¢¾î¸® ¼¼±â
            int count = 0;
            for(int i=0; i<r; i++) {
                for(int j=0; j<c; j++) {
                    if(visited[i][j] == 0 && map[i][j] != 0) {
                        dfs(i, j);
                        count++;
                    }
                }
            }
 
            if(count == 0) {
                System.out.println(0);
                break;
            } else if(count >= 2) {
                System.out.println(year);
                break;
            }
 
            melting();
            year++;
        }
    }
    
    static void dfs(int x, int y) {
        visited[x][y] = 1;
 
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
 
            if(0 <= nx && nx < r && 0 <= ny && ny < c) {
                // 1³â ÈÄ¿¡ ³ì´Â ºù»êÀÇ ¾ç ±¸ÇÏ±â
                if(map[nx][ny] == 0)
                    melt[x][y]++;
 
                // dfs Àç±Í
                if(visited[nx][ny] == 0 && map[nx][ny] != 0)
                    dfs(nx, ny);                    
            }
        }
    }
 
    static void melting() {                
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                map[i][j] -= melt[i][j];
 
                if(map[i][j] < 0)
                    map[i][j] = 0;
                                    
                visited[i][j] = 0;
                melt[i][j] = 0;
            }
        }
    }
}