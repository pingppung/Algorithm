import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
  
    	int a = Integer.parseInt(st.nextToken());
    	int p = Integer.parseInt(st.nextToken());
    	
    	List<Integer> list = new ArrayList<>();
    	list.add(a);
    	while(true) {
    		int num = list.get(list.size() - 1);
    		int sum = 0;
    		while(num != 0) {
    			sum += (int) Math.pow(num%10, (double)p);
    			num /= 10;
    		}
    		if(list.contains(sum)) {
    			System.out.println(list.indexOf(sum));
    			break;
    		}
    		list.add(sum);
    		
    	}
    	
    	
    }
}
