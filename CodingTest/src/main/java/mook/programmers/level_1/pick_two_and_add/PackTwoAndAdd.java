package mook.programmers.level_1.pick_two_and_add;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Programmers Coding Test Level 1<br/>
 * 두 개 뽑아서 더하기 - 월간 코드 챌린지 시즌1
 * 
 * @author Dev.Mook
 * @since 2021.04.09
 */
public class PackTwoAndAdd {

	public static void main(String[] args) {
		int[] numbers_1 = {2,1,3,4,1};
		int[] numbers_2 = {5,0,2,7};
		
		System.out.println("########## Solution ##########");
		System.out.print("numbers_1 : ");
		_print(solution(numbers_1));
		
		System.out.println();
		System.out.print("numbers_2 : ");
		_print(solution(numbers_2));
	}
	
	private static void _print(int[] numbers) {
		for(int a : numbers) {
			System.out.print(a + " ");
		}
	}
	
	/** 내가 생각한 Solution<br/><br/>
	 * 
	 *  &emsp; 1. List 생성<br/>
	 *  &emsp; 2. 이중 for문을 통해 두 개의 숫자 더하기<br/>
	 *  &emsp; 3. List에 더한 값이 없으면 List에 담기<br/>
	 *  &emsp; 4. List sort<br/>
	 *  &emsp; 5. List를 Array에 담기<br/>
	 *  
	 * @param numbers
	 * @return
	 */
	public static int[] solution(int[] numbers) {
		int[] answer = {};
		
		// Create Integer List
		List<Integer> answerList = new ArrayList<Integer>();
		for(int i=0; i<numbers.length-1; i++) {
			int n1 = numbers[i];
			for(int j=i+1; j<numbers.length; j++) {
				int n2 = numbers[j];
				
				int sum = n1 + n2;
				// Contain check
				if(!answerList.contains(sum)) {
					answerList.add(sum);
				}
			}
		}
		
		// Sort
		Collections.sort(answerList);
		answer = new int[answerList.size()];
		// List to Array
		for(int i=0; i<answerList.size(); i++) {
			answer[i] = answerList.get(i);
		}
		
		return answer;
	}
	
	/** 다른 프로그래머의 풀이 1 : HashSet 사용<br/>
	 *  Set의 파생클래스 - Set은 기본적으로 집합의 중복 원소를 허용하지 않음.<br/><br/>
	 *  
	 *  &emsp; 1. 이중 for문을 통해 두 개의 숫자 더하기<br/>
	 *  &emsp; 2. HashSet에 더한 값을 담기<br/>
	 *  &emsp; 3. HashSet에 담겨있는 값을 정렬(Sort)한 후 Array로 변경해서 반환<br/>
	 *  <br/>
	 *  * 가독성은 좋지만 속도면에서 느리다는 의견이 있음.
	 * 
	 * @param numbers
	 * @return
	 */
	public static int[] solution_other_poeple_a(int[] numbers) {
		// 저장 순서를 유지하지 않음.
		// 저장순서를 유지하고자 한다면 LinkedHaseSet 사용.
		Set<Integer> set = new HashSet<>();

		for(int i=0; i<numbers.length; i++) {
			for(int j=i+1; j<numbers.length; j++) {
				// 중복 값이 존재하면 false를 반환.
				set.add(numbers[i] + numbers[j]);
			}
		}
		
		// mapToInt : "1","2","3"을 가진 스트림을 1,2,3을 가진 스트림으로 변환
		return set.stream().sorted().mapToInt(Integer::intValue).toArray();
	}
	
	/** 다른 프로그래머의 풀이 2 : TreeSet 사용<br/>
	 * Set의 파생클래스 - Set은 기본적으로 집합의 중복 원소를 허용하지 않음.<br/>
	 * 이진 검색 트리(Bynary search tree) 자료구조의 형태로 데이터를 저장하는 컬렉션 클래스.<br/>
	 * &emsp; * 이전 검색 트리 : 정렬, 검색, 범위 검색에 높은 성능을 보이는 자료구조.<br/>
	 * 정렬된 위치에 저장, 저장 순서를 유지하지 않음.<br/><br/>
	 * 
	 *  &emsp; 1. 이중 for문을 통해 두 개의 숫자 더하기<br/>
	 *  &emsp; 2. TreeSet에 더한 값을 담기<br/>
	 *  &emsp; 3. Set에 담겨있는 값을 Array에 담기<br/>
	 *  <br/>
	 *  * 정렬되면서 저장되므로 HashSet보다 느리다는 단점이 있다. 
	 * 
	 * @param numbers
	 * @return
	 */
	public int[] solution_other_poeple_b(int[] numbers) {
		Set<Integer> sumNumber = new TreeSet();
		
		for(int i = 0; i < numbers.length-1; i++){
			for(int j = i+1; j < numbers.length; j++){
				sumNumber.add(numbers[i] + numbers[j]);
			}
		}
		
		int[] answer = new int[sumNumber.size()];
		int index = 0;
		Iterator itor = sumNumber.iterator();
		while(itor.hasNext()){
			answer[index] = (int)itor.next();
			index++;
		}
		
		return answer;
	}
	
	/** 다른 프로그래머의 풀이 3 : HashSet 사용<br/>
	 * Set의 파생클래스 - Set은 기본적으로 집합의 중복 원소를 허용하지 않음.<br/>
	 * 반환 타입을 변경할 수 있나보다.<br/>
	 * &emsp; * Programmers에서는 int[]로 반환.<br/><br/>
	 * 
	 *  &emsp; 1. List, HashSet 생성<br/>
	 *  &emsp; 2. 이중 for문을 통해 두 개의 숫자 더하기<br/>
	 *  &emsp; 3. HashSet에 더한 값을 담기<br/>
	 *  &emsp; 4. HashSet을 Iterator로 List에 담기<br/>
	 *  &emsp; 5. List 정렬(sort) 후 반환<br/>
	 * 
	 * @param numbers
	 * @return
	 */
	public static ArrayList<Integer> solution_other_poeple_c(int[] numbers) {
		ArrayList<Integer> answer = new ArrayList<>();
		HashSet<Integer> set = new HashSet<>();
		
		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				set.add(numbers[i] + numbers[j]);
			}
		}
		
		Iterator<Integer> iter = set.iterator();
		while(iter.hasNext()) {
			answer.add(iter.next());
		}
		
		Collections.sort(answer);
		return answer;
	}
}
