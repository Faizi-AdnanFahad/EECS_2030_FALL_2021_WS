package console_apps;

public class concole_tester {

	public static void main(String[] args) {
		String[] strs = {"flower","1", "flow","flight", "flb"};
		int shortestStirng = strs[0].length();
		for (int i = 1; i < strs.length; i ++) {
			if (strs[i].length() < shortestStirng) {
				shortestStirng = strs[i].length();
			}
		}
		System.out.println(shortestStirng);
	}
	

}
