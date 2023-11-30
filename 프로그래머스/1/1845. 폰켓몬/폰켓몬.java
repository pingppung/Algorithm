import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Set<Integer> pokemon = new HashSet<>();
        for(int i : nums) {
            pokemon.add(i);
        }
        int n = nums.length/2;
        if(pokemon.size() > n) answer = n;
        else answer = pokemon.size();
        return answer;
    }
}
