import java.util.*;
class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int result = puzzleGame(diffs, times, limit);
        return result;
    }
    private int puzzleGame(int[] diffs, int[] times, long limit){
        int l_level = 1;
        int r_level = Arrays.stream(diffs).max().orElse(1);
        while(l_level < r_level){
            int level = (l_level + r_level) / 2;
            long time = 0;
            for(int i = 0; i < diffs.length; i++){
                int diff = diffs[i];
                int time_cur = times[i];
                if(diff <= level){
                    time += time_cur;
                } else {
                    int count = diff - level;
                    int time_prev = times[i-1];
                    time += ((time_cur + time_prev) * count + time_cur);
                }
                if(time > limit) break;
            }
            if(time <= limit) r_level = level;
            else l_level = level + 1;
        }
        return l_level;
    }

}