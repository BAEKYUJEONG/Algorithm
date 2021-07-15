import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1463_1로만들기 {
	static int[] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int X = Integer.parseInt(br.readLine());
		
		dp = new int[X+1];
		
		dp[0] = dp[1] = 0;
		
		for(int i=2; i<=X; i++) {
			dp[i] = dp[i-1] + 1;
			if(i%2 == 0)
				dp[i] = Math.min(dp[i], dp[i/2] + 1);
			if(i%3 == 0)
				dp[i] = Math.min(dp[i], dp[i/3] + 1);
		}
		
		System.out.println(dp[X]);
	}
}