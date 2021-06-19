import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2675_문자열반복 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			String line = st.nextToken();
			
			for(int i=0; i<line.length(); i++) {
				for(int j=0; j<num; j++) {
					System.out.print(line.charAt(i));
				}
			}
			System.out.println();
		}
	}
}
