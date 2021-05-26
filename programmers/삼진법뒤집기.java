
public class 삼진법뒤집기 {
	public static int solution(int n) {
        boolean flag = true;
        int x = 0;
        int y = 0;
        String three = "";
        int answer = 0;
        
        // 10진법 -> 3진법
        while(flag) {	
        	if(Math.pow(3, x) > n) {
        		flag = false;
        	}else {
        		x++;
        	}
        }
        
        y = x;
        
        while(!(n==0 && x==0)) {
        	String s = Integer.toString((int) (n/(Math.pow(3, x-1))));
        	three += s;
        	n %= (int) (Math.pow(3, x-1));
        	x--;
        }
        
        // 뒤집기
        StringBuilder sb = new StringBuilder(three);
		String reverseSb = sb.reverse().toString();
		String[] arr = reverseSb.split("");
		
		// 3진법 -> 10진법
		for(int i=0; i<arr.length; i++) {
			int tmp = (int) (Integer.parseInt(arr[i]) * (Math.pow(3, y-1)));
			answer += tmp;
			y--;
		}
		
        return answer;
    }
	
	
	public static void main(String[] args) {
		System.out.println(solution(45));
	}
}
