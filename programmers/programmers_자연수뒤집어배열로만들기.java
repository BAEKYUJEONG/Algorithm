import java.util.*;

class Solution {
    public int[] solution(long n) {
        
        StringBuilder sb = new StringBuilder(Long.toString(n));
        String str = sb.reverse().toString();
        String[] ans = str.split("");
        int[] answer = Arrays.stream(ans).mapToInt(Integer::parseInt).toArray();
        
        return answer;
    }
}