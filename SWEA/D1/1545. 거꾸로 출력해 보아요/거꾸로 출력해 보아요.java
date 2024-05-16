import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		IntStream.rangeClosed(0, N).map(i -> N -i).forEach(i -> {System.out.print(i+ " ");});
	}

}
