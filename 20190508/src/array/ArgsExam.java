package array;

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

        // 만약 인수 2개가 숫자로 전달되었다고 가정하고 전달된 두 수의 합을 구한다.
        int result = 0;
        for (String str : args) {
            result += Integer.parseInt(str);
        }
        /*
         * - 문자열(String) -> 숫자(int)로 변환 int i = Integer.parseInt(String str); - 숫자(int)
         * -> 문자열(String)로 변환 String str = Integer.toString(int i);
         */
        System.out.println("합 = " + result);
    }
}
/**
 * -- 실행할때 값을 전달. java ArgsExam (전달인자)
 */