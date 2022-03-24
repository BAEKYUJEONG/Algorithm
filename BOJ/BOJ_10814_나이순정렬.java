import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());

        Map<Integer, ArrayList<String>> map = new HashMap<>();

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            ArrayList<String> list = map.getOrDefault(age, new ArrayList<>());

            list.add(name);
            map.put(age, list);
        }

        List<Integer> keylist = new ArrayList<>(map.keySet());
        Collections.sort(keylist);

        for(int k: keylist) {
            ArrayList<String> list = map.get(k);

            for(int i=0; i<list.size(); i++) {
                System.out.println(k+" "+list.get(i));
            }   
        }
    }
}