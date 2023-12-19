import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		double[] score = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
		double m = Arrays.stream(score).max().getAsDouble();
		
		double sum = 0;
		for(int i = 0; i < n; i++) {
			sum += score[i]/m * 100;
		}
		System.out.println(sum / n);
	}
}