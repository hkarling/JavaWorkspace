package assign.weight;

import java.util.Scanner;

public class ViewResult {

	/**
	 * 선택된 사람의 정보를 불러옵니다.
	 * 
	 * @param person
	 */
	public static void printPerson(Person person) {
		System.out.println("\n*************************************************");
		System.out.println("\t" + person);
		System.out.println("*************************************************");
	}
	/**
	 * 선택된 사람의 정보를 불러옵니다.
	 * 
	 * @param person
	 */
	public static void printPasswordInfo(Person person) {
		System.out.println("\n*************************************************");
		System.out.println("\t" + person.printPassword());
		System.out.println("*************************************************");
	}

	/**
	 * 메시지를 출력합니다.
	 * 
	 * @param message
	 */
	public static void printMessage(String message) {
		System.out.println(message);
	}
}
