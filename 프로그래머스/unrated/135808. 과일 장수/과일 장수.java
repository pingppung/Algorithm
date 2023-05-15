import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for (int e : score) {
            list.add(e);
        }
        Collections.sort(list, Collections.reverseOrder());
        int box = list.size() / m;
        for(int i = 1; i <= box; i++) {
            int min = list.get(i*m -1);
            
            answer += min * m;
        }
        return answer;
    }
}