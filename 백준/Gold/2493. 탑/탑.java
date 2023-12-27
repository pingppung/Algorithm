import java.io.*;
import java.util.*;
public class Main {
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Stack<int[]> top = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			int height = Integer.parseInt(st.nextToken());
			while(!top.isEmpty()) {
				if(top.peek()[1] >= height) {
					System.out.print(top.peek()[0] +" ");
					break;
				}
				top.pop();
			}
			if(top.isEmpty()) System.out.print("0 ");
			top.push(new int[] {i, height});
		}
	}
}