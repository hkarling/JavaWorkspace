package assign;

public class StudentController {
    StudentService service = StudentService.getInstance();

    // 등록
    public void insert(Student student) {
        if (service.searchById(student.getStudentNumber()) == null) {
            if (service.insert(student))
                StudentResultView.printMessage("**입력성공**");
            else
                StudentResultView.printMessage("**입력실패**");

        } else {
            StudentResultView.printMessage("중복된 학번으로는 입력불가.");
        }
    }

    // 전체검색
    public void printAll() {
        Student[] result = service.selectAll();
        StudentResultView.printAll(result);
    }

    // 학번검색
    public void searchById(int studentNumber) {
        Student result = service.searchById(studentNumber);
        if (result != null)
            StudentResultView.printSingle(result);
        else
            StudentResultView.printMessage("ERR: 학생번호 " + studentNumber + " 없음");
    }

    // 수정
    public void update(Student student) {
        if (service.update(student)) {
            StudentResultView.printMessage("수정되었습니다.");
        } else {
            StudentResultView.printMessage("ERR: 수정안됨");
        }
    }

}