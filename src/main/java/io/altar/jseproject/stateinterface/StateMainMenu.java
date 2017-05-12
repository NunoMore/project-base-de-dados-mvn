package io.altar.jseproject.stateinterface;

import io.altar.jseproject.model.Entity;

public class StateMainMenu extends State{
	
	protected void on() {

		String entidade = "";
		
		Boolean run = true;
		while( run ){

			System.out.println("\nPor favor selecione uma das seguintes opcoes: "
					+ "\n1) Listar produtos"
					+ "\n2) Listar prateleiras"
					+ "\n3) Sair");
			
			int option = Entity.checkInputInt();
		
			switch (option){
			
				case 1: //Listar produtos
					
					entidade = "produto";
					productRepository.has(entidade);
					productRepository.printList(entidade);
					
					subMenu(productRepository, entidade);  
					break;
						
				case 2: //Listar prateleiras

					entidade = "prateleira";
					shelfRepository.has(entidade);
					shelfRepository.printList(entidade);
					
					subMenu(shelfRepository, entidade); 
					break;
					
				case 3: //Sair
					
					System.out.println("\nGood bye!");
					run = false;
					break;
						
				default: 
					System.out.println("\nInvalid input."
										+ "\n\nChoose a valid option!");
					break; 
			}
		}
    }

	protected void off() {
        System.out.println("error");
    }
	
}
