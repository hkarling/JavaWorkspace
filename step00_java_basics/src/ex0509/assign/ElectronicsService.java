package ex0509.assign;

/**
 * 주제: ElectronicsService 클래스
 */
public class ElectronicsService {
    Electronics electronics[] = new Electronics[5];

    public void save(String[][] data) {
        for (int i = 0; i < 5; i++) {
            electronics[i] = new Electronics();
            electronics[i].setModelNo(Integer.parseInt(data[i][0]));
            electronics[i].setModelName(data[i][1]);
            electronics[i].setModelPrice(Integer.parseInt(data[i][2]));
            electronics[i].setModelDetail(data[i][3]);
        }
    }

    public void printAll() {
        System.out.println("****** 전자제품 LIST ************");
        for (Electronics obj : electronics) {
            System.out.print("모델번호: " + obj.getModelNo() + "\t");
            System.out.print("모델이름: " + obj.getModelName() + "\t");
            System.out.print("가격: " + obj.getModelPrice() + "\t");
            System.out.println("설명: " + obj.getModelDetail());
        }
    }

    public void searchBymodelNo(int modelNo) {
        System.out.println("인수" + modelNo + "인 경우");
        for (Electronics obj : electronics) {
            if (obj.getModelNo() == modelNo) {
                System.out.print("결과 : ");
                this.printSingle(obj);
                return;
            }
        }
        System.out.println("결과 : 모델번호 " + modelNo + "에 해당하는 정보가 없습니다.");
    }

    public void update(Electronics inputElectronics) {
        System.out.println("모델넘버 " + inputElectronics.getModelNo() + " 항목을 수정");
        for (Electronics obj : electronics) {
            if (obj.getModelNo() == inputElectronics.getModelNo()) {
                System.out.print("수정전 : ");
                this.printSingle(obj);

                obj.setModelName(inputElectronics.getModelName());
                obj.setModelPrice(inputElectronics.getModelPrice());
                obj.setModelDetail(inputElectronics.getModelDetail());

                System.out.print("수정후 : ");
                this.printSingle(obj);
                return;
            }
        }
        System.out.println("결과 : 모델번호 " + inputElectronics.getModelNo() + "에 해당하는 정보가 없습니다.");
    }

    // 단독 상품을 출력한다.
    private void printSingle(Electronics obj) {
        System.out.print("모델번호: " + obj.getModelNo() + "\t");
        System.out.print("모델이름: " + obj.getModelName() + "\t");
        System.out.print("가격: " + obj.getModelPrice() + "\t");
        System.out.println("설명: " + obj.getModelDetail());
    }
}