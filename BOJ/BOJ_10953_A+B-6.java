import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        
        for (int tc=1; tc<=T; tc++) {
            String line = br.readLine();
            int n = line.charAt(0) - '0';
            int m = line.charAt(2) - '0';
            System.out.println(n+m);
        }
	}
}