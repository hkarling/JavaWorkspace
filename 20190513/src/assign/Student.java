package assign;

public class Student {
    private int studentNumber;
    private String name;
    private int age;
    private String address;

    public Student() { }
    public Student(int studentNumber, String name, int age, String address) {
        this.studentNumber = studentNumber;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public int getStudentNumber() {
        return studentNumber;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getAddress() {
        return address;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}