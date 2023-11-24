import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int num : arr){
            list.add(num);
        }
        int min = Collections.min(list);
        list.removeIf(number -> number.equals(min));
        if(list.size() == 0) list.add(-1);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}