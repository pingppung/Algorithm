import java.io.*;
import java.util.*;
public class Main {
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		HashSet<Integer> a = new HashSet<>();
		HashSet<Integer> b = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			a.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			b.add(Integer.parseInt(st.nextToken()));
		}
		
		int count = 0;
		for(int num : a) {
			if(!b.contains(num)) count++;
		}
		for(int num : b) {
			if(!a.contains(num)) count++;
		}
		System.out.println(count);
	}
}