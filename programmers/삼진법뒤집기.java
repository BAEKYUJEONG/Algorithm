
public class 삼진법뒤집기 {
	public static int solution(int n) {
        int answer = 0;
        boolean flag = true;
        int i = 0;
        String ans = "";
        
        // 10진법 -> 3진법
        while(flag) {	
        	if(Math.pow(3, i) > n) {
        		flag = false;
        	}else {
        		i++;
        	}
        }
        
        while(!(n==0 && i==0)) {
        	String s = Integer.toString((int) (n/(Math.pow(3, i-1))));
        	ans += s;
        	n %= (int) (Math.pow(3, i-1));
        	i--;
        }
        
        answer = Integer.parseInt(ans);
        
        return answer;
    }
	
	
	public static void main(String[] args) {
		
		System.out.println(solution(45));
	}
}
