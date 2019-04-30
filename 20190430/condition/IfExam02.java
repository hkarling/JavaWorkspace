class IfExam02{
   public static void main(String [] args){
      //난수 발생
	  double no = Math.random()*10 + 1;//0.0 ~ 0.99999
      int convertNo = (int)no;

	  System.out.println("난수 no = " + no);
	  System.out.println("난수 convertNo = " + convertNo);

      /**
	     난수를 1~10사이를 발생한다.
		 발생한 난수의 값이 1이면 일요일, 2이면 월요일,
		 3이면 화요일, 4이면 수요일, 5이면 목요일
		 6이면 금요일, 이후의 값은 토요일 출력한다.
	  */
       char yoil='토';
	  if(convertNo==1)
		  yoil='일';
	  else if(convertNo==2)
		  yoil='월';
	  else if(convertNo==3)
		  yoil='화';
	  else if(convertNo==4)
		  yoil='수';
	  else if(convertNo==5)
		  yoil='목';
	  else if(convertNo==6)
		  yoil='금';
	 // else yoil='토';

	 System.out.println(convertNo+"는 " + yoil+ "요일 입니다.");

   }
}