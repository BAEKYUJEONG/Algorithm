import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Queue<Point> queue = new LinkedList<>();
    static HashMap<Long, Long> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long count = 1;

        queue.add(new Point(A, 1));
        map.put(A, (long)1);

        bfs(B);

        if (!map.containsKey(B)) System.out.println(-1);
        else System.out.println(map.get(B));
	}

    public static void bfs(long target) {
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            long n = p.x;
            long cnt = p.y;
            
            long two = 2*n;
            long one = 10*n + 1;

            if (two <= target && !map.containsKey(two)) {
                queue.add(new Point(two, cnt+1));
                map.put(two, cnt+1);
            }

            if (one <= target && !map.containsKey(one)) {
                queue.add(new Point(one, cnt+1));
                map.put(one, cnt+1);
            }
        }
    }

    public static class Point {
        long x;
        long y;

        Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
}