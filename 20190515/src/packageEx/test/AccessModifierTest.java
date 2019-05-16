package packageEx.test;

import packageEx.exam.MessageBean;

public class AccessModifierTest {

	public AccessModifierTest() {
		MessageBean bean = new MessageBean();
		bean.korMessage();
	}
	
	public static void main(String[] args) {
		new AccessModifierTest();
		
		int i = MessageBean.DEEN;
		System.out.println(i);
	}
}
