import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean flag = true;

        while (flag) {
            Stack<Character> stack = new Stack<>();
            String line = br.readLine();

            if (line.equals(".")) {
                flag = false;
                break;
            }

            char[] arr = line.toCharArray();

            for (int i=0; i<arr.length; i++) {
                if (arr[i]=='(') stack.push(arr[i]);
                else if (arr[i]=='[') stack.push(arr[i]);
                else if (arr[i]==')') {
                    if (stack.size()>0 && stack.peek()=='(') stack.pop();
                    else stack.push(arr[i]);;
                }
                else if (arr[i]==']') {
                    if (stack.size()>0 && stack.peek()=='[') stack.pop();
                    else stack.push(arr[i]);;
                }
                else continue;
            }

            if (stack.size()==0) System.out.println("yes");
            else {
                System.out.println("no");
            }
        } 
    }
}