import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n = br.readLine();
		
		for(int i = 1; i < n.length(); i++) {
			String a = n.substring(0, i);
			String b = n.substring(i);
			
			int aResult =  Arrays.stream(a.split("")).mapToInt(Integer::parseInt).reduce(1, (x, y) -> x * y);
			int bResult = Arrays.stream(b.split("")).mapToInt(Integer::parseInt).reduce(1, (x, y) -> x * y);
			if(aResult == bResult) {
				System.out.println("YES");
				return;
			}
		}
		System.out.println("NO");
		
	}
}