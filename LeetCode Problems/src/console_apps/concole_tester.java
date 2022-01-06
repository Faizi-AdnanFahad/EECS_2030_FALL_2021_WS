package console_apps;

public class concole_tester {

	public static void main(String[] args) {

		int[] a = {1, 2, 3, 4};

		int max = a[0];
		
		for (int i = 0; i < a.length; i ++) {
			for (int m = 0; m < i + 1; m ++) {
				System.out.println("(" + i + ", " + m + ")");
			}
			System.out.println("-----------------");
		}


	}


}
