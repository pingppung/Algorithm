import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	int k = Integer.parseInt(br.readLine());
    	if(k >= n) {
    		System.out.println(0);
    		return;
    	}
    	int[] lamp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
    	Arrays.sort(lamp);
    	Integer[] diff = new Integer[n];
    	Arrays.fill(diff, 0);
    	for(int i = 0; i < n-1; i++) {
    		diff[i] = lamp[i+1] - lamp[i];
    	}
    	Arrays.sort(diff, Collections.reverseOrder());
    	int sum = 0;
    	for(int i = k-1; i < n-1; i++) {
    		sum += diff[i];
    	}
    	System.out.println(sum);
    }
}

