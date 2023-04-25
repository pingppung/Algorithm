import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Stack<String> st = new Stack<>();
        boolean chk = true;
        for(int i = 0; i < words.length; i++){
            if(st.contains(words[i])) {
                answer[0] = (i%n)+1;
                answer[1] = (i/n)+1;
                chk = false;
                break;
            }
            st.push(words[i]);
            if(i > 0 && words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)){
                answer[0] = (i%n)+1;
                answer[1] = (i/n)+1;
                chk = false;
                break;
            }
        }

        return chk ? new int[]{0, 0} : answer;
    }
}