import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.awt.Point;

public class Main {
	static int N, M;
	static int[][] maze;
    static int[][] maze_length;
	static boolean[][] visited;
	static int dx[] = {-1,0,1,0};
	static int dy[] = {0,-1,0,1};
    static Queue<Point> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new int[N][M];
        maze_length = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				maze[i][j] = str.charAt(j)-'0';
                maze_length[i][j] = Integer.MAX_VALUE;
				
				if(maze[i][j]==0) { // 이동할 수 없는 칸일 때 
					visited[i][j] = true;
				}
			}
		}
        
        q.add(new Point(0,0));
        maze_length[0][0] = 1;
        maze_length[N-1][M-1] = Integer.MAX_VALUE;
        visited[0][0] = true;
		
		bfs();
		
		System.out.println(maze_length[N-1][M-1]);
		
	}

	private static void bfs() {
		while(!q.isEmpty()) {
            Point p = q.poll();
            int x = p.x;
            int y = p.y;
            
            for (int k=0; k<4; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];
                
                if (nx>=0 && ny>=0 && nx<N && ny<M && !visited[nx][ny] && maze[nx][ny]==1) {
                    visited[nx][ny] = true;
                    int length = maze_length[x][y] + 1;
                    maze_length[nx][ny] = Math.min(maze_length[nx][ny], length);
                    
                    if (nx==N-1 && ny==M-1) break;
                    
                    q.add(new Point(nx, ny));
                }
            }
			
		}
	}
}