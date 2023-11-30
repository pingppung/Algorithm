import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> phone = new HashSet<>(Arrays.asList(phone_book));
        for(String number : phone){
            for(int i = 1; i < number.length(); i++){
                if(phone.contains(number.substring(0,i))) return false;
            }
        }
        return true;
    }
}