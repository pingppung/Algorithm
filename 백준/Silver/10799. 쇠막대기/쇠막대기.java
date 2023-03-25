import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	String s = br.readLine();
    	Stack<Character> stack = new Stack<>();
    	int count = 0;
    	
    	for(int i = 0; i < s.length(); i++) {
    		if(s.charAt(i) == '(') {
    			stack.push('(');
    		}
    		else {
    			if(s.charAt(i-1) == '(') {
    				stack.pop();
    				count += stack.size();
    			} else {
    				count++;
    				stack.pop();
    			}
    		}
    	}
    	System.out.println(count);
    	
    } 
}
