class SwitchExam01{
	public static void main(String [] args){
		/**
	     ������ 1~10���̸� �߻��Ѵ�.
		 �߻��� ������ ���� 1�̸� �Ͽ���, 2�̸� ������,
		 3�̸� ȭ����, 4�̸� ������, 5�̸� �����
		 6�̸� �ݿ���, ������ ���� ����� ����Ѵ�.
		*/
		int no = (int)(Math.random()*10)+1; 
			char yioll='��';
		switch(no){
			case 1:
				  yioll='��';//break;
			case 2:
				  yioll='��';//break;
			case 3:
				  yioll='ȭ';//break;
			case 4:
				  yioll='��';//break;
			case 5:
				  yioll='��';//break;
			case 6:
				  yioll='��';
				break;
			 // default :  yioll='��';
		}
		
		System.out.println(no+"�� " + yioll+"���� �Դϴ�.");
	}
}