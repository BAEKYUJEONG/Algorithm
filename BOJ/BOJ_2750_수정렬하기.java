import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_2750_수정렬하기 {
	static int N, n;
	static PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			n = Integer.parseInt(br.readLine());
			pq.add(n);
		}
		
		while(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}
}