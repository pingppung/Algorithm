import java.io.*;
import java.util.*;
public class Main {
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String bomb = br.readLine();
		
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < str.length(); i++) {
			stack.push(str.charAt(i));
			if(stack.size() >= bomb.length()) {
				boolean chk = true;
				for(int j = 0; j < bomb.length(); j++) {
					if(stack.get(stack.size() - bomb.length() + j) != bomb.charAt(j)) {
						chk = false;
						break;
					}
				}
				if(chk) {
					for(int j = 0; j < bomb.length(); j++) {
						stack.pop();
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		if(stack.isEmpty()) System.out.println("FRULA");
		else {
			for(Character c : stack) sb.append(c);
			System.out.println(sb.toString());
		}
	}
}