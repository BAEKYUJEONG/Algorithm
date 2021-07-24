import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int answer;
	static int[][] aquarium;
	static int width;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		aquarium = new int[40000][2];
		int N = Integer.parseInt(br.readLine());
		
		br.readLine(); // 0, 0 버리고
		
		answer = 0;
		// 1~2는 수직 2~3은 수평선분 반복
		for(int Ni = 1; Ni < N - 1; Ni += 2) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int depth = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int to = Integer.parseInt(st.nextToken());
			
			for(int i = from; i < to; i++) aquarium[i][1] = depth;
			answer += (to - from) * depth;
		}
		st = new StringTokenizer(br.readLine());
		width = Integer.parseInt(st.nextToken()); // 수족관 가로 길이
		
		int K = Integer.parseInt(br.readLine());
		
		for(int Ki = 0; Ki < K; Ki++) {
			st = new StringTokenizer(br.readLine());
			int hole = Integer.parseInt(st.nextToken());
			if(aquarium[hole][0] == aquarium[hole][1]) continue;
			leak(hole);
		}
		System.out.println(answer);
	}
	
	public static void leak(int start) {
		answer -= aquarium[start][1] - aquarium[start][0];
		aquarium[start][0] = aquarium[start][1];
		
		int leakDepth = aquarium[start][1];
		
		for(int left = start - 1; left >= 0; left--) {
			if(leakDepth > aquarium[left][1]) leakDepth = aquarium[left][1];
			int depthDiff = leakDepth - aquarium[left][0];
			if(depthDiff == 0) break;
			aquarium[left][0] += depthDiff;
			answer -= depthDiff;
		}
		
		leakDepth = aquarium[start][1];
		for(int right = start + 1; right < width; right++) {
			if(leakDepth > aquarium[right][1]) leakDepth = aquarium[right][1];
			int depthDiff = leakDepth - aquarium[right][0];
			if(depthDiff == 0) break;
			aquarium[right][0] += depthDiff;
			answer -= depthDiff;
		}
	}
}
