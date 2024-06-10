import java.io.*;
import java.util.*;
public class Main {
	static int n;
	static List<Long> list = new ArrayList<>();
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	n = Integer.parseInt(br.readLine());
    	if(n <= 10) {
    		System.out.println(n);
    		return;
    	}
    	if(n >= 1023) { //9876543210 제외 => 2의 10승 -1
    		System.out.println(-1);
    		return;
    	}
    	for(int i = 0; i < 10; i++) {
    		findNum(i, 1);
    	}
    	Collections.sort(list);
    	System.out.println(list.get(n));
    }
    private static void findNum(long num, int len) {
    	if(len > 10) return;
    	list.add(num);
    	for(int i = 0; i < (num % 10); i++) {
    		findNum((num * 10) + i, len+1);
    	}
    }
}

