import java.io.*;
import java.util.*;
import java.util.stream.*;
public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String result = IntStream.range(0, 5)
								.mapToObj(i -> IntStream.range(0, 5)
										.mapToObj(j -> i == j ? "#" : "+")
										.collect(Collectors.joining()))
								.collect(Collectors.joining("\n"));
		System.out.println(result);
	}

}
