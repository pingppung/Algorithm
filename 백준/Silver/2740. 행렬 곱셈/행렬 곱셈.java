import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	
    	int n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
    	int[][] a = new int[n][m];
    	
    	for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < m; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
    	
    	st = new StringTokenizer(br.readLine());
    	m = Integer.parseInt(st.nextToken());
    	int k = Integer.parseInt(st.nextToken());
    	int[][] b = new int[m][k];
    	
    	for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < k; j++) {
				b[i][j] = Integer.parseInt(st.nextToken());
			}
		}
    	
    	
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < k; j++) {
    			int sum = 0;
    			for(int p = 0; p < m; p++) {
    				sum += a[i][p] * b[p][j];
    			}
    			sb.append(sum + " ");
    		}
    		sb.append("\n");
    	}
    	System.out.println(sb);
    }
}
