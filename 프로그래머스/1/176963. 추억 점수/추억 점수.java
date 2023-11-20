import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String,Integer> memory = new HashMap<>();
        for(int i = 0; i < name.length; i++){
            memory.put(name[i], yearning[i]);    
        }
        for(int i = 0; i < photo.length; i++){
            int score = 0;
            for(String character : photo[i]){
                int longingScore = memory.getOrDefault(character, -1);
                if(longingScore != -1){
                    score += longingScore;
                }
            }
            answer[i] = score;
        }
        return answer;
    }
}