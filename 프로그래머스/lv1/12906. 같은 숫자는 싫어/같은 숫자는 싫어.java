import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> st = new Stack<>();
        int pre = -1;
        for(int i = 0; i < arr.length; i++){
            if(pre == arr[i]) continue;
            st.push(arr[i]);
            pre = arr[i];
        }
        return st.stream().mapToInt(i->i).toArray();
    }
}