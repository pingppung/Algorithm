import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int n = Integer.parseInt(br.readLine());
    	int count = 0;
    	for(int i = 0; i < n; i++) {
    		st = new StringTokenizer(br.readLine());
    		int student = Integer.parseInt(st.nextToken());
    		int apple = Integer.parseInt(st.nextToken());
    		
    		if(student > apple) count += apple;
    		else count += apple%student;
    	}
    	System.out.println(count);
    }
    
}
