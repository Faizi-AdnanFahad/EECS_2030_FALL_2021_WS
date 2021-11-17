package Inheritance_hierarchy;

public class SmartPhoneTest2 {

	public static void main(String[] args) {
		 SmartPhone myPhone;
		 IOS ip = new Iphone13Pro(); 
		 myPhone = ip;
		 myPhone.surfWeb();
		 
		 Samsung ss = new GalaxyS21();
		 myPhone = ss;
		 myPhone.surfWeb();
		}

}
