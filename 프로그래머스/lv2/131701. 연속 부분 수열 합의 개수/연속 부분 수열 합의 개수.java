import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        
        int len = elements.length;
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                int sum = 0;
                for(int k = 0; k < i; k++){
                    sum += elements[(j+k)%elements.length];
                }
                set.add(sum);
            }
        }
        return set.size();
    }
}