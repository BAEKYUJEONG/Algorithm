import java.util.Scanner;

public class sw4796_solution {
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
			for (int i = 1; i < N; i++) {	// 앞에것과 -1해서 비교하기 위해 1부터 시작한다.
				if (mountain[i - 1] < mountain[i]) {	// 경우의 수 구하는 공식
					if (up == 0 && down > 0) { //앞에 올라간건 없는데 내려가기만 하면 소용이 없음.
						down = 0;
					} else if (up > 0 && down > 0) { // 앞에 쭉쭉쭉 올라가던 일단 다 up에 더해주고, down이 생겼을때마다  1씩 경우의 수를 곱해줘서 더해준다.
													// 12345 4(5*1) 3(5*1) 이런 식으로 더해줌
						result += up * down;
						up = 0;
						down = 0;
					}
				}
//			     모든 1≤i＜j≤N 에 대해 hi≠hj 이다.
				if (mountain[i - 1] < mountain[i]) // 일단 앞에것에 비해 수가 적은지 많은지
					up++;
				else 
					down++;
			}

			if(up > 0 && down > 0)	//마지막것까지 확인하고 result에 넣어준 후 마무리.
				result += up * down;
			System.out.println("#" + test_case + " " + result);           
		}
		sc.close();
	}
}