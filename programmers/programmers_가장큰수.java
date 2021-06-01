import java.util.HashMap;

public class programmers_가장큰수 {
	public static String solution(int[] numbers) {
        String answer = "";
        
        HashMap<Integer,String> map = new HashMap<>();
        
        for(int i=0; i<numbers.length; i++) {
        	String s = Integer.toString(numbers[i]);
            s = s.split(0,1);
            int n = Integer.parseInt(s);
            map.add(new HashMap(i, n));
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		int[] numbers = {6, 10, 2};
		
		System.out.println(solution(numbers));
	}
}
