
public class programmers_소수찾기 {
	static int answer = 0;
	
	public static int solution(String numbers) {
        String[] num = numbers.split("");
        boolean[] visited = new boolean[num.length];
        
        for(int i=1; i<=num.length; i++) {
        	String[] output = new String[i];
        	permutation(num, visited, output, 0, i, num.length);
        }
        
        return answer;
    }
	
	public static void permutation(String[] num, boolean[] visited, String[] output, int depth, int n, int length) {
		if(depth == n) {
			check(output);
			return;
		}
		
		for(int i=0; i<length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				output[depth] = num[i];
				permutation(num, visited, output, depth+1, n, length);
				visited[i] = false;
			}
		}
	}
	
	public static void check(String[] output) {
		boolean flag = false;
		String s = "";
		for(int i=0; i<output.length; i++) {
			if(flag == true) s += output[i];
			else if(output[i]!="0") flag = true;
		}
		
		if(s=="") return;
		
		int n = Integer.parseInt(s);
		
		if(n==1) return;
		
		boolean[] visited = new boolean[n+1];
		
		for(int i=2; i<=n; i++) {
			for(int j=2; i*j<=n; j++) {
				visited[i*j] = true;
			}
		}
		
		if(!visited[n]) answer++;
	}

	public static void main(String[] args) {
		String numbers = "011";
		
		System.out.println(solution(numbers));
	}
}
