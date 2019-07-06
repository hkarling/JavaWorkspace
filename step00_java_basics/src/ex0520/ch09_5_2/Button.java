package ex0520.ch09_5_2;

public class Button {
	OnClickListener listener;	// 인스턴스 타입 필드 

	void setOnClickListener(OnClickListener listener) {	// 매개변수의 다형
		this.listener = listener;
	}
	
	void touch() {
		listener.onClick();	// 구현 객체의 onClick() 메소드 호출 
	}

	interface OnClickListener {	// 중첩 인터페이스
		void onClick();
	}
}
