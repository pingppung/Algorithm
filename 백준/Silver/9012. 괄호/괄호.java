import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
			Stack<Character> stack = new Stack<>();
			String str = br.readLine();
			for(int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if(c == '(') stack.push(c);
				else { //')'
					if(stack.isEmpty()) { 
						stack.push(c);
						break;
					}else {
						stack.pop();
					} 
				}
			}
			if(!stack.isEmpty()) System.out.println("NO");
			else System.out.println("YES");
		}
	}
}
