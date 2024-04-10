import java.util.*;
class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        
        int[] wh = {scores[0][0], scores[0][1]};
        Arrays.sort(scores, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                return o1[0]!=o2[0] ? o2[0]-o1[0] : o1[1]-o2[1];
            }
        });
        int evaScore = 0;
        for (int[] sc : scores) {
            if(sc[1] < evaScore) {
                if(sc[0] == wh[0] && sc[1] == wh[1]) {
                    return -1;
                }
                else {
                    sc[0] = -1;
                    sc[1] = -1;
                }
            }
            else {
                evaScore = sc[1];
            }
        }
        Arrays.sort(scores, (s1, s2) -> (s2[0] + s2[1]) - (s1[0] + s1[1]));
        for(int[] score : scores){
            if(score[0] + score[1] > wh[0] + wh[1]){
                answer++;
            } else break;
        }
        return answer;
    }
}