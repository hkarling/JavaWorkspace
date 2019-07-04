package ex0514.inheritance;

class CarCenter {
	public void engineer(Car cd) {
		System.out.print(cd.carname + " 수리완료!\t");
		System.out.println("청구비용" + cd.cost + " 원");

		System.out.println("cd주소: " + cd);
		// System.out.println("cd.a: " + cd.a); // 부모객체에서 자식의 필드 접근불가

		if (cd instanceof Excel) {
			// 자식 부분이 접근 가능하도록 object down casting을 한다.
			Excel e = (Excel) cd;
			System.out.println("e주소: " + e);
			System.out.println("e.a: " + e.a);
		}
	}
}

public class PolymorphismExam {
	public static void main(String[] args) {

		CarCenter cc = new CarCenter();
		EfSonata ef = new EfSonata();
		Carnival ca = new Carnival();
		Excel ex = new Excel();

		Car c = new Car();

		cc.engineer(c);//
		cc.engineer(ef);//
		cc.engineer(ca);//

		System.out.println("ex주소: " + ex);
		System.out.println("ex.a: " + ex.a);
		cc.engineer(ex);
	}
}
