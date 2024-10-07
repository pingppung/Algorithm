
import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 1;
        List<String> list1 = findElement(str1);
        List<String> list2 = findElement(str2);
        
        if(list1.size() == 0 && list2.size() == 0) return 65536;
        int[] count = calCount(list1, list2);
        answer = (int) Math.floor( (double)count[1] / count[0] * 65536);
        return answer;
    }
    
    private List<String> findElement(String s){
        List<String> list = new ArrayList<>();
        for(int i = 0; i < s.length()-1; i++){
            String el = s.substring(i, i+2);
            if(el.matches("[a-zA-Z]{2}")){
                list.add(el.toLowerCase());
                
            }
        }
        return list;
    }
    private int[] calCount(List<String> list1, List<String> list2){
        int unionCount = 0;
        int itsCount = 0;
        for(int i = 0; i < list1.size(); i++){
            String el = list1.get(i);
            if(list2.contains(el)){
                int count1 = Collections.frequency(list1, el);
                int count2 = Collections.frequency(list2, el);
                unionCount += Math.max(count1, count2);
                itsCount += Math.min(count1, count2);
                list1.removeAll(Collections.singleton(el));
                list2.removeAll(Collections.singleton(el));
                i = -1;
            }
        }
        unionCount += list1.size() + list2.size();
        return new int[]{unionCount, itsCount};
    }
}