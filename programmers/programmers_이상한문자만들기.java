class Solution {
    public String solution(String s) {
        String answer = "";
        
        int tmp = 0;
        
        for(int i=0; i<s.length(); i++){
            if(Character.toString(s.charAt(i)).equals(" ")){
                answer += s.charAt(i);
                tmp = 0;
            }else if(tmp%2==0){
                if(s.charAt(i)>=97) answer += Character.toString(s.charAt(i)-32);
                else answer += s.charAt(i);
                tmp++;
            }else {
                if(s.charAt(i)>=97) answer += s.charAt(i);
                else answer += Character.toString(s.charAt(i)+32);
                tmp++;
            }
        }
        
        return answer;
    }
}