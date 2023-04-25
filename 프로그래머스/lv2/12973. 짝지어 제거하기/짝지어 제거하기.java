import java.util.*;
class Solution
{
    public int solution(String s)
    {
        char[] arr = s.toCharArray();
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < arr.length; i++){
            if(st.isEmpty()) st.push(arr[i]);
            else {
                if(st.peek() == arr[i]) st.pop();
                else st.push(arr[i]);
            }
        }
        return st.isEmpty() ? 1 : 0;
    }
}