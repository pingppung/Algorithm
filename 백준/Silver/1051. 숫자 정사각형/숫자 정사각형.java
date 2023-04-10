import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());

    	int n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
    	int[][] arr = new int[n][m];
    	for(int i = 0; i < n; i++) {
    		String[] s = br.readLine().split("");
    		for(int j = 0; j < m; j++) {
    			arr[i][j] = Integer.parseInt(s[j]);
    		}
    	}
    	int len = Math.min(n, m);
    	int result = 0;
    	while(len > 1) {
        	for(int i = 0; i <= n-len; i++) {
        		for(int j = 0; j <= m - len; j++) {
        			int num = arr[i][j];
        			if(num == arr[i][j+len-1] && num == arr[i+len-1][j] && num == arr[i+len-1][j+len-1]) {
        				System.out.println(len*len);
                        return;
        			}
        		}
        	}
        	len--;
    	}
    	System.out.println(len * len);
    }
}
