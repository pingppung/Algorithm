import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<Character, Integer> keyMap = new HashMap<>();
        for(String keyArr : keymap){
            for(int i = 0; i < keyArr.length(); i++){
                char key = keyArr.charAt(i);
                if(keyMap.containsKey(key)){
                    keyMap.put(key, Math.min(i+1, keyMap.get(key)));
                } else{
                    keyMap.put(key, i+1);
                }
            }
        }
        for(int i = 0; i < targets.length; i++){
            int count = 0;
            boolean chk = false;
            for(char c : targets[i].toCharArray()){
                if(keyMap.containsKey(c)){
                    count += keyMap.get(c);
                } else {
                    chk = true;
                    break;
                }
            }
            answer[i] = chk? -1 : count;
        }
        return answer;
       
    }
}