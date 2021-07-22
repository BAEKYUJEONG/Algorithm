import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	
	 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] flowers = new int[N][];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int startM = Integer.parseInt(st.nextToken());
			int startD = Integer.parseInt(st.nextToken());
			int endM = Integer.parseInt(st.nextToken());
			int endD = Integer.parseInt(st.nextToken());
			flowers[i] = new int[] { startM, startD, endM, endD };
		}
		//끝나는 날짜가 가장 긴것중에 현재 날짜보다 작은거
		Arrays.sort(flowers, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[2] != o2[2]) return o2[2] - o1[2];
				else return o2[3] - o1[3];
			}
		});

		int nowM = 3;
		int nowD = 1;
		int answer = 0;
		loop:
		while(true) {
			for(int[] flower: flowers) {
				int sM = flower[0];
				int sD = flower[1];
				int eM = flower[2];
				int eD= flower[3];
				
				if(sM < nowM || (sM == nowM && sD <= nowD)) {
					if(eM < nowM || (eM == nowM && eD <= nowD)) continue;
					nowM = eM;
					nowD = eD;
					++answer;
					if(nowM > 11) break loop;
					continue loop;
				} 
			}
			System.out.println(0);
			return;
		}
		System.out.println(answer);
	}
}
