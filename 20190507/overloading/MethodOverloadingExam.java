//MethodOverloadingExam.java
class OverloadedMethod{

	private int i;
       
	public void setOverload(int i){
		System.out.println("void setOverload(int i) ȣ��");
		this.i = i;
	}
	
	public int getOverload(){
		System.out.println("int getOverload() ȣ��");
		return i;
	}
	
	//setOverload�� Overloading�ϼ���. ���ϵ� �ϼ���.
	public int setOverload(){
		System.out.println("int setOverload() ȣ��");
		return this.i;
	}

	//setOverload�� �� Overloading �ϼ���. �� �ٸ� ������ ���� �ϼ���.
	public int setOverload(int i, int j){
		System.out.println("int setOverload(int i, int j) ȣ��");
		return j;
	}

	//setOverload�� �� ��Overloading �ϼ���. ���� ���ؿ�
	public void setOverload(String str) {
		System.out.println("void setOverload(String str) ȣ��");
	}

	//getOverload�� Overloading�ϼ���. ���ϵ� �ϼ���.
	public int getOverload(OverloadedMethod obj){
		System.out.println("int getOverload(OverloadedMethod obj) ȣ��");
		return i;
	}

	//getOverload�� �� Overloading �ϼ���. �� �ٸ� ������ ���� �ϼ���.
	public String getOverload(String str){
		System.out.println("String getOverload(String str) ȣ��");
		return str;
	}
	//getOverload�� �� ��Overloading �ϼ���. ���� ���ؿ�
	public void getOverload(int i, int j){
		System.out.println("void getOverload(int i, int j) ȣ��");
	}
}

class  MethodOverloadingExam{
	public static void main(String [] agr){

		//OverloadedMethod��ü���� ȣ�Ⱑ����  �޼ҵ���� �ѹ��� ȣ���ϼ���.
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

