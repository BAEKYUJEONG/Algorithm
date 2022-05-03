import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<N; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x != 0) {
                stack.push(x);
            } else {
                stack.pop();
            }
        }

        while (!stack.isEmpty()) {
            int x = stack.pop();
            sum += x;
        }

        System.out.println(sum);
	}
}