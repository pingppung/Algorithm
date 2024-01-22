import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public int[] solution(String s) {
        
        //int[] answer = {};
        List<Integer> answer = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        for (String nums : s.split("\\},\\{")) {
            nums = nums.replaceAll("[{}]", ""); 
            List<Integer> elements = Arrays.stream(nums.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
            list.add(elements);
        }
        Collections.sort(list, (o1, o2) -> Integer.compare(o1.size(), o2.size()));
        for(List<Integer> elements : list){
            for(int el : elements){
                if(!answer.contains(el)) {
                    answer.add(el);
                }
            }
            
        }
        return answer.stream().mapToInt(Integer::valueOf).toArray();
    }
}