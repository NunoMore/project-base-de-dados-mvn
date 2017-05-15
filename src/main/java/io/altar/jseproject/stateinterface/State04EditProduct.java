package io.altar.jseproject.stateinterface;

import io.altar.jseproject.model.Product;

public class State04EditProduct extends State{
		
	protected int doAction() {
		
		String entidade = "produto";
		int option = 1;
		
		if (productRepository.has()){
			String msg = "\nQual o ID do(a) "+ entidade + " a editar?";
			long id = productRepository.checkId(msg);
			Product item = productRepository.get(id);
			
			//alterar nome
			System.out.println("\nAlterar nome('"+ item.getName() +"'): ");
			boolean keep = keepValue();

			if (!keep) {
				System.out.println("Introduza o novo nome:");
				item.setName( sc.nextLine() );
			}
			
			//alterar pvp
			System.out.println("\nAlterar PVP("+ item.getPvp() +"euros): ");
			keep = keepValue();
			
			if (!keep) {
				System.out.println("Introduza o novo valor de PVP:");
				item.setPvp( checkInputDouble() );
			}
			
			//alterar iva
			System.out.println("\nAlterar IVA("+ item.getIva() +"%): ");
			keep = keepValue();
			
			if (!keep) {
				System.out.println("Introduza o novo valor de IVA:");
				item.setIva( checkInputDouble() );
			}
			
			//alterar desconto
			System.out.println("\nAlterar desconto("+ item.getDiscount() +"%): ");
			keep = keepValue();
			if (!keep) {
				System.out.println("Introduza o novo valor de desconto:");
				item.setDiscount( checkInputInt() );
			}
		}
		
		productRepository.printList(entidade);
		return option-1;
	}
	
	
}
