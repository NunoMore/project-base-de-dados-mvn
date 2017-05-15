package io.altar.jseproject.stateinterface;

import io.altar.jseproject.model.Shelf;

public class State08CreateShelf extends State{
	
	protected int doAction() {

		String entidade = "prateleira";
		Shelf item = new Shelf();
		int option = 1;
	 	
		item = shelfRepository.get(shelfRepository.create(item));
		
		//coloca localizacao 
		System.out.println("\nQual a localizacao da prateleira? (TOP, MID or BOT)");
		String location = item.checkInputLocation();
		item.setLocation(location);

		//coloca capacidade
		System.out.println("\nQual a capacidade da prateleira (produtos)? (valor unitario)");
		int intAux = checkInputInt();
		item.setCapacity(intAux);
		
		//coloca preco de aluguer
		System.out.println("\nQual o preco de aluguer da prateleira (euros)?");
		double doubleAux = checkInputDouble();
		item.setRentPrice(doubleAux);
		
		//coloca product ID
		String msg = "\nQual o ID do produto a colocar na prateleira? (valor unitario)";
		long id = productRepository.checkId(msg);
		item.setProductId(id);
		if (productRepository.has()) {
			productRepository.get(id).addShelfId(item.getId());
		}
		
		shelfRepository.printList(entidade);
		return option-1;
    }
	
	
	
}
