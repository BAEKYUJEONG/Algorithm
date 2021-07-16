import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9095_123더하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		int[] dp = new int[11];
		
		dp[1] = 1; // 초기값 초기화
		dp[2] = 2;
		dp[3] = 4;
		
		for(int i=4; i<=10; i++) {
			dp[i] = dp[i-3] + dp[i-2] + dp[i-1]; // 점화식
		}
		
		for(int tc=1; tc<=T; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			System.out.println(dp[n]);
		}
	}
}
