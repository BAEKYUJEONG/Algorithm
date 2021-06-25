import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> map = new HashMap<>();

        for(int row = 0; row < clothes.length; row++) {
            String c = clothes[row][1];
            //System.out.println(c);
            map.put(c, map.getOrDefault(c, 1) + 1);
        }

         for(String key: map.keySet()) {
             answer *= map.get(key);
         }

        return answer-1;
    }
}