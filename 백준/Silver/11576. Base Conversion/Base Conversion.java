import java.io.*;
import java.util.*;
public class Main {
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
  
    	int a = Integer.parseInt(st.nextToken());
    	int b = Integer.parseInt(st.nextToken());
    	
    	int m = Integer.parseInt(br.readLine());
    	st = new StringTokenizer(br.readLine());
    	int	decimal = 0; 
    	for(int i = m; i > 0; i--) {
    		int num = Integer.parseInt(st.nextToken());
    		decimal += num * Math.pow(a, i-1);
    	}
    	List<Integer> list = new ArrayList<>();
    	while(decimal != 0) {
    		list.add(decimal % b);
    		decimal /= b;
    	}
    	for(int i = list.size() -1; i >= 0; i--) {
    		sb.append(list.get(i)+ " ");
    	}
    	System.out.println(sb);
    }
}
