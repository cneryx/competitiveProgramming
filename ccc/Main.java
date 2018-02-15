import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int sum = 0; 
		for(int i = 0; i <= k; i++) {
			sum += n * Math.pow(10, i);
		}
		System.out.println(sum);
		
	}

}
