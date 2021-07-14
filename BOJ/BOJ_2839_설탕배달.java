import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2839_설탕배달 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int sum = 0;
		
		while(true) {
			if(N%5 == 0) {
				sum += N/5;
				System.out.println(sum);
				break;
			}else {
				N -= 3;
				sum++;
			}
			
			if(N<0) {
				System.out.println("-1");
				break;
			}
		}
	}
}
