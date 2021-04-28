
public class 시저암호 {
	public static String solution(String s, int n) {
		String answer = "";
        
        for(int i=0; i<s.length(); i++) {
        	char c = s.charAt(i);
        	
        	if(Character.isUpperCase(c)) {
        		answer += (char)(((c-'A'+n)%26)+'A');
        	}else if(Character.isLowerCase(c)) {
        		answer += (char)((c-'a'+n)%26+'a');
        	}else {
        		answer += s.charAt(i);
        	}
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		String s = "AB";
		int n = 1;
		
		String s2 = "a B z";
		int n2 = 4;
		
		System.out.println(solution(s, n));
		System.out.println(solution(s2,n2));
	}
}