import java.util.*;

public class programmers_완주하지못한선수 {
	public static String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        int i;
        
        for(i=0; i<completion.length; i++) {
        	if(!participant[i].equals(completion[i])) {
        		return participant[i];
        	}
        }
        
        return participant[i];
    }
	
	public static void main(String[] args) {
		String[] participant = {"leo","kiki","eden"};
		String[] completion = {"eden","kiki"};
		
		System.out.println(solution(participant, completion));
	}
}
