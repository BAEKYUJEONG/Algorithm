import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class BOJ_5430_AC {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			String[] p = br.readLine().split(""); //R
			int n = Integer.parseInt(br.readLine()); //4
			String[] arr = br.readLine().replace("[","").replace("]","").split(","); //[1,2,3,4]
			
			Deque<Integer> dq = new LinkedList<Integer>();
			StringBuilder sb = new StringBuilder("");
			boolean isReverse = false;
			
			for(int i=0; i<n; i++) {
				dq.add(Integer.parseInt(arr[i]));
			}
			
			loop :
			for(int i=0; i<p.length; i++) {
				if(p[i].equals("R")) {
					isReverse = !isReverse;
				}else { //D
					if(dq.isEmpty()) {
						sb.append("error");
						break loop;
					}
					
					if(!isReverse) dq.removeFirst();
					else dq.removeLast();
				}
			}
			
			if(!sb.toString().equals("error")) {
				int size = dq.size();
				sb.append("[");
				for(int i=0; i<size; i++) {					
					if(!isReverse) {
						sb.append(dq.pollFirst());
					}else {
						sb.append(dq.pollLast());
					}
					if(!dq.isEmpty()) sb.append(",");
				}
				sb.append("]");
			}
			
			System.out.println(sb.toString());
		}
	}
}