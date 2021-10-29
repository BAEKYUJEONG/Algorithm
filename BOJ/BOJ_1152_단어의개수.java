import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1152_단어의개수 {
	
	static boolean[][] box = new boolean[1000][1000];
	static ArrayList<Bar> bars = new ArrayList<Bar>();
	static int sum = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			
			bars.add(new Bar(L, H));
		}
		
		Collections.sort(bars, Collections.reverseOrder());
		
		Bar barTop = bars.remove(0);
		int middle = barTop.L;
		int top = barTop.H;
		
		sum += top;
		
		int left = middle;
		int right = middle;
		
		while(!bars.isEmpty()) {
			Bar bar1 = bars.remove(0);
			int bL = bar1.L;
			int bH = bar1.H;
			
			if(bL < middle) {
				if(left > bL) {
					sum += (left-bL) * bH;
					left = bL; 
				}
			}else {
				if(bL > right) {
					sum += (bL-right) * bH;
					right = bL;
				}
			}
		}
		
		System.out.println(sum);
	}

}

class Bar implements Comparable<Bar> {
	int L;
	int H;
	
	public Bar(int L, int H) {
		this.L = L;
		this.H = H;
	}

	@Override
	public int compareTo(Bar bar) {
		
		if(this.H < bar.H) {
			return -1;
		} else if(this.H == bar.H) {
			return 0;
		} else {
			return 1;
		}
		
	}
	
}