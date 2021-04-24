import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class 같은숫자는싫어 {
	public static int[] solution(int []arr) {
	    int[] answer;
	    
	    ArrayList<Integer> list = new ArrayList<Integer>();
	    
	    list.add(arr[0]);
	    
	    for(int i=0; i<arr.length-1; i++) {
	    	if(arr[i]!=arr[i+1]) {
	    		list.add(arr[i+1]);
	    	}
	    }
	    
	    answer = new int[list.size()];
	    
	    for(int i=0; i<list.size(); i++) {
	    	answer[i] = list.get(i);
	    }
	    
	    return answer;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,1,3,3,0,1,1};
		int[] arr2 = {4,4,4,3,3};
		
		System.out.println(Arrays.toString(solution(arr)));
		System.out.println(Arrays.toString(solution(arr2)));
	}
}

