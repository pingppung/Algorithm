import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < prices.length; i++) {
            st.add(0);
    		for(int j = i+1; j < prices.length; j++) {
                st.set(i, st.elementAt(i)+1);
    			if(prices[i]> prices[j]) break;
    		}
    	
    		
    	}
        return st.stream().mapToInt(i->i).toArray();
    }
}