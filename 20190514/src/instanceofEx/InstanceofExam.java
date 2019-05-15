package instanceofEx;

class Car{} 
class EfSonata extends Car{}
class Excel extends Car{}
class Canival extends Car{}
class People{}

public class InstanceofExam{
	public static void main(String args []){
		
		Car car = new Car();
		EfSonata ef = new EfSonata();
		Excel ex = new Excel();
		Canival ca = new Canival();
		People p = new People();		
		
		if(car instanceof Car){
			System.out.println("car instanceof Car is true");
		}else{
			System.out.println("car instanceof Car is false");
		}
		
		if(car instanceof EfSonata){ //결과 false---> reference car가 Car 타입이지 EfSonata타입은아니다.
			////왼쪽의변수형이 오른쪽클레스의 하위일때만true
			System.out.println("car instanceof EfSonata is true");
		}else{
			System.out.println("car instanceof EfSonata is false");
		}
		
		if(ef instanceof Car){ 
			System.out.println("ef instanceof Car is true");
		}else{
			System.out.println("ef instanceof Car is false");
		}
		
		if(ex instanceof Car){
			System.out.println("ex instanceof Car is true");
		}else{
			System.out.println("ex instanceof Car is false");
		}
		
		if(ca instanceof Car){
			System.out.println("ca instanceof Car is true");
		}else{
			System.out.println("ca instanceof Car is false");
		}
		
	/*
			System.out.println("p instanceof Car is true");
		} 상속관계가 아니므로 될수없다.*/		
	}
}	
