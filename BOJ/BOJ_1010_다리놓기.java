import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] nCr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			nCr = new int[31][31];
			
			if (N<M) {
				int p = N;
				N = M;
				M = p;
			}
			
			for (int n=1; n<=30; n++) {
				for (int r=1; r<=n; r++) {
					if (r==1) {
						nCr[n][r] = n;
					} else if (n==r) {
						nCr[n][r] = 1;
					} else {
						nCr[n][r] = nCr[n-1][r-1] + nCr[n-1][r];
					}
				}
			}
			
			System.out.println(nCr[N][M]);
		}
	}
}