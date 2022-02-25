import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int[] rank = {6,6,5,4,3,2,1};
        int zero = 0;
        int correct = 0;

        Set<Integer> winSet = new HashSet<>();

        for (int wn: win_nums) winSet.add(wn);

        for (int n: lottos) {
            if (n == 0) zero++;
            else if (winSet.contains(n)) correct++;
        }

        answer[0] = rank[correct+zero];
        answer[1] = rank[correct];

        return answer;
    }
}