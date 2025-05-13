import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		List<Integer> positives = new ArrayList<>();
		List<Integer> negatives = new ArrayList<>();
		
		int oneCount = 0;
		boolean hasZero = false;
		
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num > 1) positives.add(num);
			else if(num == 1) oneCount++;
			else if(num == 0) hasZero = true;
			else negatives.add(num);
		}
		
		positives.sort(Comparator.reverseOrder());
		Collections.sort(negatives);
		
		long total = 0;
		
		for (int i = 0; i < positives.size(); i += 2) {
		    if (i + 1 < positives.size()) {
		        int mul = positives.get(i) * positives.get(i + 1);
		        total += mul;
		    } else {
		        total += positives.get(i); 
		    }
		}
		for (int i = 0; i < negatives.size(); i += 2) {
		    if (i + 1 < negatives.size()) {
		        total += negatives.get(i) * negatives.get(i + 1);
		    } else {
		        if (!hasZero) {
		            total += negatives.get(i);
		        }
		    }
		}
		total += oneCount;
		System.out.println(total);
	}
	
}
