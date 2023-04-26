import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < tangerine.length; i++){
            int size = tangerine[i];
            map.put(size, map.getOrDefault(size, 0)+1);
        }
        
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2){
                return map.get(o2).compareTo(map.get(o1));
            }
        });
        for(Integer val : list){
            if(k <= 0) break;
            answer++;
            k -= map.get(val);
        } 
        return answer;
    }
}