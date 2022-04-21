import java.util.*;
import java.awt.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for (int i=0; i<5; i++) {
            ArrayList<Point> list = new ArrayList<>();
            char[][] room = new char[5][5];
            
            for (int j=0; j<5; j++) {
                String line = places[i][j];
                for (int k=0; k<5; k++) {
                    room[j][k] = line.charAt(k);
                    
                    if (room[j][k] == 'P') {
                        list.add(new Point(j, k));
                    }
                }
            }
            
            if (list.size() == 0) {
                answer[i] = 1;
            } else {
                answer[i] = 1;
                
                for (Point p: list) {
                    int x = p.x;
                    int y = p.y;
                    
                    int result = bfs(x, y, room);
                    
                    if (result == 0) {
                        answer[i] = 0;
                        break;
                    }
                }
            }
        }
        
        return answer;
    }
    
    public int bfs(int x, int y, char[][] room) {
        int dx[] = {-1, 0, 1, 0};
        int dy[] = {0, -1, 0, 1};
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[5][5];
        
        queue.add(new Point(x, y));
        visited[x][y] = true;
        
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            int r = p.x;
            int c = p.y;
            
            for (int k=0; k<4; k++) {
                int nr = r + dx[k];
                int nc = c + dy[k];
                int d = Math.abs(x - nr) + Math.abs(y - nc);
                
                if (nr>=0 && nc>=0 && nr<5 && nc<5 && d<=2 && !visited[nr][nc]) {
                    if(room[nr][nc] == 'P') {
                        return 0;
                    } else if(room[nr][nc] == 'O') {
                        visited[nr][nc] = true;
                        queue.add(new Point(nr, nc));
                    }
                }
            }
        }
        return 1;
    }
}