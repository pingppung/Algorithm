import java.io.*;
import java.util.*;
public class Main {
	static class Point{
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		List<Point> list = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.add(new Point(x, y));
		}
		Collections.sort(list, new Comparator<Point>() {
			public int compare(Point p1, Point p2) {
				if(p1.x == p2.x) return p1.y - p2.y;
				else return p1.x - p2.x;
			}
		});
		for(Point p : list) {
			sb.append(p.x+" "+p.y+"\n");
		}
		System.out.println(sb);
	}
}
