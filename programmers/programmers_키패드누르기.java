class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int[][] position = { { 3, 1 }, { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 0 }, { 1, 1 }, { 1, 2 }, { 2, 0 }, { 2, 1 }, { 2, 2 } };
        int[] left = { 3, 0 };
        int[] right = { 3, 2 };
        
        for(int num : numbers){
            int left_length = Math.abs(left[0] - position[num][0]) + Math.abs(left[1] - position[num][1]);
            int right_length = Math.abs(right[0] - position[num][0]) + Math.abs(right[1] - position[num][1]);
            
            if(num==1 || num==4 || num==7){
                answer += "L";
                left[0] = position[num][0];
                left[1] = position[num][1];
            }else if(num==3 || num==6 || num==9){
                answer += "R";
                right[0] = position[num][0];
                right[1] = position[num][1];
            }else{ // 2, 5, 8, 0
                if(left_length < right_length){
                    answer += "L";
                    left[0] = position[num][0];
                    left[1] = position[num][1];
                }else if(left_length > right_length){
                    answer += "R";
                    right[0] = position[num][0];
                    right[1] = position[num][1];
                }else{ // 길이가 같을 때
                    if(hand.equals("left")){
                        answer += "L";
                        left[0] = position[num][0];
                        left[1] = position[num][1];
                    }else{
                        answer += "R";
                        right[0] = position[num][0];
                        right[1] = position[num][1];
                    }
                }
            }
        }
        
        return answer;
    }
}