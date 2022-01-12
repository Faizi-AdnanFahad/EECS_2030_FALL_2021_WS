package console_apps;

public class concole_tester {

	public static void main(String[] args) {

		int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		// 0   1   2   3   4   5   6   7
		int key = 99;

		int start = 0;
		int end = array.length;


		while (start <= end) {
			int mid = (start + end) / 2;
			
			
			
			if (key == array[mid]) {
				System.out.println("KEY found at index " + mid);
				break;
			}
			else if (key < array[mid]) {
				end = mid - 1;
				for (int i = 0; i < end; i ++) {
					System.out.print(i + " ");
					System.out.println();
				}
			}
			else if (key > array[mid]) {
				start = mid + 1;
				for (int i = 0; i < end; i ++) {
					System.out.print(i + " ");
					System.out.println();

				}
			}
		}

		if (start > end) {
			System.out.println("KEY not found");
		}


//		int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//		// 0   1   2   3   4   5   6   7
//		int key = 99;
//
//		int start = 0;
//		int end = array.length;
//
//
//		while (start <= end) {
//			int mid = (start + end) / 2;
//
//			if (key == array[mid]) {
//				System.out.println("KEY found at index " + mid);
//				break;
//			}
//			else if (key < array[mid]) {
//				end = mid - 1;
//			}
//			else if (key > array[mid]) {
//				start = mid + 1;
//			}
//		}
//
//		if (start > end) {
//			System.out.println("KEY not found");
//		}

	}


}
