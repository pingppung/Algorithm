import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        Map<Integer, Integer> rank = Map.of(6,1,5,2,4,3,3,4,2,5);
        int[] answer = new int[2];
        List<Integer> winList = Arrays.stream(win_nums)
                            .boxed()
                            .collect(Collectors.toList());
        int count = 0;
        int zeroCount = 0;
        for(int num : lottos){
            if(num == 0) zeroCount++;
            if(winList.contains(num)) {
                count++;
                winList.removeIf(item -> item == num);
            }
        }
        //System.out.println(count +" "+ zeroCount);
        int maxRank = rank.getOrDefault(count+zeroCount,6);
        int minRank = rank.getOrDefault(count,6);
        answer[0] = maxRank;
        answer[1] = minRank;
        return answer;
    }
}