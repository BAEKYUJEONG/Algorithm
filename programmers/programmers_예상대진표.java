class Solution {
    public int solution(int n, int a, int b) {
        int round = 1;
        boolean flag = true;
        
        while(flag){
            if(Math.abs(a-b)==1 && Math.max(a, b)%2==0) {
                flag = false;
                break;
            }
            
            if(a%2==1) a = a+1;
            if(b%2==1) b = b+1;
            
            a = a/2;
            b = b/2;
            round++;
        }

        return round;
    }
}