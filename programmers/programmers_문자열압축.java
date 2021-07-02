class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;

        int min = s.length();
        int repeat = 1;
        int n = 1;

        while(n <= s.length()/2 + 1){
            for(int i=0; i<=s.length()-2*n; i+=n){
                if(s.substring(i, i+n).equals(s.substring(i+n, i+2*n))){
                    repeat++;
                    min = min-n;
                    if(repeat==2 || repeat==10 || repeat==100 || repeat==1000) min += 1;
                }else{
                    repeat = 1;
                }
            }
            n++;
            answer = Math.min(answer, min);
            min = s.length();
            repeat = 1;
        }

        return answer;
    }
}