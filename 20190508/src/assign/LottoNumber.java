package assign;

/**
 * 이름: 윤참솔
 * 날짜: 5월 8일
 * 문제: 3. 로또번호 6개를 배열방에서 중복되지 않게 만들어서 출력하기 (1 ~ 45까지) 출력을 할때
 *      내림차순으로 출력하게 한다.
 *      조건 : 1) 중복체크하는 메소드
 *            2) 숫자 6개를 배열방에 저장하는 메소드
 *            3) 배열방의 값을 내림차순으로 정렬하는 메소드
 *            4) 배열의 값을 화면에 출력하는 메소드
 */
class LottoNumber {
    private int[] lotto = new int[6];

    // 1) 중복체크 하는 메소드: 인수로 '입력할 숫자'와 '넣을 장소'를 받아온다
    private boolean checkDuplicate(int newNumber, int index) {

        // 배열의 제일 앞에서부터 중복을 검사한다
        for (int i = 0; i < index; i++) {
            if (this.lotto[i] == newNumber) // 같은 숫자가 았으면 false를 반환하고 메서드를 닫는다
                return false;
        }
        return true; // loop가 종료할때까지 같은 숫자가 나오지 않으면 true를 반환한다
    }

    // 2) 숫자 6개를 배열방에 저장하는 메소드
    public void saveNumbers() {
        int index = 0;
        while (index < 6) { // 6번째 칸까지 loop문을 진행한다
            int temp = (int) (Math.random() * 45 + 1); // 임의의 난수를 발생시킨다

            if (this.checkDuplicate(temp, index)) { // 중복검사를 하여 문제가 없다면 이하 실행
                this.lotto[index] = temp;
                index++;
            }
        }
        this.sortNumbers(); // 숫자를 정렬하는 메서드를 호출한다
    }

    // 3) 배열방의 값을 내림차순으로 정렬하는 메소드: 버블정렬을 사용한다
    private void sortNumbers() {
        for (int i = 5; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (this.lotto[j] < this.lotto[j + 1]) { // 앞의 숫자가 뒤의 숫자보다 작으면 자리를 바꾼다
                    int temp = this.lotto[j];
                    this.lotto[j] = this.lotto[j + 1];
                    this.lotto[j + 1] = temp;
                }
            }
        }
    }

    // 4) 배열의 값을 화면에 출력하는 메소드
    public void print() {
        System.out.print("로또번호: ");
        for (int i : lotto)
            System.out.print(i + " ");
        System.out.println();
    }

    // 메인메서드
    public static void main(String[] args) {
        LottoNumber lottoNumber = new LottoNumber();
        lottoNumber.saveNumbers();      // 숫자를 저장하는 메서드 호출
        lottoNumber.print();            // 출력
    }
}