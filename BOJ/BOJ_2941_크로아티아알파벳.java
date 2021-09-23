import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2941_크로아티아알파벳 {
	static String alpa[] = {"c=", "c-", "dz", "d-", "lj", "nj", "s=", "z="};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String word = br.readLine();
		int count = 0;
		
		for(int i=0; i<word.length(); i++) {
			if(i+2 <= word.length()) { // 잘라서 비교할 만큼 양이 남아있을 때
				String s = word.substring(i, i+2);
				
				for(int j=0; j<alpa.length; j++) {
					if(s.equals(alpa[j])) { // 알파벳이 같다면
						if(alpa[j].equals("dz")) { // dz일 경우
							if(i+3 <= word.length() && word.substring(i, i+3).equals("dz=")) {
								i = i+2;
								break;
							}
						}else { // dz 이외에
							i++;
							break;
						}
					}
				}
			}
			count++;
		}
		
		System.out.println(count);
		
	}
}

