import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> comb = new HashMap<>();
        for(int i = 0; i < clothes.length; i++){
            comb.put(clothes[i][1], comb.getOrDefault(clothes[i][1], 1)+1);
        }
        int count = 1;
       
        for(String key : comb.keySet()){
            count *= comb.get(key);
        }
        return count-1;
    }
}