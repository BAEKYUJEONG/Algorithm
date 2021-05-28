
public class 가운데글자가져오기 {
	public static String solution(String s) {
        String answer = "";
        
        if(s.length()%2==1) {
        	answer = s.substring(s.length()/2, (s.length()/2)+1);
        }else {
        	answer = s.substring((s.length()/2)-1, (s.length()/2)+1);
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		String s = "abcde";
		String s2 = "qwer";
		
		System.out.println(solution(s));
		System.out.println(solution(s2));
	}
}
