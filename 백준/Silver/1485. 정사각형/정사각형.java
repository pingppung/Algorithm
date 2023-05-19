import java.io.*;
import java.util.*;
public class Main {
	static class Point {
		int x;
		int y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	} 
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int t = Integer.parseInt(br.readLine());
    	while(t-- > 0) {
    		ArrayList<Point> list = new ArrayList<>();
    		for(int i = 0; i < 4; i++) {
    			st = new StringTokenizer(br.readLine());
    			int x = Integer.parseInt(st.nextToken());
    			int y = Integer.parseInt(st.nextToken());
    			list.add(new Point(x,y));
    		}
    		double[] len = new double[6];
    		int idx = 0;
        	for(int i = 0; i < 3; i++) {
        		for(int j = i+1; j < 4; j++) {
        			len[idx++] = getLength(list.get(i),list.get(j));
        		}
        	}
        	Arrays.sort(len);
        	boolean chk = true;
        	for(int i = 1; i < 4; i++) {
        		if(len[0] != len[i]) chk = false;
        	}
        	if(len[4] != len[5]) chk = false;
        	System.out.println(chk? "1" : "0");
    	}
    	
    }
    static double getLength(Point p1, Point p2) {
    	return Math.sqrt(Math.pow(p1.x-p2.x,2)+Math.pow(p1.y-p2.y,2));
    }
}
