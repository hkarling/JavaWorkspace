package array;

public class MultiArrayExam {
    // int[][] arr = new int[3][4];
    int[][] arr = new int[][] { { 1, 2, 3, 4, 5 }, { 1, 2 }, { 1, 2, 3, 4, 5, 6, 7, 8 }, { 1, 2, 3, 4 } };

    String[][] strArr = new String[3][];

    public void test() {
        System.out.println("arr = " + arr);
        System.out.println("arr.length = " + arr.length); // 행의 길이
        System.out.println("arr[0].length = " + arr[0].length); // 0행의 길이

        System.out.println("arr[0] = " + arr[0]);
        System.out.println("arr[1] = " + arr[1]);
        System.out.println("arr[0][0] = " + arr[0][0]);
        System.out.println();

        // 배열의 모든 값을 3행 4열 모양으로 출력
        for (int[] i : arr) {
            for (int j : i)
                System.out.print(j + " ");
            System.out.println();
        }

        System.out.println("-------------------------------");
        System.out.println("strArr = " + strArr);
        System.out.println("strArr[0] = " + strArr[0]);
        // System.out.println("strArr[0][0] = " + strArr[0][0]);

        // 각 행마다 열을 생성한다.
        for (int i = 0; i < 3; i++)
            strArr[i] = new String[i + 1];

        for (String[] i : strArr) {
            for (String j : i)
                System.out.print(j + " ");
            System.out.println();
        }

    }

    public static void main(String[] args) {
        new MultiArrayExam().test(); // 실행만
    }
}