import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n+1][n+1];

        for (int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=i; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=n-1; i>=1; i--) {
            for (int j=n-1; j>=1; j--) {
                map[i][j] += Math.max(map[i+1][j], map[i+1][j+1]);
            }
        }

        System.out.println(map[1][1]);
	}
}