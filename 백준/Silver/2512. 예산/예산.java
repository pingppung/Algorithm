import java.io.*;
import java.util.*;
public class Main {
	static int n, m, sum = 0;
	static int[] budget;
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	n = Integer.parseInt(br.readLine());
    	budget = new int[n];
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < n; i++) {
    		budget[i] = Integer.parseInt(st.nextToken());
    		sum += budget[i];
    	}
    	m = Integer.parseInt(br.readLine());
    	
    	Arrays.sort(budget);
    	int result = binarySearch(0, m);
    	System.out.println(result);
    }
    public static int binarySearch(int low, int high) {
    	if(sum <= m) return budget[n-1];
    	while(low <= high) {
    		int limit = 0;
    		int mid = (low + high)/2;
    		for (int i = 0; i < n; i++) {
        		if(mid < budget[i]) limit += mid;
        		else limit += budget[i];   
    		}
    		if(limit > m) high = mid -1;
    		else low = mid +1;
    	}
    	return high;
    }
}
