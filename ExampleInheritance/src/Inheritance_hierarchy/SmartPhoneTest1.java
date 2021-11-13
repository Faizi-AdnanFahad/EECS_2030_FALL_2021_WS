package Inheritance_hierarchy;

public class SmartPhoneTest1 {

	public static void main(String[] args) {
		 SmartPhone myPhone;
		 IOS ip = new IPhoneSE(); 
		 Samsung ss = new GalaxyS21Plus();
		 myPhone = ip;
		 myPhone = ss;
		 
		 IOS presentForHeeyeon;
		 presentForHeeyeon = ip;
		 presentForHeeyeon = ss;
		}

}
