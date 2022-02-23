import java.util.*;

class Solution {
    public boolean[][] paper;
    public int[] problem;
    public int[] answer;
    public int N;
    
    public int[] solution(String[] id_list, String[] report, int k) {
        
        N = id_list.length;
        paper = new boolean[N][N];
        problem = new int[N];
        answer = new int[N];
        
        for (int i=0; i<report.length; i++) {
            String[] name = report[i].split(" ");
            
            int a = -1;
            int b = -1;
            
            for (int j=0; j<N; j++) {
                if (name[0].equals(id_list[j])) a = j;
                if (name[1].equals(id_list[j])) b = j;
            }
            
            //problem[b]++;
            paper[a][b] = true;
        }
        
        for (int i=0; i<N; i++) { // 문제 대상 플러스하기 : 같은 사람은 한번만 할수 있어서 최종 boolean 값을 이용해야한다.
            for(int j=0; j<N; j++) {
                if (paper[j][i] == true) problem[i]++;
            }
        }
        
        for (int i=0; i<N; i++) {
            
            if (problem[i] >= k) { // 만약에 그 사람이 문제 대상이면
                for(int j=0; j<N; j++) { // 그 문제 대상을 신고한 사람에게 메일을 +1 올린다.
                    if (paper[j][i] == true) answer[j]++;
                }
            }
        }
        
        return answer;
    }
}