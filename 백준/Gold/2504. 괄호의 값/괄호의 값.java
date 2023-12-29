import java.io.*;
import java.util.*;
public class Main {
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();
		Stack<Character> stack = new Stack<>();
		
		boolean fail = false;
		int result = 0;
		int num = 1;
		for(int i = 0; i < arr.length; i++) {
			char c = arr[i];
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
					if(arr[i-1] == '(') result += num;
					stack.pop();
					num /= 2;
				} else if(c == ']') {
					if(stack.isEmpty() || stack.peek() != '[') {
						fail = true;
						break;
					}
					if(arr[i-1] == '[') result += num;
					stack.pop();
					num /= 3;
				}
			}
		}
		if(fail || !stack.isEmpty()) System.out.println(0);
    	else System.out.println(result);
	}
}