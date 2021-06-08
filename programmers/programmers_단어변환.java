
public class programmers_단어변환 {
    static int answer = Integer.MAX_VALUE;
    static boolean[] visited;
    
    public static int solution(String begin, String target, String[] words) {
        int n = 0;
        visited = new boolean[words.length];
        
        for(int i=0; i<words.length; i++){
            if(words[i].equals(target)) break;
            else n++;
        }
        
        if(n==words.length) return 0; // words 안에 없을 때 0
        else dfs(0, begin, target, words);
        
        return answer;
    }
    
    // 백트래킹
    public static void dfs(int ans, String word, String target, String[] words){
        if(word.equals(target)){
            answer = Math.min(ans, answer);
        }
        
        for(int i=0; i<words.length; i++){
            if(!visited[i] && check(words[i], word)){
                visited[i] = true;
                dfs(ans+1, words[i], target, words); // ans+1 해주고, 하나만 다른 단어를 넣어준다.
                visited[i] = false;
            }
        }
    }
    
    // 단어가 하나만 다른지 체크하는 메소드
    public static boolean check(String word1, String word2){
    	int tmp = 0;
    	
        for(int i=0; i<word1.length(); i++){
            if(word1.charAt(i)!=word2.charAt(i)) {
            	tmp++;
            }
        }
        
        if(tmp==1) return true;
        
        return false;
    }
	
	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		
		System.out.println(solution(begin, target, words));
	}
}
