import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int n = Integer.parseInt(br.readLine());
    	int[][] wires = new int[n][2];
    	for(int i = 0; i < n; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		wires[i][0] = Integer.parseInt(st.nextToken());
    		wires[i][1] = Integer.parseInt(st.nextToken());
    	}
    	Arrays.sort(wires, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
    	});
    	int[] dp = new int[n];
    	for(int i =0 ; i < n; i++) {
    		dp[i] = 1;
    		for(int j = 0; j < i; j++) {
    			if(wires[i][1] > wires[j][1])
    				dp[i] = Math.max(dp[i], dp[j] + 1);
        	}
    	}
    	
    	int max = Arrays.stream(dp).max().getAsInt();
    	System.out.println(n - max);
    }
    
}  