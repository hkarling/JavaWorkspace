package project.view;

import project.model.dto.ProductDTO;

import java.util.List;

public class ResultView {

	public static void printList(List<ProductDTO> list) {
		for(ProductDTO product : list)
			System.out.println(product);
	}
	
	public static void printProduct(ProductDTO product) {
		System.out.println(product);
	}
	public static void printMessage(String message) {
		System.out.println(message);
	}
}
