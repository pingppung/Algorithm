import java.io.*;
import java.util.*;
public class Main {
	static int n ,result = 0;
	static int[][] consult;
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	n = Integer.parseInt(br.readLine());
    	consult = new int[n][2];
    	for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			consult[i][0] = Integer.parseInt(st.nextToken());
			consult[i][1] = Integer.parseInt(st.nextToken());
		}
    	schedule(0,0);
    	System.out.println(result);
    }
    private static void schedule(int date, int pay) {
    	if(date >= n) {
    		result = Math.max(pay, result);
    		return;
    	}
    	if(date + consult[date][0] <= n) {
    		schedule(date + consult[date][0], pay + consult[date][1]);
    	} else {
    		schedule(date + consult[date][0], pay);
    	}
    	schedule(date+1, pay);
    }
    
}