package mook.programmers.level_1.kth_number;

import java.util.Arrays;

/**
 * Programmers Coding Test Level 1<br/>
 * K번째수 - 정렬
 * 
 * @author Dev.Mook
 * @since 2021.04.14
 */
public class KthNumber {

	public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		
		int[] result = solution(array, commands);
		for(int r : result) {
			System.out.print(r + " ");
		}
	}
	
	/** 내가 생각한 Solution<br/><br/>
	 * 
	 * @param array
	 * @param commands
	 * @return
	 */
	public static int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		
		for(int i=0; i<commands.length; i++) {
			int start = commands[i][0] - 1;
			int end = commands[i][1];
			int k = commands[i][2] - 1;
			
			int[] copiedArray = Arrays.copyOfRange(array, start, end);
			Arrays.sort(copiedArray);
			
			answer[i] = copiedArray[k];
		}
		
		return answer;
	}
	
	/** 다른 프로그래머의 풀이 1<br/>
	 *  코드는 심플하지만 내가 작성한 코드와 동일한 프로세스.<br/>
	 * 
	 * @param array
	 * @param commands
	 * @return
	 */
	public static int[] solution_other_poeple_a(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		
		for(int i=0; i<commands.length; i++){
			int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
			Arrays.sort(temp);
			answer[i] = temp[commands[i][2]-1];
		}
		
		return answer;
	}
	
	/** 다른 프로그래머의 풀이 2<br/>
	 *  Arrays.sort 기능을 직접 구현<br/>
	 * 
	 * @param array
	 * @param commands
	 * @return
	 */
	public static int[] solution_other_poeple_b(int[] array, int[][] commands) {
		int n = 0;
		int[] ret = new int[commands.length];
		
		while(n < commands.length){
			int m = commands[n][1] - commands[n][0] + 1;
			
			if(m == 1){
				ret[n] = array[commands[n++][0]-1];
				continue;
			}
			
			int[] a = new int[m];
			int j = 0;
			for(int i = commands[n][0]-1; i < commands[n][1]; i++)
				a[j++] = array[i];
			
			sort(a, 0, m-1);
			
			ret[n] = a[commands[n++][2]-1];
		}
		
		return ret;
	}
	
	static void sort(int[] a, int left, int right){
		int pl = left;
		int pr = right;
		int x = a[(pl+pr)/2];
		
		do{
			while(a[pl] < x) pl++;
			while(a[pr] > x) pr--;
			if(pl <= pr){
				int temp = a[pl];
				a[pl] = a[pr];
				a[pr] = temp;
				pl++;
				pr--;
			}
		}while(pl <= pr);
		
		if(left < pr) sort(a, left, pr);
		if(right > pl) sort(a, pl, right);
	}
}
