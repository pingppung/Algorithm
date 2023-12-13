import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] words = br.readLine().toUpperCase().toCharArray();
		HashMap<Character, Integer> alph = new HashMap<>();
		
		int max = 0;
		for(char word : words) {
			alph.put(word, alph.getOrDefault(word,0)+1);
			max = Math.max(max, alph.get(word));
		}
		
		int count = 0;
		char ch = '?';
		for (Map.Entry<Character, Integer> entry : alph.entrySet()) {
            if(entry.getValue().equals(max)) {
            	count++;
            	ch = entry.getKey();
            }
        }
		System.out.println(count > 1 ? '?' : ch);
	}
}