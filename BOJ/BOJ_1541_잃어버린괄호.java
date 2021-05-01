import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1541_잃어버린괄호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		String ns = "";
		int plus = 0;
		int minus = 0;
		int count = 0;
		
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			
			if((c=='+' || c=='-') && count==0) { //한번도 -가 안나왔을 때
				plus += Integer.parseInt(ns);
				ns = "";
				if(c=='-') count++;
			}else if((c=='+' || c=='-') && count>0){ //한번이라도 -가 나왔을때
				minus += Integer.parseInt(ns);
				ns = "";
			}else if(i==s.length()-1){ //마지막 문자일 때
				ns += c;
				
				if(count==0) {
					plus += Integer.parseInt(ns);
				}else {
					minus += Integer.parseInt(ns);
				}
			}else { //일반 문자일 때
				ns += c;
			}
		}
		
		System.out.println(plus-minus);
	}
}