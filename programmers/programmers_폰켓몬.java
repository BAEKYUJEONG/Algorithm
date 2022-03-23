import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int half = nums.length / 2;
        
        Set<Integer> set = new HashSet<>();
        
        for(int n: nums) {
            set.add(n);
        }
        
        if (set.size() > half) return half;
        else return set.size();
    }
}