package console_apps;

public class concole_tester {

	public static void main(String[] args) {
		String s = "MCMXCIV";
        if (s.contains("XC")) {
            System.out.println(s.indexOf("XC"));
            String newS = s.substring(0, s.indexOf("XC")) + s.substring(s.indexOf("XC") + 2, s.length());
            System.out.println(newS);

        }
	}

}
