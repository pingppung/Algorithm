import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();
        for(int idx = 0; idx < commands.length; idx++){
            int i = commands[idx][0];
            int j = commands[idx][1];
            int k = commands[idx][2];
            int[] sliceArr = Arrays.copyOfRange(array, i-1, j);
            Arrays.sort(sliceArr);
            answer.add(sliceArr[k-1]);
        }
        return answer.stream().mapToInt(Integer::valueOf).toArray();
    }
}