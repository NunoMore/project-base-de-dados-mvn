package io.altar.jseproject.stateinterface;

import io.altar.jseproject.model.Shelf;

public class State09EditShelf extends State{
		
	protected int doAction() {
		
		String entidade = "prateleira";
		int option = 1;
		
		if (shelfRepository.has()){
			String msg = "\nQual o ID do(a) "+ entidade + " a editar?";
			long id = shelfRepository.checkId(msg);
			Shelf item = shelfRepository.get(id);
			
			//alterar localizacao //podera ser alterado por nao ser um int ???
			System.out.println("\nAlterar codigo de localizacao("+ item.getLocation() +"): ");
			boolean keep = keepValue();

			if (!keep) {
				System.out.println("Introduza nova localizacao:");
				String location = item.checkInputLocation();
				item.setLocation(location);
			}		
			
			//alterar capacidade
			System.out.println("\nAlterar capacidade("+ item.getCapacity() +"): ");
			keep = keepValue();
			
			if (!keep) {
				System.out.println("Introduza o novo valor de capacidade:");
				item.setCapacity(checkInputInt());
			}
			
			//alterar preco de aluguer
			System.out.println("\nAlterar preco de aluguer("+ item.getRentPrice() +"euros): ");
			
			keep = keepValue();
			if (!keep) {
				System.out.println("Introduza o novo preco de aluguer:");
				item.setRentPrice(checkInputDouble());
			}
			
			//alterar produto
			if (productRepository.has()) { 
				System.out.println("\nAlterar produto existente(Produto "+ item.getProductId() +"): ");
				 
				keep = keepValue();
				if (!keep) {
					if (item.getProductId()!=0) {
						productRepository.get( item.getProductId() ).removeShelfId(item.getId());
					}
					msg = "Introduza o ID do novo produto para a prateleira:";
					id = productRepository.checkId(msg);
					item.setProductId(id);
					productRepository.get(id).addShelfId(id); 
				}
			} else {
				System.out.println("\nNao existem produtos! - 0");
			}
			
		} else{
			System.out.println("Nao existem prateleiras!");
		}
		
		shelfRepository.printList(entidade);
		return option-1;
	}
	
	
}
