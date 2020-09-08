import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw2382 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st; 
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			System.out.print("#"+tc+" ");
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			Cell(N,M,K);
		}
	}

	private static void Cell(int N, int M, int K) throws IOException {
		st = new StringTokenizer(br.readLine());
		
		cellSquare area[][] = new cellSquare[N][N];
		cellSquare narea[][] = new cellSquare[N][N];
		//새 area에 입력 시키고 area에 옮긴 뒤 narea 초기화
		
		//테두리에 약품 바르기
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(i==0 || i==N || j==0 || j==N) {
					area[i][j] = new cellSquare(-1,-1);
				}
			}
		}
		
		//군집 입력 받기
		for(int i=0; i<K; i++) {
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int move = Integer.parseInt(st.nextToken());
			//(상: 1, 하: 2, 좌: 3, 우: 4)
			
			area[r][c] = new cellSquare(n, move);
		}
		
		//시간
		for(int i=0; i<M; i++) {
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(area[r][c].n!=0 && area[r][c].move!=0
					&& area[r][c].n!=-1 && area[r][c].move!=-1) {
						//빈칸, 테두리가 아닐 때
						switch (area[r][c].move) {
						case 1:
							narea[r-1][c] = area[r][c];
							break;
						case 2:
							narea[r+1][c] = area[r][c];
							break;
						case 3:
							narea[r][c-1] = area[r][c];
							break;
						case 4:
							narea[r][c+1] = area[r][c];
							break;
						default:
							break;
						}
					}
				}
			}
		}
		
	}
}

class cellSquare {
	int n;
	int move;
	public cellSquare(int n, int move) {
		this.n = n;
		this.move = move;
	}
}
