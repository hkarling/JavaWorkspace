
class Car {
	public String carname;
	public int cost;
	
	protected void printAttributes() {
		System.out.println("carname=" + carname + "\tcost=" + cost);
	}
}

// Car를 상속받는 EfSonata, Excel, Carnival 3개 클래스 작성각 클래스에 인수를 받지않는 생성자 작성
// 각 클래스의 생성자의 구현부에서 carname과 cost에 적당한 값 할당
class EfSonata extends Car {

	public EfSonata() {
		this.carname = "EF 소나타";
		this.cost = 200;
	}
}

class Excel extends Car {
	
	int a = 10;

	public Excel() {
		this.carname = "엑셀";
		this.cost = 100;
	}
}

class Carnival extends Car {
	public Carnival() {
		this.carname = "카니발";
		this.cost = 300;
	}
}

public class InheritanceExam {
	// 메인메소드에서 Car, EfSonata, Excel, Canival 네개의 객체를 생성
	// 각 클래스에서 Car calss에있는 printAttributes()메소드를 호출할수있다.
	public static void main(String[] args) {
		Car car1 = new Car();
		Car car2 = new EfSonata();
		Car car3 = new Excel();
		Car car4 = new Carnival();

		car1.printAttributes();
		car2.printAttributes();
		car3.printAttributes();
		car4.printAttributes();
	}
}
