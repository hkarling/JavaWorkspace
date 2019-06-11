package project.model.dto;

public class CustomerDTO {

    private String id; // 아이디
    private String name; // 이름
    private String phone; // 전화번호
    private String mileage; // 마일리지

    public CustomerDTO() {

    }

    public CustomerDTO(String id, String name, String phone, String mileage) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.mileage = mileage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    @Override
    public String toString() {
        return "id='" + id + '\'' + ", name='" + name + '\'' + ", phone='" + phone + '\'' + ", mileage='" + mileage;
    }
}
