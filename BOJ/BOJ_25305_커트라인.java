import java.util.Scanner;
import java.util.Arrays;

public class BOJ_25305_커트라인 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt(); // 응시자 수
        int k = sc.nextInt(); // 상 받는 사람 수
        int[] scores = new int[N];
        
        for (int i = 0; i < N; i++) {
            scores[i] = sc.nextInt();
        }
        
        Arrays.sort(scores); // 오름차순 정렬
        
        // 뒤에서부터 k번째 사람이 커트라인
        System.out.println(scores[N - k]); 
    }
}