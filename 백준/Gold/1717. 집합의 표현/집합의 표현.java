import java.io.*;
import java.util.*;
public class Main {
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new int[n+1];
		for(int i = 0; i <= n; i++) {
			arr[i] = i;
		}
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(command == 0) union(a, b);
			else {
				if(find(a) == find(b)) System.out.println("YES");
				else System.out.println("NO");
			}
		}
	}
	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		arr[a] = b;
		
	}
	private static int find(int num) {
		if(arr[num] != num) arr[num] = find(arr[num]);
    	return arr[num];
	}
}
