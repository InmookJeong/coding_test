package mook.programmers.level_1.recommend_new_id;

/**
 * Programmers Coding Test Level 1<br/>
 * 신규 아이디 추천 - 2021 KAKAO BLIND RECRUITMENT 
 * 
 * @author Dev.Mook
 * @since 2021.04.13
 */
public class RecommendNewID {

	public static void main(String[] args) {
		String id1 = "...!@BaT#*..y.abcdefghijklm";
		System.out.println("id1 : " + solution(id1));
		
		String id2 = "z-+.^.";
		System.out.println("id2 : " + solution(id2));
		
		String id3 = "=.=";
		System.out.println("id3 : " + solution(id3));
		
		String id4 = "123_.def";
		System.out.println("id4 : " + solution(id4));
		
		String id5 = "abcdefghijklmn.p";
		System.out.println("id5 : " + solution(id5));
	}
	
	/** 내가 생각한 Solution<br/><br/>
	 *  &emsp; 각 스텝 별 처리<br/>
	 * 
	 * @param new_id
	 * @return
	 */
	public static String solution(String new_id) {
		new_id = step1(new_id);
		new_id = step2(new_id);
		new_id = step3(new_id);
		new_id = step4(new_id);
		new_id = step5(new_id);
		new_id = step6(new_id);
		new_id = step7(new_id);
		
		return new_id;
	}
	
	/**
	 * Step 1. 대문자를 소문자로 변경
	 * 
	 * @param id
	 * @return
	 */
	public static String step1(String id) {
		return id.toLowerCase();
	}
	
	/**
	 * Step 2. 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 나머지 문자 제거
	 * 
	 * @param id
	 * @return
	 */
	public static String step2(String id) {
		String regex = "[^a-z0-9-_.]";
		return id.replaceAll(regex, "");
	}
	
	/**
	 * Step 3. 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환
	 * 
	 * @param id
	 * @return
	 */
	public static String step3(String id) {
		String regex = "[.]{2,}";
		return id.replaceAll(regex, ".");
	}
	
	/**
	 * Step 4. 마침표(.)가 처음이나 끝에 위치하면 제거
	 * 
	 * @param id
	 * @return
	 */
	public static String step4(String id) {
		String regex_f = "^[.]";
		String regex_l = "[.]$";
		id = id.replaceAll(regex_f, "");
		id = id.replaceAll(regex_l, "");
		return id;
	}
	
	/**
	 * Step 5. ID가 빈 문자열이면 "a" 대입
	 * 
	 * @param id
	 * @return
	 */
	public static String step5(String id) {
		if(id.equals(""))
			id = "a";
		
		return id;
	}
	
	// 
	/**
	 * Step 6. 길이 16자 이상이면 첫 15개의 문자를 제외한 나머지 문자 제거<br/>
	 * &emsp;이때 출력된 15자의 ID 중 마지막 문자가 마침표(.)이면 마침표를 제거
	 * 
	 * @param id
	 * @return
	 */
	public static String step6(String id) {
		if(id.length() > 15)
			id = id.substring(0, 15);
		
		// 제거한 후 끝이 마침표(.)면 마침표 제거
		return step4(id);
	}
	
	/**
	 * Step 7. 길이가 2 이하면 마지막 문자를 길이가 3이 될 때까지 반복해서 붙이기
	 * 
	 * @param id
	 * @return
	 */
	public static String step7(String id) {
		while(id.length() < 3) {
			String lastChar = id.substring(id.length()-1, id.length());
			id += lastChar;
		}
		return id;
	}
	
	/** 다른 프로그래머의 풀이 1<br/><br/>
	 * 
	 * @param new_id
	 * @return
	 */
	public String solution_other_poeple_a(String new_id) {
		String answer = "";
		String temp = new_id.toLowerCase();
		
		temp = temp.replaceAll("[^-_.a-z0-9]","");
		System.out.println(temp);
		temp = temp.replaceAll("[.]{2,}",".");
		temp = temp.replaceAll("^[.]|[.]$","");
		System.out.println(temp.length());
		if(temp.equals(""))
			temp+="a";
		if(temp.length() >=16){
			temp = temp.substring(0,15);
			temp=temp.replaceAll("^[.]|[.]$","");
		}
		if(temp.length()<=2)
			while(temp.length()<3)
				temp+=temp.charAt(temp.length()-1);
		
		answer=temp;
		return answer;
	}
	
	/** 다른 프로그래머의 풀이 2 : 객체 활용<br/><br/>
	 * 
	 * @param new_id
	 * @return
	 */
	public static String solution_other_poeple_b(String new_id) {

		String s = new KAKAOID(new_id)
				.replaceToLowerCase()
				.filter()
				.toSingleDot()
				.noStartEndDot()
				.noBlank()
				.noGreaterThan16()
				.noLessThan2()
				.getResult();
		
		return s;
	}

	private static class KAKAOID {
		private String s;
		
		KAKAOID(String s) {
			this.s = s;
		}
		
		private KAKAOID replaceToLowerCase() {
			s = s.toLowerCase();
			return this;
		}
		
		private KAKAOID filter() {
			s = s.replaceAll("[^a-z0-9._-]", "");
			return this;
		}
		
		private KAKAOID toSingleDot() {
			s = s.replaceAll("[.]{2,}", ".");
			return this;
		}
		
		private KAKAOID noStartEndDot() {
			s = s.replaceAll("^[.]|[.]$", "");
			return this;
		}
		
		private KAKAOID noBlank() {
			s = s.isEmpty() ? "a" : s;
			return this;
		}
		
		private KAKAOID noGreaterThan16() {
			if (s.length() >= 16) {
			    s = s.substring(0, 15);
			}
			s = s.replaceAll("[.]$", "");
			return this;
		}
		
		private KAKAOID noLessThan2() {
			StringBuilder sBuilder = new StringBuilder(s);
			while (sBuilder.length() <= 2) {
			    sBuilder.append(sBuilder.charAt(sBuilder.length() - 1));
			}
			s = sBuilder.toString();
			return this;
		}
		
		private String getResult() {
			return s;
		}
	}
}
