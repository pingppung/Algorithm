import java.io.*;
import java.util.*;
public class Main {
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int n = Integer.parseInt(br.readLine());
    	boolean[] chk = new boolean[1000];
    	for(int i = 123; i < 1000; i++) {
    		String s = Integer.toString(i);
    		if(s.charAt(0) == '0' || s.charAt(1) == '0' || s.charAt(2) == '0') continue;
    		if(s.charAt(0) == s.charAt(1) || s.charAt(0) == s.charAt(2) || s.charAt(1) == s.charAt(2)) continue;
    		chk[i] = true;
    	}
    	for(int i = 0; i < n; i++) {
    		st = new StringTokenizer(br.readLine());
    		int mh = Integer.parseInt(st.nextToken());
    		int s = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		
    		for(int ys = 123; ys < 1000; ys++) {
    			if(chk[ys]) {
    				int scnt = 0;
    				int bcnt = 0;
    				
    				for(int first = 0; first < 3; first++) {
    					char c1 = Integer.toString(mh).charAt(first);
    					for(int second = 0; second < 3; second++) {
    						char c2 = Integer.toString(ys).charAt(second);
        					if(c1 == c2 && first == second) scnt++;
        					else if(c1 == c2 && first != second) bcnt++;
        				}
    				}
    				if(scnt == s && bcnt == b) chk[ys] = true;
    				else chk[ys] = false;
    			}
    		}
    	}
    	int count = 0;
    	for(int i = 123; i < 1000; i++) {
    		if(chk[i]) count++;
    	}
    	System.out.println(count);
    }
}
