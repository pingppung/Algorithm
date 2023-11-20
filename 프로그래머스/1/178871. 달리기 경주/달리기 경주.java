import java.util.HashMap;
import java.util.Map;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> playerRank = new HashMap<>();
        
        for (int i = 0; i < players.length; i++) {
            playerRank.put(players[i], i);
        }

        for (String calling : callings) {
            int foundIndex = playerRank.getOrDefault(calling, -1);
            if (foundIndex != -1 && foundIndex != 0) {
                int newIndex = foundIndex - 1;
                String temp = players[newIndex];
                players[newIndex] = players[foundIndex];
                players[foundIndex] = temp;
                
                playerRank.put(players[newIndex], newIndex);
                playerRank.put(players[foundIndex], foundIndex);
                
            }
        }

        return players;
    }
}