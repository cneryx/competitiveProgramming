import java.util.Scanner;

public class dmopc17c5p1 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String s = scanner.next();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '0')
				s = s.substring(0, i) + "O" + s.substring(i + 1);
			else if (s.charAt(i) == '1')
				s = s.substring(0, i) + "l" + s.substring(i + 1);
			else if (s.charAt(i) == '3')
				s = s.substring(0, i) + "E" + s.substring(i + 1);
			else if (s.charAt(i) == '4')
				s = s.substring(0, i) + "A" + s.substring(i + 1);
			else if (s.charAt(i) == '5')
				s = s.substring(0, i) + "S" + s.substring(i + 1);
			else if (s.charAt(i) == '6')
				s = s.substring(0, i) + "G" + s.substring(i + 1);
			else if (s.charAt(i) == '8')
				s = s.substring(0, i) + "B" + s.substring(i + 1);
			else if (s.charAt(i) == '9')
				s = s.substring(0, i) + "g" + s.substring(i + 1);
		}
		System.out.println(s);

	}

}
