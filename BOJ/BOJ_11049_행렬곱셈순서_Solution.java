import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long[][] rc;
	static long[][] memo = new long[500][500];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		rc = new long[N][];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			long r = Long.parseLong(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			rc[i] = new long[] { r, c };
		}
		System.out.println(cal(0, rc.length - 1)[2]);
	}
	
	public static long[] cal(int from, int to) {
		if(from == to) {
			return new long[] { rc[from][0], rc[from][1], 0 }; 
		}
		
		if(memo[from][to] != 0) {
			return new long[] { rc[from][0], rc[to][1], memo[from][to] };
		}
		
		long[] arr = null;
	
		for(int j = from; j < to; j++) {
			long[] cal1 = cal(from, j);
			long[] cal2 = cal(j + 1, to);
			long r = cal1[0];
			long c = cal2[1];
			long calculate = cal1[0] * cal2[0] * cal2[1] + cal1[2] + cal2[2];
			if(arr == null || arr[2] > calculate) arr = new long[] { r, c, calculate };
		}
		memo[from][to] = arr[2];
		return arr;
	}
}