class CastingExam{
	// 실행을 필요한 메인 메소드
	public static void main(String []args){
		byte b1;
		byte b2,b3; 
		int i1=7;
		System.out.println("int i1="+i1);

		b1=(byte)i1 ;
		System.out.println("byte b1="+b1);

		b2=20;
		System.out.println("byte b2="+b2);
		
	   	b3=(byte)(b2+b1); // 연산을 하면 최소한 4byte 공간이 필요하기 때문에 형변환 필요함

		System.out.println("byte b3="+b3);
		
		long lo=56897L;
		System.out.println("long lo="+lo);
		
		//int i4=(int)(lo+i1); 
		int i4=(int)lo+i1; 
		System.out.println("int i4="+i4);
		
		boolean boo;
		boo=false; // 논리형은 true false만 있다.
		
		System.out.println("boolean boo="+boo);

		double d=4.67e-3; //0.00467
		System.out.println("double d="+d);

		float f1=lo;
		System.out.println("float f1="+f1);
				
		
	    float f2=(float)d;
		System.out.println("float f2="+f2);

		char c1,c2, c3;
		c1='\u0167';
		System.out.println("char c1="+c1);

		b2=(byte)c1; 
		System.out.println("byte b2="+b2);
		
		c2='가';
		System.out.println("char c2="+c2);
		
		b2=(byte)c1;
		System.out.println("byte b2="+b2);
		
		c3=(char)(c2+2);
		System.out.println("char c3="+c3);
		
		
	}

}