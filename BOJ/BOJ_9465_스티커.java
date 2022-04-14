import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());

        for (int tc=1; tc<=T; tc++) {
            int N = Integer.parseInt(br.readLine());

            int[][] sticker = new int[2][N+1];

            for (int i=0; i<2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j=1; j<=N; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=2; i<=N; i++) {
                sticker[0][i] += Math.max(sticker[1][i-1], sticker[1][i-2]);
				sticker[1][i] += Math.max(sticker[0][i-1], sticker[0][i-2]);
			}
            
            System.out.println(Math.max(sticker[0][N], sticker[1][N]));
        }
	}
}