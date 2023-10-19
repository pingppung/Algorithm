import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> type = new HashMap<>();
        
        for(String t : terms){
            String[] s = t.split(" ");
            type.put(s[0], Integer.parseInt(s[1]));
        }
        String[] today_arr = today.split("\\.");
        int year = Integer.parseInt(today_arr[0]);
        int month = Integer.parseInt(today_arr[1]);
        int day = Integer.parseInt(today_arr[2]);
        
        for(int i = 0; i < privacies.length; i++){
            String[] s = privacies[i].split(" ");
            String date = s[0];
            int exp = type.get(s[1]) * 28; 
            String[] dates = date.split("\\.");
            int total = (year - Integer.parseInt(dates[0]))* 28 * 12
                + (month - Integer.parseInt(dates[1]))* 28
                + (day - Integer.parseInt(dates[2]));
            if(total >= exp) answer.add(i+1);
            
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}