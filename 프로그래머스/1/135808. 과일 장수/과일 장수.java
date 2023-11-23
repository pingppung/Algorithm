import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int boxCount = score.length / m ;
        List<Integer> sortScore = Arrays.stream(score)
                                        .boxed()
                                        .sorted(Collections.reverseOrder())
                                        .collect(Collectors.toList());
        for(int i = 1; i <= boxCount; i++){
            answer += sortScore.get(i*m-1) * m;
        }
        return answer;
    }
}