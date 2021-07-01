class Solution {
    public int solution(String s) {
        int answer = 0;
        String ans = "";
        String[] eng_num = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        char[] num = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        
        for(int i=0; i<s.length(); i++){
            for(int j=0; j<10; j++){
                if(s.charAt(i)==num[j]) ans += Integer.toString(j);
                if(i + eng_num[j].length() <= s.length() && 
                   s.substring(i, i + eng_num[j].length()).equals(eng_num[j])) ans += Integer.toString(j);
            }
        }
        
        answer = Integer.parseInt(ans);
        
        return answer;
    }
}