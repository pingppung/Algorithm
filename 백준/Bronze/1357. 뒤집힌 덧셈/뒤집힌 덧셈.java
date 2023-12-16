import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder x = new StringBuilder(st.nextToken());
		StringBuilder y = new StringBuilder(st.nextToken());

		int xy = Integer.parseInt(x.reverse().toString())+Integer.parseInt(y.reverse().toString());
		StringBuilder result = new StringBuilder(String.valueOf(xy));
		System.out.println(Integer.parseInt(result.reverse().toString()));
	}
}