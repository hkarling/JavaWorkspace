//MakeMethodExam.java
class MakeMethodExam{
	public static void main(String []args){
		MakeMethodExam mme=new MakeMethodExam();
		int k=mme.methodExam01(33);
		System.out.println(k);
		mme.methodExam02();
		mme.methodExam03(42);
		String s = mme.methodExam04(17);
		System.out.println(s);
	}
	/*
		Method�̸� : methodExam01
		�ڱ��ڽŸ� ���ٰ���
		Return Type : ����
		Parameter : ����1��
		(�����ο���)�ϴ��� : 
		�μ��� ����(����)������ ����ϰ� �μ��� 2�� ���� Return
	*/
	private int methodExam01(int i) {
		System.out.println("methodExam01: " + i);
		return i*2;
	}
	
	/*
		Method�̸� : methodExam02
		��𿡼��� �ƹ��� ���ٰ���
		Return ����	
		Parameter ����
		(�����ο���)�ϴ��� : �ƹ��ų� ���
	*/
	public void methodExam02() {
		System.out.println("methodExam02: �ƹ��ų� ���");
	}
	
	/*
		Method�̸� : methodExam03
		����pakage������ �ƹ��� ���ٰ���
		Return Type : Return ����
		Parameter : ����1��	
		(�����ο���)�ϴ��� : �μ��� ����(����) ������ ����ϰ� �� ���� ¦����� "¦��",Ȧ����� "Ȧ��" ���
	*/
	void methodExam03(int i) {
		
		System.out.println("methodExam03: " + i);

		String result = "Ȧ��";
		
		if (i%2 == 0) {
			result = "¦��";
		}

		System.out.println(result);
	}

	/*
		Method�̸� : methodExam04
		��Ӱ����� ��𼭳� ���ٰ���
		Return Type : StringŸ��
		Parameter : ����1��	
		(�����ο���)�ϴ��� : �μ��� ����(����) ������ ����ϰ� �� ���� ¦����� "¦��", Ȧ����� "Ȧ��" ����
	*/
	protected String methodExam04(int i) {
		
		System.out.println("methodExam04: " + i);
		String result = "Ȧ��";
		
		if (i%2 == 0) {
			result = "¦��";
		}

		return result;
	}	
}

