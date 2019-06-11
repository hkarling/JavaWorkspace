package project.model.dto;

public class ProductDTO {

	private int productNo; // 제품번호
	private String name; // 제품명
	private String category; // 분류
	private int price; // 가격
	private int quantity; // 수량
	
	public ProductDTO() {
		
	}
	
	public ProductDTO(int productNo, String name, String category, int price, int quantity) {
		super();
		this.productNo = productNo;
		this.name = name;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
	}

	public int getProductNo() {
		return productNo;
	}


	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}


	public String getProductName() {
		return name;
	}


	public void setProductName(String name) {
		this.name = name;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	@Override
	public String toString() {
		return productNo + " | " + name + " | " + category + " | " + price + " | " + quantity;
	}
}
