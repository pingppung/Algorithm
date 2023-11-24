import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> player = new HashMap<>();
        for(String part : participant){
            player.put(part, player.getOrDefault(part, 0)+1);
        }
        for(String complete : completion){
            player.put(complete, player.get(complete)-1);
            if(player.get(complete) == 0){
                player.remove(complete);
            }
        }
        answer = player.keySet().iterator().next();
        return answer;
    }
}