package mook.programmers.level_1.sports_wear;

import java.util.HashSet;

/**
 * Programmers Coding Test Level 1<br/>
 * 체육복 - 탐욕법(Greedy)
 * 
 * @author Dev.Mook
 * @since 2021.04.15
 */
public class SportsWear {

	public static void main(String[] args) {
		
		int n1 = 5; int[] lost1 =  {2, 4}; int[] reserve1 = {1,3,5};
		int n2 = 5; int[] lost2 =  {2, 4}; int[] reserve2 = {3};
		int n3 = 3; int[] lost3 =  {3}; int[] reserve3 = {1};
		
		System.out.println(solution(n1, lost1, reserve1));
		System.out.println(solution(n2, lost2, reserve2));
		System.out.println(solution(n3, lost3, reserve3));
	}
	
	/** 내가 생각한 Solution<br/>
	 *  &emsp; n : 전체 학생 수<br/>
	 *  &emsp; lost : 체육복을 잃어버린 학생<br/>
	 *  &emsp; reserve : 여벌의 체육복을 가지고 있는 학생<br/><br/>
	 *  
	 *  &emsp; 1. 체육복 여벌을 가지고 있지만 체육복을 도둑맞은 학생 제외하기<br/>
	 *  &emsp; 2. 체육복을 도둑맞은 학생 중 앞번호 또는 뒷번호 학생이 체육복을 가지고 있는지 확인하기<br/>
	 *  &emsp; 3. 가지고 있으면 해당 학생에게 체육복을 빌리기(answer+=1)
	 *  &emsp; 4. 체육복을 빌려준 학생은 더이상 체육복을 빌려줄 수 없도록 reserve 목록에서 제외하기<br/>
	 * 
	 * @param n
	 * @param lost
	 * @param reserve
	 * @return
	 */
	public static int solution(int n, int[] lost, int[] reserve) {
		int answer = n-lost.length;
		
		// 잃어버린 사람이 한번 더 가지고 있는지 체크
		for(int i=0; i<reserve.length; i++) {
			int r = reserve[i];
			for(int j=0; j<lost.length; j++) {
				int l = lost[j];
				if(r == l) {
					if(answer < n) answer += 1;
					reserve[i] = 0;
					lost[j] = 0;
				}
			}
		}
		
		lostLoop :for(int l : lost) {
			if(l == 0) continue;
			for(int i=0; i<reserve.length; i++) {
				int r = reserve[i];
				if(r == 0) continue; 
				if(l-1 == r || l+1 == r) {
					if(answer < n) answer += 1;
					reserve[i] = 0;
					continue lostLoop;
				}
			}
		}
		
		return answer;
	}
	
	/** 다른 프로그래머의 풀이 1<br/><br/>
	 * 
	 *  &emsp; 1. 체육복을 잃어버린 학생은 -1, 여벌의 체육복을 가지고 있는 학생은 1로 값 설정<br/>
	 *  &emsp; 2. 체육복을 앞번호 또는 뒷번호 학생에게 빌리기<br/>
	 *  &emsp; 3. 빌리지 못한 학생은 수업을 참여할 수 있는 학생 수(answer)에서 제외하기<br/>
	 *  
	 * @param n
	 * @param lost
	 * @param reserve
	 * @return
	 */
	public int solution_other_poeple_a(int n, int[] lost, int[] reserve) {
		int[] people = new int[n];
		int answer = n;
		
		for (int l : lost) 
			people[l-1]--;
		for (int r : reserve) 
			people[r-1]++;
		
		for (int i = 0; i < people.length; i++) {
			if(people[i] == -1) {
				if(i-1>=0 && people[i-1] == 1) {
					people[i]++;
					people[i-1]--;
				}else if(i+1< people.length && people[i+1] == 1) {
					people[i]++;
					people[i+1]--;
				}else 
					answer--;
			}
		}
		return answer;
	}
	
	/** 다른 프로그래머의 풀이 2 : while 사용<br/><br/>
	 * 
	 * @param n
	 * @param lost
	 * @param reserve
	 * @return
	 */
	public int solution_other_poeple_b(int n, int[] lost, int[] reserve) {
		int answer = 0;
		answer = n;
		
		for(int i = 0; i < lost.length; i++) {
			boolean rent = false;
			int j = 0;
			while(!rent) {
				if(j == reserve.length)					break;
				if(lost[i] == reserve[j])				{reserve[j] = -1; rent=true;}
				else if(lost[i] - reserve[j] == 1 )		{reserve[j] = -1; rent=true;}
				else if(lost[i] - reserve[j] == -1)		{reserve[j] = -1; rent=true;}
				else									{j++;}
			}
			if(!rent) answer--;
		}
		return answer;
	}
	
	/** 다른 프로그래머의 풀이 3 : HashSet 사용<br/><br/>
	 * 
	 * @param n
	 * @param lost
	 * @param reserve
	 * @return
	 */
	public int solution_other_poeple_c(int n, int[] lost, int[] reserve) {
		int answer = n;
		HashSet<Integer> resList = new HashSet<>();
		HashSet<Integer> losList = new HashSet<>();
		
		for (int i : reserve)
			resList.add(i);
		for (int i : lost) {
			if(resList.contains(i))
				resList.remove(i);
			else
				losList.add(i);
		}
		for (int i : lost) {
			if(losList.contains(i)) {
				if(resList.contains(i-1))
					resList.remove(i-1);
				else if(resList.contains(i+1))
					resList.remove(i+1);
				else
					answer--;
			}
		}
		return answer;
	}
}
