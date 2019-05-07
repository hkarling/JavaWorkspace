// UsingMethod.java
// �Ʒ��� ���� �޼ҵ带 �ۼ��ϼ���.
class UsingMethodExam{
	/*
		Method�̸�:  methodExam03_01
		�ڱ��ڽŸ� ���ٰ���
		ReturnType: ����
		Parameter: ���� 1��
		(�����ο���)�ϴ� �� : 
				methodExam03_01�� ȣ��Ǿ����ϴ�. ���
				�μ��� ���� ���� ��� 
				����*2 ����. 
	*/
	private int methodExam03_01(int i) {
		System.out.println("methodExam03_01 ȣ��: " + i);
		
		return i*2;
	}
	/*	Method�̸� :  methodExam03_02
		��𼭳� �ƹ��� ���ٰ���
		Return String
		Parameter : String 1��, ���� 1��
		(�����ο���)�ϴ� �� : 
				methodExam03_02�� ȣ��Ǿ����ϴ�. ���
				�μ��� ���� String �� �ٺ��� �ٿ��� ���
				�ι�°�μ��� ���� ���� methodExam03_01�� �־� �ָ� methodExam03_01�� ȣ���ϰ� �����ϴ� ���� ���
				�μ��� ���� String �� �ٺ��� �ٿ��� ����
	*/	
	public String methodExam03_02(String str, int a) {
		System.out.println("methodExam03_02 ȣ��: " + str + ", " + a);
		System.out.println(str + "�ٺ�");
		int res = this.methodExam03_01(a);
		System.out.println("methodExam03_01 ���ϰ�: " + res);
		
		return str + "�ٺ�";
	}
	/*	Method�̸� :  methodExam03_03
		���� package���� �ƹ��� ���� ����
		ReturnType : ���Ͼ���
		Parameter : ���� 1���� String 1��
		(�����ο���)�ϴ� �� : 
				methodExam03_03�� ȣ��Ǿ����ϴ�. ���
				�μ��� ���� ���� 1���� String 1���� �Ѱ��ָ�
				methodExam03_02ȣ��
	*/
	void methodExam03_03(int i, String str) {
		System.out.println("methodExam03_03 ȣ��: " + str + ", " + i);
		this.methodExam03_02(str, i);
	}
	/*	Method�̸� :  methodExam03_04
		��Ӱ����� ��𼭳� ���� ����
		ReturnType : �Ǽ�(�ε��Ҽ���)
		Parameter : ù��° �μ�(����),�ι�° �μ�(�Ǽ�), ����°�μ�(����)
		(�����ο���)�ϴ� �� : 
				methodExam03_04�� ȣ��Ǿ����ϴ�. ���
				�μ��� ���� ���� �̿��� MakeMethodExam02��ü�� methodExam02_04�޼ҵ� ȣ���ϰ�
				method02_04�� �����ϴ� ���� ����
	*/
	protected double methodExam03_04(int i, double d, int j) {
		System.out.println("methodExam03_04 ȣ��: " + i + ", " + d + ", " + j);
		MakeMethodExam02 obj = new MakeMethodExam02();

		return obj.methodExam02_04(i, d, j);
	}
} // UsingMethodExam ��

class UsingMethod{
	// ���θ޼ҵ忡�� UsingMethodExam�� ȣ�Ⱑ���� �޼ҵ���� ȣ���ϰ� �����ϴ� �� �ִٸ� ���
	public static void main(String[] args) {
		UsingMethodExam obj = new UsingMethodExam();
		
		// obj.methodExam03_01(3);
		String str = obj.methodExam03_02("��Ʈ��", 3);
		System.out.println("���ϰ�: " + str);

		obj.methodExam03_03(5, "String");
		
		double d = obj.methodExam03_04(3, 4.0, 5);
		System.out.println("���ϰ�: " + d);
	}
}