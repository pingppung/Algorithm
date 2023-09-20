import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int count = 0;
		while(true) {
			if(n % 5 == 0) {
				count += n / 5;
				break;
			}
			if(n < 0) {
				count = -1;
				break;
			}
			n -= 3;
			count++;
		}
		System.out.println(count);
	}
}
