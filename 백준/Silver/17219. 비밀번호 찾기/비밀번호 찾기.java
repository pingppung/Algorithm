import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	
    	int n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
    	
    	HashMap<String, String> info = new HashMap<>();
    	for(int i = 0; i < n; i++) {
    		st = new StringTokenizer(br.readLine());
    		info.put(st.nextToken(), st.nextToken());
    	}
    	for(int i = 0; i < m; i++) {
    		String pwd = info.get(br.readLine());
    		sb.append(pwd).append("\n");
    	}
    	System.out.println(sb);
    }
}  