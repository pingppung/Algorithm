import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        Map<Character, Integer> words = new LinkedHashMap<>();
        char[] sArr = s.toCharArray();
        char x = ' ';
        int xCount = 1, notXCount = 0;
        boolean isRemain = true;
        for(int i = 0; i < sArr.length; i++){
            if(x == ' ') {
                x = sArr[i];
                xCount = 1;
                isRemain = true;
                continue;
            }
            if(sArr[i] == x){
                xCount++;
            } else {
                notXCount++;
            }
            if(xCount == notXCount){
                isRemain = false;
                answer++;
                x = ' ';
                notXCount = 0;
            }
        }
        if(isRemain) answer++;
        return answer;
    }
}