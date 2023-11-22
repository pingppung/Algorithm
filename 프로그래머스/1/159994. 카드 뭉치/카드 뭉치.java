import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        List<String> cardList1 = new ArrayList<>(Arrays.asList(cards1));;
        List<String> cardList2 = new ArrayList<>(Arrays.asList(cards2));
        for(String word : goal){
            if(!cardList1.isEmpty() && cardList1.get(0).equals(word)){
                cardList1.remove(0);
                continue;
            }
            if(!cardList2.isEmpty() && cardList2.get(0).equals(word)){
                cardList2.remove(0);
                continue;
            }
            return "No";
            
        }
        return "Yes";
    }
}