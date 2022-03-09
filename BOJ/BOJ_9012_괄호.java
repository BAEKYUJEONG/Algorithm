import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9012_괄호 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			String str = br.readLine();
            int check = 0;
			
			for(int i=0; i<str.length(); i++) {
				char c = str.charAt(i);
                
                if (c == '(') {
                    check++;
                } else if (c == ')') {
                    check--;
                }
                
                if (check < 0) {
                    System.out.println("NO");
                    break;
                }
                
                if(i == str.length()-1 && check == 0) {
                    System.out.println("YES");
                } else if(i == str.length()-1 && check != 0) {
                    System.out.println("NO");
                }
			}
		}
	}
}