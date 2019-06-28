package ex0628.dto;

public class productDTO {
    private String code = "A01";
    private String name = "새우깡";
    private int price = 3500;
    private int qyt = 5;

    public productDTO() {
        System.out.println("productDTO 생성됨...");
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQyt() {
        return qyt;
    }
}
