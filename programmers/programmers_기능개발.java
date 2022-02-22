import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int day = 1;
        Queue<Integer> progressQueue = new LinkedList<>();
        Queue<Integer> speedQueue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int p: progresses) progressQueue.add(p);
        for (int s: speeds) speedQueue.add(s);
        
        while (!progressQueue.isEmpty()) {
            int finish = 0;
            int work = progressQueue.peek();
            
            while (work + (speedQueue.peek() * day) >= 100) {
                ++finish;
                progressQueue.remove();
                speedQueue.remove();
                
                if(progressQueue.isEmpty()) break; // 천재
                
                work = progressQueue.peek();
            }
            
            if (finish > 0) list.add(finish);
            
            ++day;
        }
        
        int[] answer = list.stream().mapToInt(i->i).toArray();
        
        return answer;
    }
}