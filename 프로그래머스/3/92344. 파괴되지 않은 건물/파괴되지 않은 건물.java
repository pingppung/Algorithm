import java.util.*;
class Solution {
    int n, m;
    int[][] attack, recovery;
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        n = board.length;
        m = board[0].length;
        attack = new int[n+1][m+1];
        recovery = new int[n+1][m+1];
        for(int[] s : skill){
            if(s[0] == 1) calSkill(attack, s[1], s[2], s[3], s[4], s[5]);  //공격
            else calSkill(recovery, s[1], s[2], s[3], s[4], s[5]);  //회복
        }
        calDura();
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++){
                board[i][j] += recovery[i][j] - attack[i][j];
                if(board[i][j] > 0) answer++;
            }
        }
        return answer;
    }
    private void calSkill(int[][] dura, int r1, int c1, int r2, int c2, int degree){
        dura[r1][c1] += degree;
        if(r2 + 1 < dura.length) dura[r2+1][c1] -= degree;
        if(c2 + 1 < dura[0].length) dura[r1][c2+1] -= degree;
        if(r2 + 1 < dura.length && c2 + 1 < dura[0].length) dura[r2+1][c2+1] += degree;
    }
    private void calDura(){
        for(int i = 0; i < n; i++) {
            for(int j = 1; j < m; j++){
                attack[i][j] += attack[i][j-1];
                recovery[i][j] += recovery[i][j-1];
                
            }
        }
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < m; j++){
                attack[i][j] += attack[i-1][j];
                recovery[i][j] += recovery[i-1][j];
            }
        }
    }
}