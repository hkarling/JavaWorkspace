class IfExam02{
   public static void main(String [] args){
      //���� �߻�
	  double no = Math.random()*10 + 1;//0.0 ~ 0.99999
      int convertNo = (int)no;

	  System.out.println("���� no = " + no);
	  System.out.println("���� convertNo = " + convertNo);

      /**
	     ������ 1~10���̸� �߻��Ѵ�.
		 �߻��� ������ ���� 1�̸� �Ͽ���, 2�̸� ������,
		 3�̸� ȭ����, 4�̸� ������, 5�̸� �����
		 6�̸� �ݿ���, ������ ���� ����� ����Ѵ�.
	  */
       char yoil='��';
	  if(convertNo==1)
		  yoil='��';
	  else if(convertNo==2)
		  yoil='��';
	  else if(convertNo==3)
		  yoil='ȭ';
	  else if(convertNo==4)
		  yoil='��';
	  else if(convertNo==5)
		  yoil='��';
	  else if(convertNo==6)
		  yoil='��';
	 // else yoil='��';

	 System.out.println(convertNo+"�� " + yoil+ "���� �Դϴ�.");

   }
}