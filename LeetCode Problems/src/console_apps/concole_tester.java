package console_apps;

public class concole_tester {

	public static void main(String[] args) {
		
		int result = 0;
		
		String a = "1010";
		
		for (int i = 0; i < a.length(); i ++) {
			int digitINInt = Character.getNumericValue(a.charAt(a.length() - i - 1));
			result += Math.pow(2, i) * digitINInt;
		}
		
		System.out.println(result);

	}


}
