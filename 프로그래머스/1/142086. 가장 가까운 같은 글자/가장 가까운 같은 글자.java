import java.util.*;
class Solution {
    public int[] solution(String s) {
        List<Integer> answer = new ArrayList<>();
        Map<Character, Integer> words = new HashMap<>();
        char[] sArr = s.toCharArray();
        for(int i = 0; i < sArr.length; i++){
            if(words.get(sArr[i]) == null){
                answer.add(-1);
                words.put(sArr[i], i);
            } else {
                answer.add(i-words.get(sArr[i]));
                words.put(sArr[i], i);
            }
        }
        return answer.stream().mapToInt(Integer::valueOf).toArray();
    }
}