class Solution {

    public static boolean[][] map;

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        map = new boolean[n][n];

        check(arr1, n);
        check(arr2, n);

        for (int i=0; i<n; i++) {
            String str = "";
            for (int j=0; j<n; j++) {
                if (map[i][j] == true) str += "#";
                else str += " ";
            }
            answer[i] = str;
        }

        return answer;
    }

    public void check(int[] arr, int n) {
        for (int i=0; i<n; i++) {
            String strNum = Integer.toBinaryString(arr[i]);

            while (strNum.length() < n) strNum = "0"+strNum;

            String[] arrNum = strNum.split("");
            for (int j=0; j<n; j++) {
                if (arrNum[j].equals("1")) {
                    map[i][j] = true;
                }
            }
        }
    }
}