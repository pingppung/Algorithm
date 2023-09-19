import java.io.*;
import java.util.*;
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int num = Integer.parseInt(br.readLine());
		String s = String.valueOf(num);
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < s.length(); i++) {
			list.add(s.charAt(i)-'0');
		}
		Collections.sort(list, Collections.reverseOrder());
		for(int n : list) {
			System.out.print(n);
		}
	}
}
