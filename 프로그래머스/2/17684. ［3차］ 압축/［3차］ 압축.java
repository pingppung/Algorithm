import java.util.*;
class Solution {
    
    private List<Integer> answer = new ArrayList<>();
    private List<String> dic = new ArrayList<>();
    public int[] solution(String msg) {
        for (char c = 'A'; c <= 'Z'; c++) {
            dic.add(String.valueOf(c)); 
        }
        LZW(msg);
        return answer.stream().mapToInt(i->i).toArray();
    }
    private void LZW(String msg){
        char[] arr = msg.toCharArray();
        String w = "";
        for(int i = 0; i < arr.length; i++){
       
            char c = arr[i];
            String wc = w + c;
            if(dic.contains(wc)){
                w = wc;
            } else {
                if (!w.isEmpty()) {
                    answer.add(dic.indexOf(w) + 1);
                }
                dic.add(wc);
                w = String.valueOf(c);
            }
            if (i == arr.length - 1) {
                answer.add(dic.indexOf(w) + 1); 
            }
        }
        
    }
}