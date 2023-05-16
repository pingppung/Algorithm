import java.util.*;
class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();
        for(int i = 0; sb.length() <= t*m; i++){
            sb.append(Integer.toString(i, n));
        }
        for(int i = p-1; result.length() < t; i += m){
            result.append(sb.charAt(i));
        }
        return result.toString().toUpperCase();
    }
}