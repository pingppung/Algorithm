import java.util.*;
class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int[] dp = new int[number+1];
        countDivisors(dp, number);
        for(int i = 1; i <= number; i++){
            if(dp[i] <= limit){
                answer += dp[i];
            } else{
                answer += power;
            }
        }
        return answer;
    }
    public void countDivisors(int[] dp, int number){
        for(int i = 1; i <= number; i++){
            int count = 0;
            for(int j = 1; j <= Math.sqrt(i); j++){
                if (i % j == 0) {
                    if (j * j == i) { 
                        count++;
                    } else { 
                        count += 2;
                    }
                }
            }
            dp[i] = count;
        }
    }
}