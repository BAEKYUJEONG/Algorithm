import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String A = st.nextToken();
        String B = st.nextToken();
        int answer = 0;

        if (A.length() == B.length()) {
            for (int i=0; i<A.length(); i++) {
                if (!A.substring(i, i+1).equals(B.substring(i, i+1))) answer++;
            }
        } else {
            int min = Integer.MAX_VALUE;
            int tmp = 0;
            int index = 0;
            int difference = B.length() - A.length();

            while (index != difference + 1) {
                for (int i=0; i<A.length(); i++) {
                    if (!A.substring(i, i+1).equals(B.substring(i+index, i+1+index))) tmp++;
                }

                min = Math.min(min, tmp);
                tmp = 0;
                index++;
            }

            answer = min;
        }

        System.out.println(answer);
	}
}