import java.io.*;
import java.math.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] temp = new int[n];
		for(int i = 0; i < n; i++) {
			temp[i] = Integer.parseInt(st.nextToken());
		}
		int max = Integer.MIN_VALUE;
		for(int i = 0; i <= n-k; i++) {
			int sum = 0;
			for(int j = i; j < i+k; j++) {
				sum += temp[j];
			}
			max = Math.max(max, sum);
		}
		System.out.println(max);
		
	}
}
