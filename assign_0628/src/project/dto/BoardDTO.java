package project.dto;

/**
 * 코멘트에 대한 정보를 담는 클래스입니다.
 */
public class BoardDTO {
    private String name;
    private String subject;
    private String date;

    public BoardDTO() {
    }

    public BoardDTO(String name, String subject, String date) {
        this.name = name;
        this.subject = subject;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
