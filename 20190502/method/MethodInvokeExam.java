//������ ���� �޼ҵ带 �ۼ��ϼ���.
class Methodinvoke01 {
	/*
		method �̸� : method01
		��𼭳� ������ ���ٰ���
		���� ����
		�μ��� ����2�� ����
		�μ��� ���� ���� 2���� ���ؼ� ����ϰ� ����
	*/
	public int method01(int i, int j) {
		int result = i * j;
		System.out.println("Methodinvoke01.method01: " + result);
		return result;
	}
}

class Methodinvoke02 {
	/*
		method �̸� : method02
		��𼭳� ������ ���ٰ���,��ü�� �������� �ʰ� ���ٰ���
		���� ����
		�μ��� ����2�� ����
		�μ��� ���� ���� 2���� ���ؼ� ����ϰ� ���Ѽ� ����	
	*/
	public static int method02(int i, int j) {
		int result = i + j;
		System.out.println("Methodinvoke02.method02: " + result);
		return result;
	}
}

class MethodInvokeExam{
	public static void main(String []args){
		
		//MethodInvoke01�� method01 ȣ��
		Methodinvoke01 obj = new Methodinvoke01();
		obj.method01(3, 4);

		//MethodInvoke02�� method02 ȣ��
		Methodinvoke02.method02(3, 4);
	}
}

