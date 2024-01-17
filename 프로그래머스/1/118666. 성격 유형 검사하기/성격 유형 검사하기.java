import java.util.*;
import java.util.Map.Entry;
class Solution {
    static HashMap<Character, Integer> category = new HashMap<>();
    static int[] scores = {3,2,1,0,1,2,3};
    static char[][] types = {
            {'R', 'T'},
            {'C', 'F'},
            {'J', 'M'},
            {'A', 'N'}
        };
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        for(int i = 0; i < survey.length; i++){
            char[] arr = survey[i].toCharArray();
            int choice = choices[i];
            if(choice == 4) continue;
            if(choice >= 1 && choice <= 3) {
                category.put(arr[0], category.getOrDefault(arr[0], 0)+scores[choice-1]);
            } else if(choice >= 5 && choice <= 7) {
                category.put(arr[1], category.getOrDefault(arr[1], 0)+scores[choice-1]);
            }
        }
        // category.forEach((key, value) -> {            
        //     System.out.println(key + " : " + value);        
        // });
        for(char[] type: types){
            char first = type[0];
            char second = type[1];
            int firstScore = category.getOrDefault(first, 0);
            int secondScore = category.getOrDefault(second, 0);
            if(firstScore > secondScore) answer += first;
            else if(firstScore < secondScore) answer += second;
            else {
                if(first > second) answer += second;
                else answer += first;
            }
        }
        return answer;
    }
}