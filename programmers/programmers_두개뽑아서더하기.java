import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer;
        HashSet<Integer> set = new HashSet<>();
        
        for(int i=0; i<numbers.length; i++){
            for(int j=0; j<numbers.length; j++){
                if(i!=j){
                    int num = numbers[i]+numbers[j];
                    set.add(num);
                }
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>(set);
        
        Collections.sort(list);
        answer = new int[list.size()];
        
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}