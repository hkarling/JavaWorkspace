//MethodOverloadingExam.java
class OverloadedMethod{

	private int i;
       
	public void setOverload(int i){
		System.out.println("void setOverload(int i) 호출");
		this.i = i;
	}
	
	public int getOverload(){
		System.out.println("int getOverload() 호출");
		return i;
	}
	
	//setOverload를 Overloading하세요. 리턴도 하세요.
	public int setOverload(){
		System.out.println("int setOverload() 호출");
		return this.i;
	}

	//setOverload를 또 Overloading 하세요. 또 다른 놈으로 리턴 하세요.
	public int setOverload(int i, int j){
		System.out.println("int setOverload(int i, int j) 호출");
		return j;
	}

	//setOverload를 또 또Overloading 하세요. 리턴 안해요
	public void setOverload(String str) {
		System.out.println("void setOverload(String str) 호출");
	}

	//getOverload를 Overloading하세요. 리턴도 하세요.
	public int getOverload(OverloadedMethod obj){
		System.out.println("int getOverload(OverloadedMethod obj) 호출");
		return i;
	}

	//getOverload를 또 Overloading 하세요. 또 다른 놈으로 리턴 하세요.
	public String getOverload(String str){
		System.out.println("String getOverload(String str) 호출");
		return str;
	}
	//getOverload를 또 또Overloading 하세요. 리턴 안해요
	public void getOverload(int i, int j){
		System.out.println("void getOverload(int i, int j) 호출");
	}
}

class  MethodOverloadingExam{
	public static void main(String [] agr){

		//OverloadedMethod객체에서 호출가능한  메소드들을 한번씩 호출하세요.
		OverloadedMethod obj = new OverloadedMethod();

		obj.setOverload(1);
		obj.setOverload();
		obj.setOverload(1, 4);
		obj.setOverload("HELLO");

		obj.getOverload();
		obj.getOverload(obj);
		obj.getOverload("HELLO");
		obj.getOverload(2,3);

	}
}

