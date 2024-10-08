import java.util.*;
class Solution {
    public String solution(String p) {
        return conversion(p);
    }
    
    private String conversion(String s){
        if(s.equals("")) return "";
            
        int left = 0, right = 0;
        String u = "", v = "";
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(') left++;
            else right++;
    
            if(left == right) {
                u = s.substring(0, i+1);
                v = s.substring(i+1);
                break;      
            }
        } 
        if(correctString(u)){
            return u + conversion(v);
        } else {
            StringBuilder result = new StringBuilder();
            result.append("(");
            result.append(conversion(v));
            result.append(")");
            u = u.substring(1, u.length() - 1);
            result.append(changeString(u));
            return result.toString();
        }
    }
    
    private boolean correctString(String u){
        int bal = 0;
        for(char c : u.toCharArray()){
            if(c == '(') bal++;
            else bal--;
            if(bal < 0) return false;
        }
        return true;
    }
    private String changeString(String u){
        StringBuilder reversed = new StringBuilder();
        for (char c : u.toCharArray()) {
            if (c == '(') reversed.append(')');
            else reversed.append('(');
        }
        return reversed.toString();
    }
}