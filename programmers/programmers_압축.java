import java.util.*;

class Solution {
    public static int[] solution(String msg) {
        int[] answer;
        ArrayList<Integer> answerlist = new ArrayList<>();

        HashSet<String> set = new HashSet<>();
        ArrayList<String> list = new ArrayList<>();

        for (int i=0; i<26; i++) {
            char ch = 'A';
            set.add(Character.toString((char) (ch+i)));
            list.add(Character.toString((char) (ch+i)));
        }
        
        int con = 0;

        for (int i=0; i<msg.length(); i++) {
           while (con>0) {
              con--;
              i++;
           }
           
            int plus = i+1;
            boolean flag = true;
            
            while(flag) {
                if (plus<=msg.length() && set.contains(msg.substring(i, plus))) {
                    plus++;
                } else {
                    flag = false;
                    plus--;
                }
            }

            String str = msg.substring(i, plus);

            for (int j=0; j<list.size(); j++) {
                if ((list.get(j)).equals(str)) {
                    int n = j+1;
                    answerlist.add(n);
                }
            }

            if (plus+1 <= msg.length()) {
                set.add(msg.substring(i, plus+1));
                list.add(msg.substring(i, plus+1));
            }
            
            if(plus>i+1) {
               con = plus - (i+1);
            }
        }

        answer = new int[answerlist.size()];
        for (int i=0; i<answerlist.size(); i++) {
            answer[i] = answerlist.get(i);
        }

        return answer;
    }
}