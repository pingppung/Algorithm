import java.io.*;
import java.util.*;
public class Main {
	static int n, m, result = 0;
	static boolean[] broken_btn= new boolean[10];
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	n = Integer.parseInt(br.readLine());
    	m = Integer.parseInt(br.readLine());
    	if(m != 0) {
        	st = new StringTokenizer(br.readLine());
        	for(int i = 0; i < m; i++) {
        		int num = Integer.parseInt(st.nextToken());
        		broken_btn[num] = true; 
        	}
    	}
    	result = Math.abs(n - 100);
    	for(int i = 0; i <= 999999; i++) {
    		String channel = String.valueOf(i);
    		int len = channel.length();
    		boolean isBreak = false;
    		for(int j = 0; j < len; j++) {
    			if(broken_btn[channel.charAt(j)-'0']) {
    				isBreak = true;
    				break;
    			}
    		}
    		if(!isBreak) {
    			int min = Math.abs(n-i)+len;
    			result = Math.min(min, result);
    		}
    	}
    	System.out.println(result);
    }
}
