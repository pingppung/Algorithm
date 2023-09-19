import java.io.*;
import java.util.*;
public class Main {
	static class Person{
		int age;
		String name;
		public Person(int age, String name) {
			this.age = age;
			this.name = name;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		List<Person> list = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			list.add(new Person(age, name));
		}
		
		Collections.sort(list, new Comparator<Person>() {
			public int compare(Person p1, Person p2) {
				return p1.age - p2.age;
			}
		});
		for(Person p : list) {
			System.out.println(p.age +" "+ p.name);
		}
		
	}
}
