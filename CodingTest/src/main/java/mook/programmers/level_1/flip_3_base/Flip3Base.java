package mook.programmers.level_1.flip_3_base;

/**
 * Programmers Coding Test Level 1<br/>
 * 3진법 뒤집기 - 월간 코드챌린지 시즌1
 * 
 * @author Dev.Mook
 * @since 2021.04.22
 */
public class Flip3Base {

	public static void main(String[] args) {
		System.out.println(solution(45));
		System.out.println(solution_1(125));
	}
	
	/** 내가 생각한 Solution<br/>
	 * 
	 * @param n
	 * @return
	 */
	public static int solution(int n) {
		int answer = 0;
		String reverse = "";
		
		while(n >= 3) {
			reverse += n%3;
			n = n/3;
		};
		reverse += n;
		System.out.println("reverse : "+reverse);
		
		for(int i=0; i<reverse.length(); i++) {
			int number = Character.getNumericValue(reverse.charAt(i));
			answer += number * (int)Math.pow(3, (reverse.length()-i-1));
		}
		
		return answer;
	}
	
	/** 다른 프로그래머의 풀이 1<br/>
	 * * Integer parseInt 이용<br/>
	 * a를 3진법을 이용해서 10진법으로 변환
	 * 
	 * @param n
	 * @return
	 */
	public static int solution_1(int n) {
		String a = "";
		
		while(n > 0){
			a = (n % 3) + a;
			n /= 3;
		}
		a = new StringBuilder(a).reverse().toString();
		
		return Integer.parseInt(a,3);
	}
	
	/**다른 프로그래머의 풀이 2<br/>
	 * * 반복문 역순으로 실행
	 * 
	 * @param n
	 * @return
	 */
	public static int solution_2(int n) {
		int answer = 0;
		String third = Integer.toString(n, 3);
		StringBuffer sb = new StringBuffer(third);
		String reversed = sb.reverse().toString();
		
		int exp = 0;
		for (int i = reversed.length() - 1; i >= 0; i--) {
			answer += Integer.parseInt(String.valueOf(reversed.charAt(i))) * Math.pow(3, exp);
			exp++;
		}
		
		return answer;
	}
}
