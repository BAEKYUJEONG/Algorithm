import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] answer;
        HashMap<String, String> user = new HashMap<>();
        ArrayList<String> message = new ArrayList<>();

        for(int i=0; i<record.length; i++){
            String[] line = record[i].split(" ");

            if(line[0].equals("Enter")){
                user.put(line[1], line[2]);
                message.add(line[0]+" "+line[1]);
            }else if(line[0].equals("Leave")){
                message.add(record[i]);
            }else{
                user.put(line[1], line[2]);
            }
        }

        answer = new String[message.size()];

        for(int i=0; i<answer.length; i++){
            String[] line = message.get(i).split(" ");
            if(line[0].equals("Enter")){
                answer[i] = user.get(line[1])+"님이 들어왔습니다.";
            }else {
                answer[i] = user.get(line[1])+"님이 나갔습니다.";
            }
        }

        return answer;
    }
}