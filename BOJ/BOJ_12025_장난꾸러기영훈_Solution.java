import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] pw = br.readLine().toCharArray();
		long k = Long.parseLong(br.readLine()) - 1;
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < pw.length; i++) {
			if(pw[i] == '1' || pw[i] == '2' || pw[i] == '6' || pw[i] == '7') stack.add(i);
		}
		if(k < 0 || k >= pow(stack.size())) {
			System.out.println(-1);
			return;
		}
		int cnt = 0;
		while(!stack.isEmpty()) {
			int index = stack.pop();
			if((k & (1 << cnt++)) > 0) {
				if(pw[index] == '1') pw[index] = '6';
				else if(pw[index] == '2') pw[index] = '7';
			} else {
				if(pw[index] == '6') pw[index] = '1';
				else if(pw[index] == '7') pw[index] = '2';
			}
		}
		for(int i = 0; i < pw.length; i++)
			System.out.print(pw[i]);
		System.out.println();
	}
	
	public static long pow(int size) {
		long mul = 1;
		for(int i = 0; i < size; i++) mul *= 2;
		return mul;
	}
}