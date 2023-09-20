import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashSet<String> hash = new HashSet<>();
        ArrayList<String> arr = new ArrayList<>();
        for(int i = 0; i < n; i++) {
        	hash.add(br.readLine());
        }
        for(int i = 0; i < m; i++) {
        	String str = br.readLine();
        	if(hash.contains(str)) {
        		arr.add(str);
        	}
        }
        Collections.sort(arr);
        System.out.println(arr.size());
        for(String name : arr) {
        	System.out.println(name);
        }
    }
}  
