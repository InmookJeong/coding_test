package mook.programmers.level_1.i_hate_the_same_number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Programmers Coding Test Level 1<br/>
 * 가운데 글짜 가져오기
 * 
 * @author Dev.Mook
 * @since 2021.04.21
 */
public class I_HateTheSameNumber {

	public static void main(String[] args) {
		int[] arr_1 = {1,1,3,3,0,1,1};
		int[] arr_2 = {4,4,4,3,3};
		
		System.out.println("arr_1 : " + solution(arr_1));
		System.out.println("arr_2 : " + solution(arr_2));
	}
	
	/** 내가 생각한 Solution<br/>
	 * &emsp; 다른 사람들도 비슷하게 작성<br/>
	 * 
	 * @param arr
	 * @return
	 */
	public static int[] solution(int []arr) {
		int[] answer = {};
		
		List<Integer> numberList = new ArrayList<Integer>();
		for(int number : arr) {
			if(numberList.size() == 0
				|| numberList.get(numberList.size()-1) != number) {
				numberList.add(number);
			}
		}
		
		answer = new int[numberList.size()];
		for(int i=0; i<numberList.size(); i++) {
			answer[i] = numberList.get(i);
		}
		
		return answer;
	}
	
	/** 다른 프로그래머의 풀이 1 : Stream 사용<br/>
	 * &emsp; 리스트에서 배열로 값 넣는게 더 빠르다는 의견 있음<br/>
	 * 
	 * @param arr
	 * @return
	 */
	public static int[] solution_1(int []arr) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(arr[0]);
		for(int i=1; i<arr.length;i++){
			if(arr[i]!=list.getLast()){
				list.add(arr[i]);
			}
		}
		
		Integer[] listing = list.toArray(new Integer[list.size()]);
		int []answer =Arrays.stream(listing).mapToInt(Integer::intValue).toArray();
		return answer;
	}
}
