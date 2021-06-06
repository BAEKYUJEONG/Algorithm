
public class programmers_타겟넘버 {
	static int answer = 0;
	
    public static int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        
        return answer;
    }
    
    public static void dfs(int[] numbers, int target, int depth, int ans){
        if(depth==numbers.length){
            if(ans==target) answer++;
            return;
        }
        
        dfs(numbers, target, depth+1, ans+numbers[depth]);
        dfs(numbers, target, depth+1, ans-numbers[depth]);
    }

	public static void main(String[] args) {
		int[] numbers = {1, 1, 1, 1, 1};
		int target = 3;
		
		System.out.println(solution(numbers, target));
	}
}
