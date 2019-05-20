package ch09q06;

public class Chatting {

	void startChat(String chatId) {
		/*String nickName = null;
		nickName = chatId;*/
		String nickName = chatId;	// 익명 객체 내부에서 메소드의 매개변수나 로컬 변수를 사용하는 경우 final특성을 가져야한다.

		Chat chat = new Chat() {

			@Override
			void start() {
				while (true) {
					String inputData = "안녕하세요";
					String message = "[" + nickName + "]" + inputData;
					sendMessage(message);
				}
			}
		};
		chat.start();
	}

	class Chat {
		void start() {
		}

		void sendMessage(String message) {
		}
	}
}
