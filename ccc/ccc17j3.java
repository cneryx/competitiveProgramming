import java.util.Scanner;

public class ccc17j3 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		int d = scanner.nextInt();
		int u = scanner.nextInt();
		
		int x = Math.abs(c - a);
		int y = Math.abs(d - b);
		u -= (x + y);
		if(u % 2 == 0 && u >= 0) {
			System.out.println("Y");
		}
		else {
			System.out.println("N");
		}
		
	}

}
