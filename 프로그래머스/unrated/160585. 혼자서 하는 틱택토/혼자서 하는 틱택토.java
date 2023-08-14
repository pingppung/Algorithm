import java.util.*;
class Solution {
    static String[][] map = new String[3][3];
    public int solution(String[] board) {
        int oCnt = 0;
        int xCnt = 0;
        
        for(int i = 0; i < 3; i++){
            String[] arr = board[i].split("");
            for(int j = 0; j < 3; j++){
                map[i][j] = arr[j];
                if(map[i][j].equals("O")) oCnt++;
                if(map[i][j].equals("X")) xCnt++;
            }
        }
        if(oCnt < xCnt || oCnt - xCnt > 1) return 0;
        if(check("O") && xCnt +1 != oCnt) return 0;
        if(check("X") && oCnt != xCnt) return 0; 
        
        return 1;
    }
    public boolean check(String turn){
        for(int i = 0; i < 3; i++){
            if(map[i][0].equals(turn) && map[i][1].equals(turn) && map[i][2].equals(turn)) //가로
                return true;
            if (map[0][i].equals(turn) && map[1][i].equals(turn) && map[2][i].equals(turn)) //세로
                return true;
            
        }
        if (map[0][0].equals(turn) && map[1][1].equals(turn) && map[2][2].equals(turn)) // \대각선
            return true;
        if (map[2][0].equals(turn) && map[1][1].equals(turn) && map[0][2].equals(turn)) // /대각선
            return true;
        
        return false;
        
    }
}