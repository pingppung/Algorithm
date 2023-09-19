import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    	int n = Integer.parseInt(br.readLine());
    	int count = 0;
    	for(int i = 0; i < n; i++) {
    		String s = br.readLine();
    		List<Character> list = new ArrayList<>();
    		boolean fail = false;
    		for(int j = 0; j < s.length(); j++) {
    			if(j > 0 && list.get(list.size()-1) == s.charAt(j)) continue;
    			if(list.contains(s.charAt(j))) {
    				fail = true;
    				break;
    			}
    			list.add(s.charAt(j));
    		}
    		if(!fail) count++; 
    		
    	}
    	System.out.println(count);

    }
}
