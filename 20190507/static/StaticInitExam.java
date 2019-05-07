class StaticInitExam {
	int no;

	public static void main(String[] args) {
		System.out.println("**** Main 시작 ****");
	}

	/**
	 * 최초 데이터 초기화, 환경설정정보 세팅, DB로드, 데이터들 로드	
	 */
	static {
		System.out.println("**** static 블록: main 메소드보다 먼저 실행된다 ****");
		//System.out.println(no);		// non-static 멤버에 접근불가
	}
}