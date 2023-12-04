import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numbers.length; i++){
            arr[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(arr, (e1, e2) -> (e2 + e1).compareTo(e1 + e2));
        if(arr[0].equals("0")) return "0";
        for(int i = 0; i < arr.length; i++){
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}