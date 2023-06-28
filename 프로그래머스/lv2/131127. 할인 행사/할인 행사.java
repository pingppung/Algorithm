import java.util.*;
class Solution {
    static Map<String, Integer> map = new HashMap<>();
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        for(int i = 0; i < 10; i++){
            map.put(discount[i], map.getOrDefault(discount[i],0)+1);
        }
        int idx = 10;
        while(true){
            if(product_chk(want, number)) answer++;
            if(idx == discount.length) break;
            map.replace(discount[idx-10], map.get(discount[idx-10])-1);
            map.put(discount[idx], map.getOrDefault(discount[idx],0)+1);
            idx++;
        }
        return answer;
    }
    public static boolean product_chk(String[] want, int[] number){
        
        for(int i = 0; i < want.length; i++){
            if(!map.containsKey(want[i]) || map.get(want[i]) != number[i]) return false;
        }
        return true;
    }
}