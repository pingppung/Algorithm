import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int n = Integer.parseInt(br.readLine());
    	int m = Integer.parseInt(br.readLine());
    	int[] arr = new int[n+1];
    	st = new StringTokenizer(br.readLine());
    	for(int i = 1; i <= n; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	int start = 1;
    	int end = n;
    	int sum = 0;
    	int cnt = 0;
    	Arrays.sort(arr);
    	while(start < end) {
    		if(arr[start] + arr[end] < m) start++;
    		else if(arr[start] + arr[end] > m) end--;
    		else {
    			cnt++;
    			start++;
    			end--;
    		}
    		
    	}
    	System.out.println(cnt);
    	
    }
}
