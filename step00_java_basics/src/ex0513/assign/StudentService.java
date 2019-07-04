package ex0513.assign;

public class StudentService {
    private static StudentService instance = new StudentService();

    Student[] students = new Student[100];
    public static int count;

    String data[][] = { { "10", "장희정", "18", "서울" }, { "20", "장동건", "45", "대구" }, { "30", "고소영", "35", "부산" } };

    private StudentService() {
        for (String[] row : data) {
            students[count++] = new Student(Integer.parseInt(row[0]), row[1], Integer.parseInt(row[2]), row[3]);
        }
    }

    public static StudentService getInstance() {
        return instance;
    }

    // 입력하기
    public boolean insert(Student student) {
        if (count == students.length)
            return false;
        students[count++] = student;
        return true;
    }

    // 배열 전체 반환
    public Student[] selectAll() {
        return students;
    }

    // 학번으로 찾기
    public Student searchById(int studentNumber) {
        for (int i = 0; i < count; i++) {
            if (students[i].getStudentNumber() == studentNumber)
                return students[i];
        }
        return null;
    }

    // 수정하기
    public boolean update(Student student) {
        Student item = this.searchById(student.getStudentNumber());
        if (item != null) {
            item.setAge(student.getAge());
            item.setAddress(student.getAddress());
            return true;
        }
        return false;
    }
}