import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        long n = Long.parseLong(reader.readLine());
        int pisano = 1500000; // 피사노 주기
        long[] dp = new long[pisano];
        
        dp[0] = 0; 
        dp[1] = 1;
 
        for(int i=2; i<pisano && i<=n; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 1000000;  // 피보나치 수를 1,000,000 으로 나눈 나머지 값을 저장 
        }
        
        n %= pisano;
 
        System.out.println(dp[(int) n]);
    }
}