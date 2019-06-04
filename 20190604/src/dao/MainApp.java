package dao;

public class MainApp {

	public static void main(String[] args) {
		CRUDExam crudExam = new CRUDExam();
		
		System.out.println("---------- 전체 검색 ----------");
		crudExam.selectAll();
		System.out.println("\n---------- 번호 검색 ----------");
		crudExam.searchByEmpno(7369);
		System.out.println("\n---------- 없는 경우 ----------");
		crudExam.searchByEmpno(0);

	}
}
