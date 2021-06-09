import java.util.*;

public class programmers_HIndex {
	public static int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
 
        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;
 
            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }
 
        return answer;
    }
	
	public static void main(String[] args) {
		int[] citations = {3, 0, 6, 1, 5};
		int[] a = {1,4,7,7,8};
		int[] b = {1,1,4,4,4};
		
		System.out.println(solution(citations));
		System.out.println(solution(a));
		System.err.println(solution(b));
	}
}
