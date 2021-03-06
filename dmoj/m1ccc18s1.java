
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class m1ccc18s1 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp[] = br.readLine().split(" ");
		double k = Double.parseDouble(temp[0]);
		double p = Double.parseDouble(temp[1]);
		double x = Double.parseDouble(temp[2]);
		double f = 0;
		double min = Double.MAX_VALUE;
		for(int i = 1; i < 1000000; i++) {
			f = (i*x) + (k*p)/i;
			if(f < min) {
				min = f;
			}
		}
		System.out.printf("%.3f %n", min);		
	}

}
