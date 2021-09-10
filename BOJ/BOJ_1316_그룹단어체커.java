import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BOJ_1316_그룹단어체커 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int answer = N;
		
		for(int n=0; n<N; n++) {
			String word = br.readLine();
			
			HashSet<Character> set = new HashSet<>();
			
			set.add(word.charAt(0));
			
			for(int i=1; i<word.length(); i++) {
				char a = word.charAt(i-1);
				char b = word.charAt(i);
				
				if(!set.contains(b)) {
					set.add(b);
				}else if(a==b) {
					continue;
				}else {
					answer--;
					break;
				}
			}
		}
		
		System.out.println(answer);
	}
}
