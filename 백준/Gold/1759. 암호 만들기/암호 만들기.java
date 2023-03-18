import java.io.*;
import java.util.*;
public class Main {
	static int L, C;
	static char[] arr;
	static char[] result;
    
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());

    	L = Integer.parseInt(st.nextToken());
    	C = Integer.parseInt(st.nextToken());
    	arr = new char[C];
    	result = new char[L];
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < C; i++) {
    		arr[i] = st.nextToken().charAt(0);
    	}
    	Arrays.sort(arr);
    	dfs(0,0);
    } 
    public static void dfs(int start, int depth) {
    	if(depth == L) {
			if(isChk(result)) {
				for(char c : result){
					System.out.print(c);
                }
				System.out.println();
			}
			return;
    	}
    	for(int i = start; i < C; i++) {
    		result[depth] = arr[i];
    		dfs(i+1, depth+1);
    	}
    }
    public static boolean isChk(char[] pwd) {
    	int vow = 0;
    	int cons = 0;
    	for(int i = 0; i < result.length; i++) {
    		if(result[i]=='a'|| result[i] =='e'|| result[i] =='i'|| result[i] =='o'|| result[i] =='u')
    			vow++;
    		else cons++;
    	}
    	if(cons >= 2 && vow >=1) return true;
    	else return false;
    }
}
