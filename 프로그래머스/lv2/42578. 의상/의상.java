import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < clothes.length; i++){
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 1)+1);
        }
        System.out.println(map);
        int count = 1;
       
        for(String key : map.keySet()){
            count *= map.get(key);
        }
        return count-1;
    }
}