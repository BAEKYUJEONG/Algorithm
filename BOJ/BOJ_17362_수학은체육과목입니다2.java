import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17362_수학은체육과목입니다2 {
	static int n;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		System.out.println(answer(n));
	}

	private static int answer(int n) {
		n = n%8;
		
		if(n==1) return 1;
		else if(n==2 || n==0) return 2;
		else if(n==3 || n==7) return 3;
		else if(n==4 || n==6) return 4;
		else return 5;
	}
}
