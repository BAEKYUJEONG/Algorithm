import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int answer = 0;

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = br.readLine();

            if (line.equals("0")) break;

            char[] number = line.toCharArray();
            String answer = "";
            String reverse_answer = "";

            for (int i=0; i<number.length; i++) {
                answer += Character.toString(number[i]);
                reverse_answer += Character.toString(number[number.length-1-i]);
            }

            if (answer.equals(reverse_answer)) System.out.println("yes");
            else System.out.println("no");
        }
	}
}