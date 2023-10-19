import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < players.length; i++) map.put(players[i], i+1);
        for(int i = 0; i < callings.length; i++){
            int rank = map.get(callings[i]);
            String temp = players[rank-2]; 
            players[rank-2] = callings[i];
            players[rank-1] = temp;
            
            map.put(callings[i], rank-1);
            map.put(temp, rank);
        }
        return players;
    }
}