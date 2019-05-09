/**
 * Service는 Business Logic을 담당하는 클래스 (업무를 처리하는 객체)
 */
public class StudentService {
    Student[] arrStudent;

    // 학생정보 등록하기
    void insert(String[][] data) {

        arrStudent = new Student[data.length];

        for (int i = 0; i < 5; i++) {
            arrStudent[i] = this.creatStudent(data[i]);
        }
    }

    // Student 객체를 생성하여 값을 설정하고 반환
    private Student creatStudent(String[] info) {

        Student student = new Student();
        student.setName(info[0]);
        student.setAge(Integer.parseInt(info[1]));
        student.setAddress(info[2]);

        return student;
    }

    // 학생정보 출력하기
    public void printTable() {
        System.out.println("--- 모든 학생 list(" + arrStudent.length + "명) ---");
        for (Student s : arrStudent) {
            System.out.println(s.getName() + "\t" + s.getAge() + "\t" + s.getAddress());
        }
    }
    // 학생 이름에 해당하는 정보 검색
    public void searchByName(String name) {
        for(Student student : arrStudent) {
            if(student.getName().equals(name)){
                System.out.println(student.getName() + "\t" + student.getAge() + "\t" + student.getAddress());
                return;
            }
        }
        System.out.println(name + " 학생의 정보가 없습니다.");
    }
    // 학생 이름에 해당하는 나이와 주소 변경
    public void update(Student student) {
        for(Student st : arrStudent) {
            if(student.getName().equals(student.getName())){
                st.setName(student.getName());
                st.setAge(student.getAge());
                st.setAddress(student.getAddress());

                
                System.out.println(student.getName() + "\t" + student.getAge() + "\t" + student.getAddress());
                return;
            }
        }
    }
}