import java.util.Scanner;

public class BOJ_2669_직사각형네개의합집합의면적구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean map[][] = new boolean[101][101];
		int cnt = 0;
		
		for(int i=0; i<4; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			for(int x=x1; x<x2; x++) {
				for(int y=y1; y<y2; y++) {
					map[y][x] = true;
				}
			}
		}
		
		for(int i=0; i<101; i++) {
			for(int j=0; j<101; j++) {
				if(map[j][i]==true) cnt++;
			}
		}
		
		System.out.println(cnt);
		
		sc.close();
	}
}