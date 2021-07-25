import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] chars1 = br.readLine().toCharArray();
		char[] chars2 = br.readLine().toCharArray();
		
		int[][] lcs = new int[chars1.length + 1][chars2.length + 1];
		
		for(int r = 1; r <= chars1.length; r++) {
			for(int c = 1; c <= chars2.length; c++) {
				if(chars1[r - 1] == chars2[c - 1]) 
					lcs[r][c] = lcs[r - 1][c - 1] + 1;
				else lcs[r][c] = Math.max(lcs[r - 1][c], lcs[r][c - 1]);
			}
		}
		System.out.println(lcs[chars1.length][chars2.length]);
	}
	
}
