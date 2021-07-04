import java.util.*;

class Solution {
    public String solution(String s) {
        
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        
        StringBuilder answer = new StringBuilder(new String(arr));
        
        return answer.reverse().toString();
    }
}