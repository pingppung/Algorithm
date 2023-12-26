import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        
        while(true) {
        	str = br.readLine();
        	if(str.equals(".")) break;
        	else 
                System.out.println(balance(str));
        }
        
    }
    static String balance(String s) {
    	Stack<Character> stack = new Stack<>();
    	
    	for(int i = 0; i < s.length(); i++) {
    		char c = s.charAt(i);
    		
    		if(c == '(' || c == '[') stack.push(c);
    		else if(c == ')') {
    			if(stack.isEmpty() || stack.peek() != '(') return "no";
    			else stack.pop();
    		}
    		else if(c == ']') {
    			if(stack.isEmpty() || stack.peek() != '[') return "no";
    			else stack.pop();
    		}
    		
    	}
    	if(stack.isEmpty()) return "yes";
    	else return "no";
    }
}  
