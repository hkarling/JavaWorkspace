package constructor;

/**
 * StudentArrayExam
 */
public class StudentArrayExam {

    public static void main(String[] args) {
        // 초기치 학생정보 5명을 선언
        String[][] data = new String[][] { { "아아아", "10", "서울" }, { "가가가", "20", "대전" }, { "나나나", "30", "광주" },
                { "다다다", "40", "대구" }, { "라라라", "50", "부산" } };

        StudentService service = new StudentService();
        service.insert(data);
        service.printTable();
        System.out.println("---- Serch by name ----");
        service.searchByName("다다다");
        service.searchByName("깔깔깔");

        System.out.println("---- Modify ----");

        Student student = new Student();
        student.setName("다다다");
        student.setAge(90);
        student.setAddress("강릉");
        service.update(student);

    }
}