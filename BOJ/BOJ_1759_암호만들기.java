import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759_암호만들기 {
	static int L,C;
	static char[] word;
	static boolean[] visited;
	static String code = "";
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken()); //4
		C = Integer.parseInt(st.nextToken()); //6
		word = new char[C];
		visited = new boolean[C];
		
		String line = br.readLine().replace(" ","");
		
		for(int i=0; i<C; i++) {
			word[i] = line.charAt(i);
		}
		
		Arrays.sort(word);
		
		makeCode(0,0);
	}

	private static void makeCode(int start, int length) {
		if(length==L) {
			print();
			return;
		}
		
		for(int i=start; i<C; i++) {
			visited[i] = true;
			makeCode(i+1, length+1);
			visited[i] = false;
		}
	}

	private static void print() {
		int mo = 0;
		int za = 0;
		
		for(int i=0; i<C; i++) {
			if(visited[i]) {
				if(word[i]=='a'|| word[i]=='e' || word[i]=='i' || word[i]=='o' || word[i]=='u') mo++;
				else za++;
				code += word[i];
			}
		}
		
		if(mo>=1 && za>=2) System.out.println(code);
		
		code = "";
	}
}