/**
 * 이름: 윤참솔 날짜: 5월 9일 주제: MainApp 클래스
 */
public class MainApp {

    public static void main(String[] args) {
        // 초기치 데이터 2번항목이 메인메소드에 있다.
        String data[][] = { { "100", "에어컨", "250000", "삼성 무풍에어컨" }, { "200", "세탁기", "350000", "LG 세탁짱" },
                { "300", "냉장고", "500000", "냉장고입니다." }, { "400", "전자렌지", "640000", "전자렌즈입니다." },
                { "500", "밥통", "450000", "쿠쿠밥솥 최고!" }, };

        ElectronicsService service = new ElectronicsService();

        // ElectronicsService의 save를 호출한다.
        service.save(data);

        // ElectronicsService의 printAll() 호출한다.
        System.out.println();
        service.printAll();
        
        // ElectronicsService의 searchBymodelNo(int modelNo) 호출한다. (modelNo는 실행할때
        // 인수(args)로 전달된 정보를 준다)
        System.out.println();
        service.searchBymodelNo(700);
        System.out.println();
        service.searchBymodelNo(300);

        // ElectronicsService의 update() 호출한다.
        service.update(new Electronics(700,"뭐를",999999,"고치라고"));
        service.update(new Electronics(300,"뭐를",999999,"고치라고"));
        
    }
}