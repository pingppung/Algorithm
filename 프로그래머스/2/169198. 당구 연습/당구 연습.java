import java.util.*;
class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(int[] ball : balls){
            int ex = ball[0]; int ey = ball[1];
            int result = Integer.MAX_VALUE;
            //상
            if(!(startX == ex && startY <= ey)) {
                int dis = calDist(startX, startY, ex, 2 * n - ey);
                result = Math.min(dis, result);
            } 
            //하
            if(!(startX == ex && startY >= ey)) {
                int dis = calDist(startX, startY, ex, -1 * ey);
                result = Math.min(dis, result);
            } 
            //좌
            if(!(startY == ey && startX >= ex)) {
                int dis = calDist(startX, startY, -1 * ex, ey);
                result = Math.min(dis, result);
            } 
            //우
            if(!(startY == ey && startX <= ex)){
                int dis = calDist(startX, startY, 2 * m - ex,  ey);
                result = Math.min(dis, result);
            } 
            
            answer.add(result);
            
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    private int calDist(int sx, int sy, int ex, int ey){
        return (int)(Math.pow(ex-sx,2) + Math.pow(ey-sy,2));
    }
}