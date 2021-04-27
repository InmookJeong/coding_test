package mook.programmers.level_1.making_prime_number;

/**
 * Programmers Coding Test Level 1<br/>
 * 소수 만들기 - Summer/Winter Coding(~2018)
 * 
 * @author Dev.Mook
 * @since 2021.04.23
 */
public class MakingPrimeNumber {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{1,2,3,4}));
		System.out.println(solution(new int[]{1,2,7,6,4}));
	}
	
	/** 내가 생각한 Solution<br/>
	 *  * 다른사람들의 코드가 나와 거의 비슷해서 참고될 만한 소스코드를 찾지 못함.
	 * 
	 * @param nums
	 * @return
	 * @since 2021. 04. 26
	 */
	public static int solution(int[] nums) {
		int answer = 0;
		
		for(int i=0; i<nums.length-2; i++) {
			for(int j=i+1; j<nums.length-1; j++) {
				for(int k=j+1; k<nums.length; k++) {
					int sum = nums[i] + nums[j] + nums[k];
					boolean isSosu = true;
					for(int x=2; x<sum; x++) {
						if(sum%x == 0) isSosu = false;
					}
					if(isSosu) answer+=1;
				}
			}
		}
		
		return answer;
	}
}
