import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] times = new int[n];
		for(int i = 0; i < n; i++) {
			times[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(times);
		int result = 0;
        int time = 0;
        for(int i = 0; i < n; i++) {
        	time += times[i];
        	result += time;
        }
		System.out.println(result);
	}
}
