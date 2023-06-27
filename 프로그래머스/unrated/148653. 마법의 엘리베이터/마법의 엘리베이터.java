import java.util.*;
class Solution {
    public int solution(int storey) {
        int answer = 0;
        int[] arr = Arrays.stream(String.valueOf(storey).split("")).mapToInt(Integer::parseInt).toArray();
        for(int i = arr.length -1; i >=0; i--){
            if(arr[i] > 5) {
                answer += (10-arr[i]);
                if(i ==0) answer++;
                else arr[i-1]++;
            } else if(i>0 && arr[i]==5 && arr[i-1]>=5) {
    			arr[i-1]++;
    			answer += 5;
    		} else {
    			answer += arr[i];
    		}
        }
        return answer;
    }
}