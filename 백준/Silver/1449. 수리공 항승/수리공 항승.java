import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken());
    	int L = Integer.parseInt(st.nextToken());
    	
    	int[] arr = new int[N];
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < N; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	Arrays.sort(arr);

    	int count = 1;
    	double tape = arr[0] - 0.5;
    	for(int i = 0; i < N; i++) {
    		if (tape+L < arr[i]){
    			tape = arr[i] - 0.5;
    			count ++;
			}
    	}
    	System.out.println(count);
    }
}
