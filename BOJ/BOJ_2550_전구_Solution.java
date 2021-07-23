import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M, C;
	static int[][] honeys;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] switches = new int[N];
		for(int i = 0; i < N; i++) switches[i] = Integer.parseInt(st.nextToken());
		int cnt = 1;
		int[] mapping = new int[10001];
		int[] reverseMapping = new int[10001];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int bulb = Integer.parseInt(st.nextToken());
			mapping[bulb] = cnt;
			reverseMapping[cnt] = bulb;
			++cnt;
		}
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = mapping[switches[i]];
		}

		int[] answerIdx = LIS(arr);
		int[] answer = new int[answerIdx.length];
		for(int i = 0; i < answer.length; i++) {
			answer[i] = reverseMapping[answerIdx[i]];
		}
		Arrays.sort(answer);
		System.out.println(answer.length);
		for(int i = 0; i < answer.length; i++) System.out.print(answer[i] + " ");
	}
	
	public static int[] LIS(int[] arr) {
		int[] lis = new int[arr.length];
		int[] compare = new int[arr.length + 1];
		
		int max = 0;
		int maxIdx = 0;
		for(int i = 0; i < lis.length; i++) {
			for(int j = 1; j < compare.length; j++) {
				if(compare[j] > arr[i] || compare[j] == 0) {
					lis[i] = j;
					if(max < j) {
						max = j;
						maxIdx = i;
					}
					compare[j] = arr[i];
					break;
				}
			}
		}
		int[] answer = new int[max];
		for(int i = maxIdx; i >= 0; i--) {
			if(max == 0) break;
			if(lis[i] == max) {
				answer[max - 1] = arr[i];
				--max;
			}
		}
		return answer;
	}
}