import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int time, cnt;

    public static void bfs(int A, int B) {
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[100001];
        q.add(A);
        
        time = 0;
        cnt = 0;
        boolean flag = true;
        
        while(flag) {
            int qSize = q.size();
            
            for(int qi = 0; qi < qSize; qi++) {
                int poll = q.poll();
                int next = 0;
                
                if (poll == B) {
                	flag = false;
                	++cnt;
                	return;
                }
                
                for (int i=0; i<3; i++) {
                	if (i==0) next = poll - 1;
                	if (i==1) next = poll + 1;
                	if (i==2) next = poll * 2;
                	
                	if (next == B) {
                		flag = false;
                		++cnt;
                	} else if (flag) {
                		if (next >=0 && next <= 100000 && (visited[next] == 0 || visited[next] >= time)) {
                    		q.add(next);
                    		visited[next] = time;
                    	}
                	}
                }
            }
            
            ++time;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        
        bfs(A, B);

        System.out.println(time);
        System.out.println(cnt);
    }
}