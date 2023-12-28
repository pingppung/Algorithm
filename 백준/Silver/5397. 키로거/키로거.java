import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	
    	for(int i = 0; i < n; i++) {
        	Stack<Character> L = new Stack<>();
        	Stack<Character> R = new Stack<>();
        	StringBuilder sb = new StringBuilder();
        	String s = br.readLine();
        	for(int j = 0; j < s.length(); j++) {
        		char c = s.charAt(j);
        		switch(c) {
        			case '<':
        				if(!L.isEmpty()) R.push(L.pop());
        				break;
        			case '>':        				
        				if(!R.isEmpty()) L.push(R.pop());
        				break;
        			case '-':
        				if(!L.isEmpty()) L.pop();
        				break;
        			default:
        				L.add(s.charAt(j));
        				break;
        		}
        	}
        	while(!L.isEmpty()) {
        		R.push(L.pop());
        	}
        	while(!R.isEmpty()) {
        		sb.append(R.pop());
        	}
        	System.out.println(sb);
    	}

    }
    	
} 