import java.io.*;
import java.util.*;
public class Main {
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		boolean chk = false;
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(c == '<') {
				chk = true;
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append(c);
			} else if(c == '>') {
				chk = false;
				sb.append(c);
			}
			else if(chk) {
				sb.append(c);
			}else if(!chk) {
				if(c == ' ') {
					while(!stack.isEmpty()) {
						sb.append(stack.pop());
					}
					sb.append(" ");
				} else stack.push(c);
			}
			
		}
		while(!stack.isEmpty()) sb.append(stack.pop());
		System.out.println(sb.toString());
	}
}