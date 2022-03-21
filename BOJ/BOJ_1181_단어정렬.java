import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        Map<Integer, Set<String>> wordMap = new HashMap<>();

        int N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++) {
            String s = br.readLine();
            int length = s.length();

            Set<String> wordSet = wordMap.getOrDefault(length, new HashSet<>());
            wordSet.add(s);
            wordMap.put(length, wordSet);
        }


        List<Integer> keylist = new ArrayList<>(wordMap.keySet());
        Collections.sort(keylist);

        for (int i: keylist) {
            Set<String> wordSet = wordMap.get(i);

            List<String> list = new ArrayList<>(wordSet);
            
            Collections.sort(list);
            
            for (String s: list) {
                System.out.println(s);
            }

        }

    }
}