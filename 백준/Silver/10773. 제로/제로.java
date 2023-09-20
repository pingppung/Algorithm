import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
       Stack<Integer> stack = new Stack<>();
       
       for(int i = 0; i < k; i++) {
    	   int n = Integer.parseInt(br.readLine());
    	   if(n == 0) stack.pop();
    	   else stack.push(n);
       }
       int result = 0;
       for(int i = 0; i < stack.size(); i++) {
    	   result += stack.get(i);
       }
       System.out.println(result);
    }
}  