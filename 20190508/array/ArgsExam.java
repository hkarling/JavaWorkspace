
public class ArgsExam {
    public static void main(String[] args) {
        System.out.println("args = " + args);
        System.out.println("args.length = " + args.length);

        // 출력
        for (String str : args) {
            System.out.println(str);
        }

        // 배열의 length는 호출될때마다 새로 구하므로 특정 변수에 저장을 해놓고 쓰는 것이 좋다.
        // int i = array.length;
    }
}
/**
 * -- 실행할때 값을 전달. 
 * java ArgsExam (전달인자)
 */