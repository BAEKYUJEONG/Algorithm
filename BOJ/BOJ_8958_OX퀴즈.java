import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_8958_OX퀴즈 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			String[] answers = br.readLine().split("");
			int answer = 0;
			int tmp = 1;
			
			for(int i=0; i<answers.length; i++) {	
				if(answers[i].equals("O")) {
					answer += tmp;
					tmp++;
				}else {
					tmp = 1;
				}
			}
			System.out.println(answer);
		}
	}
}
