class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        for (int i=0; i<nums.length-2; i++) {
            for (int j=i+1; j<nums.length-1; j++) {
                for (int k=j+1; k<nums.length; k++) {
                    int N = nums[i] + nums[j] + nums[k];
                    int tmp = 0;

                    for (int x=2; x<N; x++) {
                        if (N % x == 0) tmp++;
                    }

                    if(tmp==0) answer++;
                }
            }
        }

        return answer;
    }
}