package ex0508.assign;

/**
 * 문제: 1. int arr [] = {5,7,1,2,4,3,8,9,6,10}  배열방에 있는
 *      데이터를 올림차순으로 정렬하여 출력한다.(버블정렬, 선택정렬, 삽입정렬)
 */
class SortEx {
    int[] arr = {5, 7, 1, 2, 4, 3, 8, 9, 6, 10};

    // 버블정렬을 시행하여 결과를 반환
    public int[] bubbleSort() {
        int[] result = arr.clone();             // arr의 항목을 을 복사하여 result에 저장한다
        
        for(int i = 9; i > 0; i--) {            // 최대 9회 반복
            for(int j = 0; j < i; j++) {        // 점차 1회씩 줄여간다.
                if(result[j] > result[j+1]) {   // 앞의 숫자가 뒤의 숫자보다 크면
                    int temp = result[j];       // 자리를 교체한다.
                    result[j] = result[j+1];
                    result[j+1] = temp;
                }
            }
        }
        return result; 
    }

    // 선택정렬을 시행하여 결과를 반환
    public int[] selectSort() {
        int[] result = arr.clone();             // arr 복사
        
        for(int i = 0; i < 9; i++) {            // 9회 반복한다
            int smallValue = i;                 // 최소값을 가진 칸을 기억할 공간을 마련
            for(int j = i; j < 9; j++) {        // 각 회차마다 배열의 i번째부터 시작한다
                if(result[smallValue] > result[j+1]){
                    smallValue = j+1;
                }
            }
            int temp = result[i];               // 최소값을 가진 칸과 제일 첫 칸을 교환한다.
            result[i] = result[smallValue];
            result[smallValue] = temp;
        }

        return result;
    }

    // 삽입정렬을 시행하여 결과를 반환
    public int[] insertSort() {
        int[] result = arr.clone();             // arr 복사
        
        for(int i = 1; i < 10; i++) {           // 9번 반복
            for(int j = i; j > 0; j--){         // 각 회차별로 가장 뒤에서부터 앞으로 검색한다.
                if(result[j-1] > result[j]) {   // 앞의 값이 뒤의 값보다 크면 자리를 옮긴다.
                    int temp = result[j];
                    result[j] = result[j-1];
                    result[j-1] = temp;
                }
                else
                    break;                      // 앞의 값이 뒤의 값보다 작으면 끝낸다.
            }
        }
        return result;
    }

    // 배열을 전달받아 출력하는 메소드
    public void printArr(int[] arrInt) {
        System.out.print("배열: ");
        for(int i : arrInt)
            System.out.print(i + " ");
        System.out.println();
    }

    // 메인 메소드!!
    public static void main(String[] args) {
        SortEx sortEx = new SortEx();
        
        // 버블정렬
        System.out.println("--------- 버블 정렬 ----------");
        sortEx.printArr(sortEx.arr);
        sortEx.printArr(sortEx.bubbleSort());

        // 선택정렬
        System.out.println("--------- 선택 정렬 ----------");
        sortEx.printArr(sortEx.arr);
        sortEx.printArr(sortEx.selectSort());

        // 삽입정렬
        System.out.println("--------- 삽입 정렬 ----------");
        sortEx.printArr(sortEx.arr);
        sortEx.printArr(sortEx.insertSort());
    }
}