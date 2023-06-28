import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (o1, o2)-> { return o1[1]-o2[1]; });
        int section = targets[0][1]-1;
        int answer = 1;
        for(int i = 1; i < targets.length; i++){
            if(section >= targets[i][0] && section <= targets[i][1]) continue;
            answer++;
            section = targets[i][1]-1;
        }
        return answer;
    }
}