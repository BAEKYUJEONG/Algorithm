import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> p_queue = new LinkedList<>();
        Queue<Integer> l_queue = new LinkedList<>();
        
        for (int i=0; i<priorities.length; i++) {
            pq.add(priorities[i]);
            p_queue.add(priorities[i]);
            l_queue.add(i);
        }
        
        while(!pq.isEmpty()) {
            int priority = pq.poll();
            int poll = p_queue.poll();
            int loca = l_queue.poll();
            
            if(poll == priority) {
                answer++;
                
                if(loca == location) break;
            } else {
                pq.add(priority);
                p_queue.add(poll);
                l_queue.add(loca);
            }
        }
        
        return answer;
    }
}