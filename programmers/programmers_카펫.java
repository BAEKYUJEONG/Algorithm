import java.util.Arrays;

public class programmers_Ä«Æê {
	public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int n = 1;
        int m = 0;
        boolean flag = true;

        while(flag && n<=yellow){
           if(yellow%n==0){
                m = yellow/n;
               if((2*m+2*n+4)==brown){
                   answer[0] = Math.max(m,n)+2;
                   answer[1] = Math.min(m,n)+2;
                   flag = false;
               }
            }
            n++;
        }

        return answer;
    }
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(10, 2)));
	}
}
