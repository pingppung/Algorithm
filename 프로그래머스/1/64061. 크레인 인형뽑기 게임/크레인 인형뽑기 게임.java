import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int n = board.length;
        Stack<Integer> basket = new Stack<>();
        for(int move : moves){
            for(int i = 0; i < n; i++){
                if(board[i][move-1] != 0){
                    if(!basket.isEmpty() && basket.peek() == board[i][move-1]) {
                        answer+=2;
                        basket.pop();
                    }
                    else {
                        basket.add(board[i][move-1]);
                    }
                    board[i][move-1] = 0;
                    break;
                }
            }
        }
        for(int i = 0; i < basket.size(); i++){
            System.out.println(basket.get(i));
        }
        return answer;
    }
}
