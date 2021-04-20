package mook.programmers.level_1.get_the_middle_character;

/**
 * Programmers Coding Test Level 1<br/>
 * 가운데 글짜 가져오기
 * 
 * @author Dev.Mook
 * @since 2021.04.20
 */
public class GetTheMiddleCharacter {

	public static void main(String[] args) {
		solution("abcde");
		solution("qwer");
	}
	
	/** 내가 생각한 Solution<br/>
	 * 
	 * @param s
	 * @return
	 */
	public static String solution(String s) {
		String answer = "";
		int middleIndex = s.length() / 2;
		boolean isOddNum = (s.length() % 2 == 1);
		
		if(isOddNum) {
			answer = s.charAt(middleIndex)+"";
		} else {
			answer = s.substring(middleIndex-1, middleIndex+1);
		}
		
		System.out.println(answer);
		return answer;
	}
	
	/** 다른 프로그래머의 풀이 1<br/>
	 *  * 0일때 오류가 발생한다는 의견 존재 - if 처리 필요
	 * 
	 * @param s
	 * @return
	 */
	public static String solution_1(String s) {
		// 방법 1
		return s.substring((s.length()-1) / 2, s.length()/2 + 1);
		
		// 방법 2
//		return s != null ? s.substring((s.length()-1)/2,(s.length()+2)/2) : "";
	}
	
	/** 다른 프로그래머의 풀이 2<br/>
	 * 
	 * @param s
	 * @return
	 */
	public static String solution_2(String s) {
		int a = s.length();
		String word1;
		if ( a % 2 == 0 )
			word1 = s.substring(a/2 - 1, (a/2) + 1);
		else
			word1 = s.substring((a/2), (a/2) + 1);
		return word1;
	}
}
