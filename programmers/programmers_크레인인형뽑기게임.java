import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for(int m=0; m<moves.length; m++){ //moves[m]
            for(int i=0; i<board.length; i++){
                if(board[i][moves[m]-1]!=0){
                    System.out.println(board[i][moves[m]-1]);
                    if(!stack.empty() && stack.peek()==board[i][moves[m]-1]){
                        answer += 2;
                        stack.pop();
                    }else{
                        stack.push(board[i][moves[m]-1]);
                    }
                    board[i][moves[m]-1] = 0;
                    break;
                }
            }
        }

        return answer;
    }
}