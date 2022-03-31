import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
        // 입력
		int N = Integer.parseInt(br.readLine());
        int[] time = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }

        // 풀이
        Arrays.sort(time);
        
        int answer = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<i+1; j++) {
                answer += time[j];
            }
        }

        System.out.println(answer);
	}
}