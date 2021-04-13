package mook.programmers.level_1.a_player_who_could_not_finish;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Programmers Coding Test Level 1<br/>
 * 완주하지 못한 선수 - 해시
 * 
 * @author Dev.Mook
 * @since 2021.04.12
 */
public class APlayerWhoCouldNotFinish {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/** 내가 생각한 Solution<br/><br/>
	 * 
	 *  &emsp; 1. Array 정렬<br/>
	 *  &emsp; 2. 같은 Index의 값 비교<br/>
	 *  &emsp;&emsp; 2-1. 값이 같을 경우 다음 Index 비교<br/>
	 *  &emsp;&emsp; 2-2. 값이 다를 경우 반복문 정지<br/>
	 *  &emsp; 3. 결과 값 반환<br/>
	 * 
	 * @param participant
	 * @param completion
	 * @return
	 */
	public static String solution(String[] participant, String[] completion) {
		String answer = "";
		
		Arrays.sort(participant);
		Arrays.sort(completion);
		
		for(int i=0; i<participant.length; i++) {
			if(i == completion.length) {
				return participant[i];
			} else {
				if(!participant[i].equals(completion[i])) {
					return participant[i];
				}
			}
		}
		
		return answer;
	}
	
	/** 다른 프로그래머의 풀이 1 : HashMap 사용<br/><br/>
	 * 
	 *  &emsp; 1. 참가자 명단을 HashMap에 담기<br/>
	 *  &emsp;&emsp; 1-1. HashMap에 담을 때 Key : 참가자 이름, Value는 1로 담기<br/>
	 *  &emsp; 2. 완주자 명단을 HashMap에 담기<br/>
	 *  &emsp;&emsp; 2-1. 참가자 명단과 중복되는 이름이 있으므로, 완주한 사람의 Value는 기존 입력된 값에 -1을 하기<br/>
	 *  &emsp; 3. HashMap을 keyset으로 반복문 실행<br/>
	 *  &emsp;&emsp; 3-1. Value 값을 꺼냈을 때 0이면 완주자, 아니면 완주자가 아니므로 0이 아닌 사람의 이름을 answer에 담기<br/>
	 *  &emsp; 4. 완주하지 못한 사람의 이름을 반환<br/>
	 * 
	 * @param participant
	 * @param completion
	 * @return
	 */
	public static String solution_other_poeple_a(String[] participant, String[] completion) {
		String answer = "";
		HashMap<String, Integer> hm = new HashMap<>();
		for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
		for (String player : completion) hm.put(player, hm.get(player) - 1);
		
		for (String key : hm.keySet()) {
			if (hm.get(key) != 0){
				answer = key;
			}
		}
		return answer;
	}
	
	/** 다른 프로그래머의 풀이 2 : HashMap, Collectors, Function 사용<br/><br/>
	 * 
	 *  &emsp; 1. 참가자 명단을 Stream을 통해 Map에 담기<br/>
	 *  &emsp;&emsp; 1-1. Collectors.groupingBy를 통해 (참가자 명단, 참가자 수) 형태로 Group By 해주기.<br/>
	 *  &emsp;&emsp; 1-2. stream().collect로 '1-1'에서 작성되는 값을 Map으로 만들기<br/>
	 *  &emsp; 2. 완주자 명단 반복문 실행하기<br/>
	 *  &emsp;&emsp; 2-1. 완주자 이름을 통해 '1' 과정을 통해 생성된 Map에서 값 꺼내면서 카운트를 -1해주기<br/>
	 *  &emsp;&emsp;&emsp; 2-1-1. '2-1'에서 꺼낸 값이 0이면 완주자이므로 참가자 명단에서 완주자 이름 지우기<br/>
	 *  &emsp;&emsp;&emsp; 2-1-2. '2-1'에서 꺼낸 값이 0이 아니면 완주자가 아니므로 참가자 명단에 값을 다시 담기.<br/>
	 *  &emsp; 3. 남은 참가자 명단 값을 반환<br/>
	 * 
	 * @param participant
	 * @param completion
	 * @return
	 */
	public static String solution_other_poeple_b(String[] participant, String[] completion) {
		Map<String, Long> participantMap = Arrays.asList(participant).stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		for(String name : completion) {
		
			Long value = participantMap.get(name) - 1L;
		
			if(value == 0L) {
				participantMap.remove(name);
			} else {
				participantMap.put(name, value);
			}
		}
		
		return participantMap.keySet().iterator().next();
	}
	
	/** 다른 프로그래머의 풀이 3 : HashSet 사용<br/><br/>
	 * &emsp; 내가 작성한 코드랑 별 차이 없음.<br/>
	 * 
	 * @param participant
	 * @param completion
	 * @return
	 */
	public static String solution_other_poeple_c(String[] participant, String[] completion) {
		Arrays.sort(participant);
		Arrays.sort(completion);
		for(int i=0; i<completion.length; i++){
			if(!participant[i].equals(completion[i])) {
				return participant[i];
			}
		}
		return participant[participant.length-1];
	}
}
