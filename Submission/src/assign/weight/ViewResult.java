package assign.weight;

public class ViewResult {

	/**
	 * 선택된 사람의 정보를 불러옵니다.
	 * 
	 * @param person
	 */
	public static void printPerson(Person person) {
		System.out.println("\n*************************************************");
		System.out.println("\t" + person);
		System.out.println("\n*************************************************\n\n");
	}

	/**
	 * 메시지를 출력합니다.
	 * 
	 * @param message
	 */
	public static void printMessage(String message) {
		System.out.println(message + "\n");
	}
}
