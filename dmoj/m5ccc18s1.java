
import java.util.Arrays;
import java.util.Scanner;

public class m5ccc18s1 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int c[] = new int[n];
		int median[] = new int[3];
		for(int i = 0; i < n; i++) {
			c[i] = scanner.nextInt();
		}
		int x, y, z, count = 0;
		for(int i = 0; i < n; i++) {
			x = c[i];
			for(int j = i+1; j < n; j++) {
				y = c[j];
				for(int k = j+1; k < n; k++) {
					z = c[k];
					median[0] = x;
					median[1] = y;
					median[2] = z;
					Arrays.sort(median);
					if(median[1] == m) {
						count++;
						//System.out.println(median[0] + " "  + median[1] + " " + median[2]);
					}
				}
			}
		}
		System.out.println(count);
		scanner.close();
		
	}

}
