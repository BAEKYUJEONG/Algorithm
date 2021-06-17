import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2562_최댓값 {
	static int num[] = new int[9];
	static int max = Integer.MIN_VALUE;
	static int th;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<9 ; i++) {
			num[i] = Integer.parseInt(br.readLine());
			max = Math.max(num[i], max);
			if(num[i]==max) {
				th = i+1;
			}
		}
		
		System.out.println(max);
		System.out.println(th);
	}
}
