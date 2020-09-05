import java.util.Scanner;

public class Solution_4796_의석이의우뚝선산 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int[] mountain;

		int result = 0;
		int N;
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			result = 0;
			N = sc.nextInt();
			mountain = new int[N];

			for (int i = 0; i < N; i++)
				mountain[i] = sc.nextInt();

			int up = 0;
			int down = 0;
			//            1 4 6 5 3 7 9 2 8
			for (int i = 1; i < N; i++) {
				if (mountain[i - 1] < mountain[i]) {
					if (up == 0 && down > 0) {
						down = 0;
					} else if (up > 0 && down > 0) {
						result += up * down;
						up = 0;
						down = 0;
					}
				}
//			     모든 1≤i＜j≤N 에 대해 hi≠hj 이다.
				if (mountain[i - 1] < mountain[i])
					up++;
				else 
					down++;
			}

			if(up > 0 && down > 0)
				result += up * down;
			System.out.println("#" + test_case + " " + result);           
		}
		sc.close();
	}
}
