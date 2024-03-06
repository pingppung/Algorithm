import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String s = br.readLine();
    	List<String> list = new ArrayList<>();
    	for(int i = 1; i < s.length()-1; i++) {
    		String[] words = new String[3];
    		for(int j = i+1; j < s.length(); j++) {
    			words[0] = s.substring(0, i);
    			words[1] = s.substring(i, j);
    			words[2] = s.substring(j);
    			StringBuilder sb  = new StringBuilder();
    			for(String w : words) {
    				StringBuilder rv = new StringBuilder();
    				rv.append(w).reverse();
    				sb.append(rv);
    			}
    			list.add(sb.toString());
    		}
    	}
    	Collections.sort(list);
    	System.out.println(list.get(0));
    }
} 