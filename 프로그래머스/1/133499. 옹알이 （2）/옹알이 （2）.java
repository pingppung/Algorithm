import java.util.*;
class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        List<String> baby = List.of("aya", "ye", "woo", "ma");
        for(int i = 0; i < babbling.length; i++){
            for(String pron : baby){
                if(babbling[i].equals("")) break;
                if(babbling[i].contains(pron.repeat(2))) break;
                if(babbling[i].contains(pron)){
                    babbling[i] = babbling[i].replaceAll(pron, " ");
                }
            }
        }
        for(int i = 0; i < babbling.length; i++){
            babbling[i] = babbling[i].replaceAll(" ", "");
            if(babbling[i].equals("")) answer++;
        }
        return answer;
    }
}