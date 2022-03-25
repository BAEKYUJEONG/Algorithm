import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, max;
    static char[][] friend;
    static Set<Integer> set = new HashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        friend = new char [N][N];
        max = 0;
        
        // 입력
        for (int i=0; i<N; i++) {
            String line = br.readLine();
            for (int j=0; j<N; j++) {
                friend[i][j] = line.charAt(j);
            }
        }

        // 탐색
        for (int i=0; i<N; i++) {
        	set = new HashSet<>();
            for (int j=0; j<N; j++) {
                if (friend[i][j] == 'Y') {
                    set.add(j);

                    find(j);
                }
            }
            
            if (set.contains(i)) set.remove(i);
            
            max = Math.max(max, set.size());
        }

        System.out.println(max);
    }

    public static void find(int x) {
        for (int j=0; j<N; j++) {
            if (friend[x][j] == 'Y') {
                set.add(j);
            }
        }
    }
}