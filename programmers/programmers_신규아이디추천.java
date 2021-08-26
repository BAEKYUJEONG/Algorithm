class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        answer = new_id;
        
        //1
        answer = answer.toLowerCase();
        
        //2
        answer = answer.replaceAll("[^a-z0-9-_.]","");
        
        //3
        while(answer.contains("..")) {
        	answer = answer.replace("..", ".");
        }
        
        //4
        if(answer.length() > 0 && answer.charAt(0) == '.') {
        	answer = answer.substring(1, answer.length());
        }
        if(answer.length() > 0 && answer.charAt(answer.length()-1) == '.') {
        	answer = answer.substring(0, answer.length()-1);
        }
        
        //5
        if(answer.equals("")) answer = "a";
        
        //6
        if(answer.length() >= 16) answer = answer.substring(0, 15);
        if(answer.length() > 0 && answer.charAt(answer.length()-1) == '.') {
        	answer = answer.substring(0, answer.length()-1);
        }
        
        //7
        if(answer.length() > 0 && answer.length() <= 2) {
        	while(answer.length() < 3) {
        		answer += answer.charAt(answer.length()-1);
        	}
        }
        
        return answer;
    }
}