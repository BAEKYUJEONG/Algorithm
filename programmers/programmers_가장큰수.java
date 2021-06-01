import java.util.Arrays;
import java.util.Comparator;

// 앞자리수를 다 빼내어서 정렬한다음, 
// 한자리수 일 경우 바로 붙이기, 두 자리 수 일 경우 그 뒤의 숫자들을 비교 36>31 이런 식으로 늘려나가서 순서대로 붙이기라는 생각

// 앞 수와 뒤 수를 붙여서 만들어 본 뒤, 더  큰 수를 배치
public class programmers_가장큰수 {
	public static String solution(int[] numbers) {

		// 숫자를 문자열로 변환
		String[] result = new String[numbers.length];
        
		for (int i = 0; i < numbers.length; i++) {
			result[i] = String.valueOf(numbers[i]);
		}

		// 정렬
		Arrays.sort(result, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return ((o2 + o1).compareTo(o1 + o2));
			}
		});

		// 0만 여러개 있는 배열의 경우 하나의 0만 리턴
		if(result[0].equals("0")) {
			return "0";
		}
		
		String answer = "";
		// 정렬된 문자 하나로 합치기
		for (String a : result) {
			answer += a;
		}
        
		return answer;
	}
	
	public static void main(String[] args) {
		int[] numbers = {6, 10, 2};
		
		System.out.println(solution(numbers));
	}
}
