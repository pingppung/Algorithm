import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	String s = br.readLine();
    	
    	Stack<Character> stack = new Stack<>();
    	int result = 0; 
    	boolean fail = false;
    	int num = 1;
    	for(int i = 0; i < s.length(); i++) {
    		char c = s.charAt(i);
    		//stack.add(c);
    		if(c == '(') {
    			stack.push(c);
    			num *= 2;
    		} else if(c == '[') {
    			stack.push(c);
    			num *= 3;
    		} else {
    			if(c == ')') {
    				if(stack.isEmpty() || stack.peek() != '(') {
    					fail = true;
    					break;
    				}
    				if(s.charAt(i-1) == '(') result += num;
    				stack.pop();
    				num /=2;
    			} else if(c == ']') {
        			if(stack.isEmpty() || stack.peek() != '[') {
        				fail = true;
        				break;
        			}
        			if(s.charAt(i-1) == '[') result += num;
    				stack.pop();
    				num /=3;
    			}
    		}
    		
    	}
    	if(fail || !stack.isEmpty()) System.out.println(0);
    	else System.out.println(result);
    	
    } 	
}
