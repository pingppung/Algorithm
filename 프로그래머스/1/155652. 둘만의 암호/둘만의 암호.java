import java.util.*;
import java.util.stream.*;
class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        for(int i = 0; i < s.length(); i++){
            char alph = s.charAt(i);
            for(int j =0; j < index; j++){
                alph++;
                if(alph > 'z') alph -= 26;
          
                if(skip.contains(String.valueOf(alph))){
                    j--;
                }
            }
            answer += alph;
        }
        return answer;
    }
}
//a b c d e f g h i j k l m n o p q r s t u v w x y z