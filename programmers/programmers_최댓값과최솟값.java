import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";

        String[] str_arr = s.split(" ");
        int[] int_arr = new int[str_arr.length];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i=0; i<str_arr.length; i++) {
            int_arr[i] = Integer.parseInt(str_arr[i]);
            max = Math.max(max, int_arr[i]);
            min = Math.min(min, int_arr[i]);
        }

        answer += Integer.toString(min);
        answer += " ";
        answer += Integer.toString(max);

        return answer;
    }
}