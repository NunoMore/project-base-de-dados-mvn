package io.altar.jseproject.stateinterface;

import io.altar.jseproject.model.Product;

public class State03CreateProduct extends State{
	
	protected int doAction() {

		String entidade = "produto";
		Product item = new Product();
		int option = 1;
	 	
		item = productRepository.get(productRepository.create(item));
		
		//coloca nome
		System.out.println("\nQual o nome do produto?");
		String productName = sc.next();
		item.setName(productName);
				
		//coloca desconto
		System.out.println("\nQual o desconto do produto (%)? (valor unitario em percentagem)");
		int intAux = checkInputInt();
		item.setDiscount(intAux);
		
		//coloca iva
		System.out.println("\nQual o IVA do produto(%)?");
		double doubleAux = checkInputDouble();
		item.setIva(doubleAux);
		
		//coloca pvp
		System.out.println("\nQual o PVP do produto(euros)?");
		doubleAux = checkInputDouble();
		item.setPvp(doubleAux);
		
		productRepository.printList(entidade);
		return option-1;
    }
	
}
