package mook.programmers.level_1.add_positive_and_negative_numbers;

/**
 * Programmers Coding Test Level 1<br/>
 * 음양 더하기 - 월간 코드 챌린지 시즌2
 * 
 * @author Dev.Mook
 * @since 2021.04.23
 */
public class AddPositiveAndNegativeNumbers {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {4,7,12}, new boolean[] {true,false,true}));
		System.out.println(solution(new int[] {1,2,3}, new boolean[] {false,false,true}));
	}
	
	/** 내가 생각한 Solution<br/>
	 * 
	 * @param absolutes
	 * @param signs
	 * @return
	 */
	public static int solution(int[] absolutes, boolean[] signs) {
		int answer = 0;
		for(int i=0; i<absolutes.length; i++) {
			int num = absolutes[i];
			if(!signs[i]) num *= -1;
			answer += num;
		}
		
		return answer;
	}
	
	/** 다른 프로그래머의 풀이 1<br/>
	 *  삼항연산자 사용
	 * 
	 * @param absolutes
	 * @param signs
	 * @return
	 */
	public int solution_1(int[] absolutes, boolean[] signs) {
		int answer = 0;
		for (int i=0; i<signs.length; i++)
			answer += absolutes[i] * (signs[i]? 1: -1);
		return answer;
	}
}
