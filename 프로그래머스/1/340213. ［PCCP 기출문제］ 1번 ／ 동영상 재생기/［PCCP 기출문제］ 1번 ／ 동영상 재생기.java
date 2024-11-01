import java.util.*;
import java.time.*;
class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        int pos_n = timeToSeconds(pos);
        int op_sn = timeToSeconds(op_start);
        int op_en = timeToSeconds(op_end);
        int video = timeToSeconds(video_len);
        for(String cmd : commands){
            if(pos_n >= op_sn && pos_n <= op_en) pos_n = op_en; //오프닝 구간일 경우
            if(cmd.equals("next")){
                pos_n += 10;
            } else {
                pos_n -= 10;
            }
            if(pos_n >= op_sn && pos_n <= op_en) pos_n = op_en; //오프닝 구간일 경우
            if(pos_n < 0) pos_n = 0;
            if(pos_n > video) pos_n = video;
        }
        answer = String.format("%02d:%02d",pos_n/60,pos_n%60);
        return answer;
    }
    private int timeToSeconds(String time) {
        int[] times = Arrays.stream(time.split(":")).mapToInt(Integer::valueOf).toArray();
        return times[0] * 60 + times[1];
    }
}