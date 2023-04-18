import java.io.*;
import java.util.*;
public class Main {
	static int n;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	n = Integer.parseInt(br.readLine());
    	st = new StringTokenizer(br.readLine());
    	
    	arr = new int[n];
    	for(int i = 0; i < n ; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	if(combin()) {
        	for(int num : arr) {
        		sb.append(num+" ");
        	}
        	System.out.println(sb);
    	} else System.out.println(-1);
    }
    public static boolean combin() {
    	for(int i = n-1; i > 0; i--) {
    		if(arr[i-1] < arr[i]) {
    			for(int j = n-1; j >= i; j--) {
    				if(arr[j] > arr[i-1]) {
    					int tmp = arr[j];
    					arr[j] = arr[i-1];
    					arr[i-1] = tmp;
    					int idx = n -1;
    					while(i < idx) {
    						int tmp2 = arr[i];
    						arr[i] = arr[idx];
    						arr[idx] = tmp2;
    						i++;
    						idx--;
    					}
    					return true;
    				}
    			}
    		}
    	}
    	return false;
    }
}
