import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11720_숫자의합 {
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		br.readLine();
		String num[] = br.readLine().split("");
		
		for(int i=0; i<num.length; i++) {
			answer += Integer.parseInt(num[i]);
		}
		
		System.out.println(answer);
	}
}
