import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> list = new ArrayList<>();
        int before = arr[0];
        list.add(arr[0]);
        for(int i = 1; i < arr.length; i++){
            if(before == arr[i]){
                continue;
            }
            list.add(arr[i]);
            before = arr[i];
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}