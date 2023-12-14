import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		while(Integer.parseInt(str = br.readLine()) != 0) {
			StringBuilder sb = new StringBuilder(str);
			if(sb.reverse().toString().equals(str)) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}
}