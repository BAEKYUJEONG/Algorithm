import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ_11279_최대힙 {
	static PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			int n = Integer.parseInt(br.readLine());
			
			if(n==0) {
				if(pq.isEmpty()) {
					System.out.println(0);
				}else {
					int p = pq.poll();
					System.out.println(p);
				}
			}else {
				pq.add(n);
			}
		}
	}
}
