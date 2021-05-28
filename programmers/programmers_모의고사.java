import java.util.Arrays;

public class programmers_모의고사 {
	public static int[] solution(int[] answers) {
        int[] answer;
        int[] ans = new int[3];
        boolean[] visited_max = new boolean[3];
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {2,1,2,3,2,4,2,5};
        int[] arr3 = {3,3,1,1,2,2,4,4,5,5};
        int length = 0;

        for(int i=0; i<answers.length; i++){
            if(answers[i] == arr1[i%5]) ans[0]++;
            if(answers[i] == arr2[i%8]) ans[1]++;
            if(answers[i] == arr3[i%10]) ans[2]++;
        }

        int max = Math.max(ans[0], Math.max(ans[1], ans[2]));

        for(int i=0; i<3; i++) {
            if(ans[i] == max) {
                length++;
                visited_max[i] = true;
            }
        }

        answer = new int[length];

        int n = 0;
        for(int i=0; i<3; i++) {
            if(visited_max[i]==true) {
                answer[n] = i+1;
                n++;
            }
        }

        return answer;
    }
	
	public static void main(String[] args) {
		//int[] answers = {1,2,3,4,5};
		int[] answers = {1,3,2,4,2}; 
		
		System.out.println(Arrays.toString(solution(answers)));
	}
}
