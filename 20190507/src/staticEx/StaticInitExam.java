package staticEx;

class StaticInitExam {
	int no;

	public static void main(String[] args) {
		System.out.println("**** Main 실행 ****");
	}

	/**
	 * 최초의 데이터 초기화, 환경설정정보 세팅, DB로드, 데이터들 로딩
	 */
	static {
		System.out.println("**** static 블럭: main 메소드보다 먼저 실행 ****");
		//System.out.println(no);		// non-static 접근불가
	}
}