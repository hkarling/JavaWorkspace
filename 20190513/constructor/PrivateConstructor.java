class Test {
    static Test test = new Test(); // Singletone 객체

    // 외부에서 객체를 직접생성하지 못하도록 막는다.
    private Test(){}
    
    // 내부적으로 직접 현재 객체를 생성해서 리턴하는 메소드를 작성.
    public static Test getInstance(){
        return test;
    }

}
/////////////////////////////////////////////////
public class PrivateConstructor {

    public static void main(String[] args) {
        Test t1 = Test.getInstance();
        Test t2 = Test.getInstance();
        Test t3 = Test.getInstance();

        System.out.println("t1 = " + t1);
        System.out.println("t2 = " + t2);
        System.out.println("t3 = " + t3);
    }
}