import java.util.*;
class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] map = new int[rows+1][columns+1];
        for(int i = 1; i <= rows; i++){
            for(int j = 1; j <= columns; j++){
                map[i][j] = j + (i-1) * columns;
            }
        }
        for(int i = 0; i < queries.length; i++){
            answer[i] = rotate(map, queries[i][0], queries[i][1], queries[i][2], queries[i][3]);
        }
        return answer;
    }
    private static int rotate(int[][] map, int x1, int y1, int x2, int y2){
        int[][] rotateMap = new int[x2 - x1 + 2][y2 - y1 + 1];
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                rotateMap[i - x1][j - y1] = map[i][j];
            }
        }
        
        int temp = rotateMap[0][0];
        for (int i = 0; i < x2 - x1; i++) {
            rotateMap[i][0] = rotateMap[i + 1][0];
        }
        for (int i = 0; i < y2 - y1; i++) {
            rotateMap[x2 - x1][i] = rotateMap[x2 - x1][i + 1];
        }
        for (int i = x2 - x1; i > 0; i--) {
            rotateMap[i][y2 - y1] = rotateMap[i - 1][y2 - y1];
        }
        for (int i = y2 - y1; i > 1; i--) {
            rotateMap[0][i] = rotateMap[0][i - 1];
        }
        rotateMap[0][1] = temp;
        
        int minNum = Integer.MAX_VALUE;
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                if (i > x1 && i < x2 && j > y1 && j < y2) continue;
                int rx = i - x1;
                int ry = j - y1;
                map[i][j] = rotateMap[rx][ry];
                minNum = Math.min(minNum, map[i][j]);
            }  
        }
        return minNum;
    }
}