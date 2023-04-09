import java.io.*;
import java.util.*;
public class Main {
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	String[] grades = {"A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F"};
    	double[] score = {4.5, 4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0.0};
    	
    	double total = 0;
    	double sum = 0;
    	for(int i = 0; i < 20; i++) {
    		st = new StringTokenizer(br.readLine());
    		String subject = st.nextToken();
    		double credit = Double.parseDouble(st.nextToken());
    		String grade = st.nextToken();
    		
    		int idx = Arrays.asList(grades).indexOf(grade);
    		if(idx != -1) {
	    		total += credit;
	    		sum += score[idx] * credit;
    		}
    		
    	}
    	System.out.printf("%.6f",sum/total);
    }
}
