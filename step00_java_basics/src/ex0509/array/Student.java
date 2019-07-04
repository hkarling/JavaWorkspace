package ex0509.array;

/**
 * Student
 */
public class Student {
    /*
     * 학생이 가질 수 있는 속성을 선언: 외부에서 직접 접근 불가능
     */
    private String name;
    private int age;
    private String address;

    // 메소드를 이용해서 조회 또는 저장할 수 있도록 set/get 작성
    /*
     * setXxx(): public, 리턴 x, 인수필수 getXxx(): public, 리턴필수, 인수없음
     */

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        if (age < 18) {
            System.out.println("나이는 18세 이상만 가능합니다.");
            return; // 함수를 빠져나가라.
        }
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}