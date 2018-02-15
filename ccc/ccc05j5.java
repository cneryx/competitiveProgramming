import java.util.Scanner;

public class ccc05j5 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		for (String s = in.next(); !s.equals("X");) {
			while (s.contains("ANA") || s.contains("BAS")) {
				s = s.replaceAll("ANA|BAS", "A");
			}
			if (s.equals("A"))
				System.out.println("YES");
			else
				System.out.println("NO");
			s = in.next();
		}
	}
}
