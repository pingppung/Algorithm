import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(String tree : skill_trees){
            String str = skill;
            boolean chk = true;
            for(String s : tree.split("")){
                if(str.indexOf(s) == -1) continue;
                else {
                    if(str.indexOf(s) == 0) {
                        str = str.substring(1);
                    } else {
                        chk = false;
                        break;
                    }
                }
            }
            if(chk) answer++;
        }
        return answer;
    }
}