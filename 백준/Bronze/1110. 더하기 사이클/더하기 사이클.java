import java.io.*;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int num = n;
		int count = 0;
		
		do{
			int sum = num/10 + num%10;
			num = (num%10)*10 + (sum%10);
			count++;
		} while(num != n);
		System.out.println(count);
	}
}