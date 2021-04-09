package mook.programmers.level_1.crane_doll_draw_game;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Programmers Coding Test Level 1<br/>
 * 크레인 인형뽑기 게임
 * 
 * @author Dev.Mook
 * @since 2021.04.09
 */
public class CraneDollDrawGame {
	
	public static void main(String[] args) {
		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		System.out.println("result : " + solution(board, moves));
	}
	
	/** 내가 생각한 Solution<br/><br/>
	 * 
	 *  &emsp; 1. List 생성<br/>
	 *  &emsp; 2. board[x][move-1] 값 검색<br/>
	 *  &emsp; 3. 값이 0이 아닌경우<br/>
	 *  &emsp;&emsp; 3-1. List에 아무것도 안담겨 있으면 값 담기<br/>
	 *  &emsp;&emsp; 3-2. List에 값이 존재하는 경우<br/>
	 *  &emsp;&emsp;&emsp; 3-2-1. List에 담긴 마지막 값과 3.에서 꺼낸 값이 같은 경우 List의 마지막 값 제거 후 사라진 인형 수에 +2<br/>
	 *  &emsp;&emsp;&emsp; 3-2-2. List에 담긴 마지막 값과 3.에서 꺼낸 값이 다른 경우 List 값 담기<br/>
	 * 
	 * @param board
	 * @param moves
	 * @return
	 */
	public static int solution(int[][] board, int[] moves) {
		int answer = 0;
		
		List<Integer> stackList = new ArrayList<Integer>();
		move : for(int move : moves) {
			for(int x=0; x<board.length; x++) {
				int dollValue = board[x][move-1];
				if(dollValue != 0) {
					if(stackList.isEmpty()) {
						stackList.add(dollValue);
					} else {
						int topIndex = stackList.size()-1;
						if(stackList.get(topIndex) != dollValue) {
							stackList.add(dollValue);
						} else {
							stackList.remove(topIndex);
							answer += 2;
						}
					}
					
					board[x][move-1] = 0;
					continue move;
				}
			}
		}
		return answer;
	}
	
	/** 다른 프로그래머의 풀이 : Stack 사용<br/>
	 * 
	 *  &emsp; 1. Stack 생성<br/>
	 *  &emsp; 2. board[j][move-1] 값 검색<br/>
	 *  &emsp; 3. 값이 0이 아닌경우<br/>
	 *  &emsp;&emsp; 3-1. Stack이 비어있는 경우 값 담기<br/>
	 *  &emsp;&emsp; 3-2. Stack이 비어있지 않은 경우<br/>
	 *  &emsp;&emsp;&emsp; 3-2-1. Stack에 최근 추가된 값이 3.에서 꺼낸 값과 같은 경우 Stack에서 제거 후 사라진 인형 수에 +2<br/>
	 *  &emsp;&emsp;&emsp; 3-2-1. Stack에 최근 추가된 값이 3.에서 꺼낸 값과 다른 경우 Stack에 값 담기<br/>
	 * 
	 * @param board
	 * @param moves
	 * @return
	 */
	public int solution_other_poeple(int[][] board, int[] moves) {
		int answer = 0;
		Stack<Integer> stack = new Stack<>();
		for (int move : moves) {
			for (int j = 0; j < board.length; j++) {
				if (board[j][move - 1] != 0) {
					if (stack.isEmpty()) {
						stack.push(board[j][move - 1]);
						board[j][move - 1] = 0;
						break;
					}
					
					// stack.peak() : 최근 추가된(Top) 데이터 조회
					if (board[j][move - 1] == stack.peek()) {
						stack.pop();
						answer += 2;
					} else {
						stack.push(board[j][move - 1]);
					}
					
					board[j][move - 1] = 0;
					break;
				}
			}
		}
		return answer;
	}
	
}