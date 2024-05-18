import java.io.*;
import java.util.*;
public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int idx = 1;
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int speed = 0;
			int dis = 0;
			for(int i = 0; i < N; i++) {
				String s = br.readLine();
				if(!s.equals("0")) {
					String[] cmd = s.split(" ");
					if(cmd[0].equals("1")) speed += Integer.parseInt(cmd[1]);
					else {
						speed -= Integer.parseInt(cmd[1]);
						speed = (speed < 0) ? 0 : speed;
					}
				}

				dis += speed;
			}
			System.out.printf("#%d %d\n", idx++, dis);
		}
	}

}