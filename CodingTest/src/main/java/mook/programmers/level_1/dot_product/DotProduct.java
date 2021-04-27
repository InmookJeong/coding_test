package mook.programmers.level_1.dot_product;

/**
 * Programmers Coding Test Level 1<br/>
 * 내적 - 월간 코드 챌린지 시즌1
 * 
 * @author Dev.Mook
 * @since 2021.04.23
 */
public class DotProduct {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {1,2,3,4}, new int[] {-3,-1,0,2}));
		System.out.println(solution(new int[] {-1,0,1}, new int[] {1,0,-1}));
	}
	
	/** 내가 생각한 Solution<br/>
	 *  * 다른 사람 풀이도 동일
	 * 
	 * @param absolutes
	 * @param signs
	 * @return
	 */
	public static int solution(int[] a, int[] b) {
		int answer = 0;
		
		for(int i=0; i<a.length; i++) {
			answer += (a[i]*b[i]);
		}
		
		return answer;
	}
}
