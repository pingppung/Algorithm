import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();
        for(int i = 0; i < phone_book.length; i++){
            set.add(phone_book[i]);
        }
        for(String number : set){
            for(int i = 1; i < number.length(); i++){
                if(set.contains(number.substring(0,i))) return false;
            }
        }
        return true;
    }
}