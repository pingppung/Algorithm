import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i = 1; i <= N; i++) {
			int[] nums = Integer.toString(i).chars().map(Character::getNumericValue).toArray();
			int count = (int) Arrays.stream(nums).filter(num -> num == 3 || num == 6 || num == 9).count();
			if(count == 0) System.out.print(i + " ");
			else {
				String clap = IntStream.range(0, count).mapToObj(j -> "-").collect(Collectors.joining());
				System.out.print(clap +" ");
			}
		}
	}

}