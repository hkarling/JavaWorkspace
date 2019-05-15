/** 
 * @author 윤참솔
 * created on 2019/05/14
 */
package assign.sample02;

public class MainApp {

	public static void main(String[] args) {
		Employee[] employees = new Employee[5];
		
		employees[0] = new FullTime(10, "유재석", "개그우먼", 0, "2013-05-01", "무한도전", 8500, 200);
		employees[1] = new FullTime(20, "박명수", "가수", 10, "2013-06-20", "무한도전", 7500, 100);
		employees[2] = new FullTime(30, "정준하", "예능인", 10, "2013-06-22", "무한도전", 6000, 0);
		employees[3] = new PartTime(40, "노홍철", "예능인", 20, "2014-05-01", "무한도전", 20000);
		employees[4] = new PartTime(50, "하하", "가수", 30, "2014-05-02", "무한도전", 25000);
		
		System.out.println("*************** Employee 정보 **************");
		for (Employee em : employees)
			System.out.println(em);
		System.out.println("\n*************** Message **************");
		for (Employee em : employees)
			em.message();
	}

}
