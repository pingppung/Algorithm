import java.util.*;
class Solution {
    public long solution(int r1, int r2) {
        long r1_pow = (long)Math.pow(r1,2);
        long r2_pow = (long)Math.pow(r2,2);
        long answer = 0;
        for(long i = 1; i <= r2; i++){
            long start = (long) Math.ceil(Math.sqrt(r1_pow - (long)i*i));
            long end = (long) Math.floor(Math.sqrt(r2_pow - (long)i*i));
            answer += end - start+1;
        }
        return answer*4;
    }
}