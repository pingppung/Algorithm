import java.util.*;
import java.util.stream.*;
class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        List<Integer> common = new ArrayList<>();
        for(String numX : X.split("")){
            map.put(numX, map.getOrDefault(numX, 0)+1);
        }
        for(String numY : Y.split("")){
            int find = map.getOrDefault(numY, -1);
            if(find > 0){
                map.put(numY, find-1);
                common.add(Integer.parseInt(numY));
            }
           
        }
        if(common.size() == 0) return "-1";
        if(common.get(0) == 0) return "0";
        Collections.sort(common, Comparator.reverseOrder());
        answer = common.stream().map(String::valueOf).collect(Collectors.joining(""));
        return answer;
    }
}