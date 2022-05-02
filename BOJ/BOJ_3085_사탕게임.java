import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, maximum;
    static char[][] candy;

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        maximum = 0;
        candy = new char[N][N];

        for (int i=0; i<N; i++) {
            String line = br.readLine();
            char[] arr = line.toCharArray();
            for (int j=0; j<N; j++) {
                candy[i][j] = arr[j];
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                // 위 아래 같지 않은 경우
                if (i+1 < N && candy[i][j] != candy[i+1][j]) {
                    find(i, j, i+1, j);
                }

                // 왼쪽 오른쪽 같지 않은 경우
                if (j+1 < N && candy[i][j] != candy[i][j+1]) {
                    find(i, j, i, j+1);
                }
            }
        }

        System.out.println(maximum);
	}

    // 행과 열만 찾으면 된다
    public static void find(int x, int y, int r, int c) {
        char[][] ncandy = new char[N][N];

        for(int i=0; i<N; i++){
            System.arraycopy(candy[i], 0, ncandy[i], 0, N);
        }

        char tmp = ncandy[x][y];
        ncandy[x][y] = ncandy[r][c];
        ncandy[r][c] = tmp;

        for (int i=0; i<N; i++) {
            int rmax = 1;
            int cmax = 1;
            for (int j=0; j<N-1; j++) {
                // 행
                if (ncandy[i][j] == ncandy[i][j+1]) {
                    ++rmax;
                    maximum = Math.max(rmax, maximum);
                } else {
                    rmax = 1;
                }

                // 열
                if (ncandy[j][i] == ncandy[j+1][i]) {
                    ++cmax;
                    maximum = Math.max(cmax, maximum);
                } else {
                    cmax = 1;
                }
            }
        }
    }
}