package ex0521.assign.electronics;

/**
 * 주제: Electronics 클래스
 */
public class Electronics {
	private int modelNo;
	private String modelName;
	private int modelPrice;
	private String modelDetail;

////////////////////////////////////////////////////////////
	
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

////////////////////////////////////////////////////////////
	
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

	@Override
	public String toString() {
		String result = String.format("모델번호: %-4s모델이름: %-12s\t모델가격: %-10s모델설명: %s", this.modelNo, this.modelName,
				this.modelPrice, this.modelDetail);
		// "모델번호: " + this.modelNo + "\t모델이름: " + this.modelName + "\t모델가격: " +
		// this.modelPrice + "\t모델설명: " + this.modelDetail;
		return result;
	}
}