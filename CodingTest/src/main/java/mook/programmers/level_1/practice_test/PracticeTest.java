package mook.programmers.level_1.practice_test;

import java.util.ArrayList;
import java.util.List;

/**
 * Programmers Coding Test Level 1<br/>
 * 모의고사 - 완전탐색
 * 
 * @author Dev.Mook
 * @since 2021.04.13
 */
public class PracticeTest {

	public static void main(String[] args) {
		int[] answers_1 = {1,2,3,4,5};
		int[] answers_2 = {1,3,2,4,2};
		solution(answers_1);
		solution(answers_2);
	}
	
	/** 내가 생각한 Solution<br/><br/>
	 * 
	 * * Math 클래스를 활용하는 방법 학습 필요.
	 * 
	 * @param answers
	 * @return
	 */
	public static int[] solution(int[] answers) {
		int[] answer = {};
		
		int[] supo1 = {1,2,3,4,5};
		int[] supo2 = {2,1,2,3,2,4,2,5};
		int[] supo3 = {3,3,1,1,2,2,4,4,5,5};
		
		int max = 0;
		int successCnt = 0;
		List<Integer> mList = new ArrayList<Integer>();
		for(int i=0; i<answers.length; i++) {
			int index = i % supo1.length ;
			if(answers[i] == supo1[index]) {
				successCnt += 1;
			}
		}
		if(max < successCnt) {
			max = successCnt;
			mList.clear();
			mList.add(1);
		}
		
		successCnt = 0;
		for(int i=0; i<answers.length; i++) {
			int index = i % supo2.length ;
			if(answers[i] == supo2[index]) {
				successCnt += 1;
			}
		}
		if(max < successCnt) {
			max = successCnt;
			mList.clear();
			mList.add(2);
		} else if(max == successCnt) {
			mList.add(2);
		}
		
		successCnt = 0;
		for(int i=0; i<answers.length; i++) {
			int index = i % supo3.length ;
			if(answers[i] == supo3[index]) {
				successCnt += 1;
			}
		}
		if(max < successCnt) {
			max = successCnt;
			mList.clear();
			mList.add(3);
		} else if(max == successCnt) {
			mList.add(3);
		}
		
		answer = new int[mList.size()];
		for(int i=0; i<mList.size(); i++) {
			answer[i] = mList.get(i);
		}
		
		return answer;
	}
	
	/** 다른 프로그래머의 풀이 1 : <br/>
	 *  Math.max 함수 활용<br/>
	 *  가독성은 좋지만 속도면에서 느리다는 의견이 있음.<br/>
	 *  JDK 8 문법 활용.<br/><br/>
	 * 
	 * @param answers
	 * @return
	 */
	public static int[] solution_other_poeple_a(int[] answers) {
		int[] a = {1, 2, 3, 4, 5};
		int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
		int[] score = new int[3];
		for(int i=0; i<answers.length; i++) {
			if(answers[i] == a[i%a.length]) {score[0]++;}
			if(answers[i] == b[i%b.length]) {score[1]++;}
			if(answers[i] == c[i%c.length]) {score[2]++;}
		}
		int maxScore = Math.max(score[0], Math.max(score[1], score[2]));
		ArrayList<Integer> list = new ArrayList<>();
		if(maxScore == score[0]) {list.add(1);}
		if(maxScore == score[1]) {list.add(2);}
		if(maxScore == score[2]) {list.add(3);}
		return list.stream().mapToInt(i->i.intValue()).toArray();
	}
	
	/** 다른 프로그래머의 풀이 2 : 이차원배열 사용<br/>
	 *  Math.max 함수 활용<br/>
	 * 
	 * @param answers
	 * @return
	 */
	public static int[] solution_other_poeple_b(int[] answers) {
		int[][] patterns = {
			{1, 2, 3, 4, 5},
			{2, 1, 2, 3, 2, 4, 2, 5},
			{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
		};
		
		int[] hit = new int[3];
		for(int i = 0; i < hit.length; i++) {
			for(int j = 0; j < answers.length; j++) {
				if(patterns[i][j % patterns[i].length] == answers[j]) hit[i]++;
			}
		}
		
		int max = Math.max(hit[0], Math.max(hit[1], hit[2]));
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < hit.length; i++)
			if(max == hit[i]) list.add(i + 1);
		
		int[] answer = new int[list.size()];
		int cnt = 0;
		for(int num : list)
			answer[cnt++] = num;
		return answer;
	}
}
