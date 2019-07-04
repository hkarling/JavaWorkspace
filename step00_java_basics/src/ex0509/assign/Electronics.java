package ex0509.assign;

/**
 * 주제: Electronics 클래스
 */
public class Electronics {
    private int modelNo;
    private String modelName;
    private int modelPrice;
    private String modelDetail;

    //////// 생성자 ////////
    public Electronics() {
    }

    public Electronics(int modelNo, String modelName) {
        this.modelNo = modelNo;
        this.modelName = modelName;
    }

    public Electronics(int modelNo, String modelName, int modelPrice, String modelDetail) {
        this(modelNo, modelName);
        this.modelPrice = modelPrice;
        this.modelDetail = modelDetail;
    }

    //////// Setter, Getter ////////
    public void setModelDetail(String modelDetail) {
        this.modelDetail = modelDetail;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setModelNo(int modelNo) {
        this.modelNo = modelNo;
    }

    public void setModelPrice(int modelPrice) {
        this.modelPrice = modelPrice;
    }

    public String getModelDetail() {
        return modelDetail;
    }

    public String getModelName() {
        return modelName;
    }

    public int getModelNo() {
        return modelNo;
    }

    public int getModelPrice() {
        return modelPrice;
    }
}