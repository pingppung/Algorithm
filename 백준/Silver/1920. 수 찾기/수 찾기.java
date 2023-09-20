import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
        StringBuilder sb = new StringBuilder();
    	
    	int n = Integer.parseInt(br.readLine());
    	
    	int[] A = new int[n];
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < n; i++) {
    		A[i] = Integer.parseInt(st.nextToken());
    	}
    	Arrays.sort(A);
    	
    	int m = Integer.parseInt(br.readLine());
    	int[] B = new int[m];
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < m; i++) {
    		B[i] = Integer.parseInt(st.nextToken());
    	}
    	for(int i = 0; i < m; i++) {
    		if(binarySearch(A, B[i]) >= 0) sb.append(1).append("\n");
    		else sb.append(0).append("\n");
    	}
    	System.out.println(sb);
    }
    static int binarySearch(int[] arr, int num) {
    	int start = 0;
    	int end = arr.length -1;
    	while(start <= end) {
    		int mid = (start + end) / 2;
    		if(num  < arr[mid]) end = mid -1;
    		else if(num > arr[mid]) start = mid +1;
    		else return mid;
    	}
    	return -1;
    }	
}  