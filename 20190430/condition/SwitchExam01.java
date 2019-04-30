class SwitchExam01{
	public static void main(String [] args){
		/**
	     난수를 1~10사이를 발생한다.
		 발생한 난수의 값이 1이면 일요일, 2이면 월요일,
		 3이면 화요일, 4이면 수요일, 5이면 목요일
		 6이면 금요일, 이후의 값은 토요일 출력한다.
		*/
		int no = (int)(Math.random()*10)+1; 
			char yioll='토';
		switch(no){
			case 1:
				  yioll='일';//break;
			case 2:
				  yioll='월';//break;
			case 3:
				  yioll='화';//break;
			case 4:
				  yioll='수';//break;
			case 5:
				  yioll='목';//break;
			case 6:
				  yioll='금';
				break;
			 // default :  yioll='토';
		}
		
		System.out.println(no+"는 " + yioll+"요일 입니다.");
	}
}