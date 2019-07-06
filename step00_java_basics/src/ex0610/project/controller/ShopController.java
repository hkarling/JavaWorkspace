package ex0610.project.controller;

import java.sql.SQLException;
import java.util.List;

import ex0610.project.model.dto.ProductDTO;
import ex0610.project.model.service.ShopService;
import ex0610.project.model.service.ShopServiceImpl;
import ex0610.project.view.ResultView;

public class ShopController {

	ShopService service = new ShopServiceImpl();
	
	public void displayAll() {
//		System.out.println("전부출력");
		try {
			List<ProductDTO> list = service.getSelectAll();
			ResultView.printList(list);
		} catch (SQLException e) {
			e.printStackTrace();
			ResultView.printMessage(e.getMessage());
		}
		
	}
	
	public void selectProductByName(String name) {
//		System.out.println("이름으로 찾기 ");
		try {
			ProductDTO product = service.selectByName(name);
			ResultView.printProduct(product);
		} catch(SQLException e) {
			ResultView.printMessage(e.getMessage());
		}
		
	}
	
	public void updateQuantity(int id, int quantity) {
//		System.out.println("수량 수정하기");
		try {
			ProductDTO product = new ProductDTO(id, null, null, 0, quantity);
			service.productUpdate(product);
			ResultView.printMessage("상품 수량을 수정하였습니다.");
			this.displayAll();
		} catch(SQLException e) {
			ResultView.printMessage(e.getMessage());
		}
	}
	
	public void deleteProduct(int id) {
//		System.out.println("제품삭제하기");
		try {
			service.productDelete(id);
			ResultView.printMessage("상품을 삭제하였습니다.");
			this.displayAll();
		} catch(SQLException e) {
			ResultView.printMessage(e.getMessage());
		}
	}
}
