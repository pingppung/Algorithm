import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		//StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			long result = 0;
			for(int i = 0; i < n; i++) {
				for(int j = i+1; j < n; j++) {
					result += gcd(arr[i], arr[j]);
				}
			}
			System.out.println(result);
		}
		
		
	}
	public static int gcd(int a, int b) {
		while(b != 0) {
			int tmp = a % b;
			a = b;
			b = tmp;
		}
		return a;
	}
}
