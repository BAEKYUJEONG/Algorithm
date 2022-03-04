import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;

        HashSet<Integer> numSet = new HashSet<>(Arrays.asList(1,2,3,4,5,6,7,8,9,0));

        for (int n: numbers) {
            if (numSet.contains(n)) {
                numSet.remove(n);
            }
        }

        for (int n: numSet) {
            answer += n;
        }

        return answer;
    }
}