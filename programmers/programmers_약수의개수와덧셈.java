class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for (int n=left; n<=right; n++) {
            int yakN = 0;
            
            for(int i=1; i<=n; i++) {
                if (n%i == 0) yakN++;
            }
            
            if(yakN%2 == 0) answer += n;
            else answer -= n;
        }
        
        return answer;
    }
}