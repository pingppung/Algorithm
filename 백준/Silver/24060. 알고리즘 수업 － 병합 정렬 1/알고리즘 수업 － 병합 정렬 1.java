import java.io.*;
import java.util.*;
public class Main {
    static int[] A;
	static int[] tmp;
	static int n, k, count = 0, result = -1;
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
 
    	n = Integer.parseInt(st.nextToken());
    	k = Integer.parseInt(st.nextToken());
    	st = new StringTokenizer(br.readLine());
    	
    	A = new int[n];
    	tmp= new int[n];
    	for(int i = 0; i < n; i++) {
    		A[i] = Integer.parseInt(st.nextToken());
    	}
    	merge_sort(0, n-1);
    	System.out.println(result);
    }
    static void merge_sort(int p, int r) {
    	if(count > k) return;
    	if(p < r) {
    		int q = (p+r)/2;
    		merge_sort(p, q);
    		merge_sort(q+1, r);
    		merge(p, q, r);
    		
    	}
    }
    static void merge(int p, int q, int r) {
    	int i = p;
    	int j = q+1;
    	int t = 0;
    	while(i <= q && j <= r) {
    		if(A[i] <= A[j]) tmp[t++] = A[i++];
    		else tmp[t++] = A[j++];
    	}
    	while(i <= q) tmp[t++] = A[i++];
    	while(j <= r) tmp[t++] = A[j++];
    	i = p;
    	t = 0;
    	while(i <= r) {
    		count++;
    		if(count == k) {
    			result = tmp[t];
    			break;
    		}
    		A[i++] = tmp[t++];
    	}
    }
}
