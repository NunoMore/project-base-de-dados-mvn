package io.altar.jseproject.stateinterface;

import io.altar.jseproject.model.Entity;

public class StateMainMenu extends State{
	
	private int[] options = {1,2,3};
	
	protected void on() {

		String entidade = "";

		System.out.println("\nPor favor selecione uma das seguintes opcoes: "
				+ "\n1) Listar produtos"
				+ "\n2) Listar prateleiras"
				+ "\n3) Sair");
		
		int option = checkOptions(options);
	
		switch (option){
		
			case 1: //Listar produtos
				
				entidade = "produto";
				productRepository.has(entidade);
				productRepository.printList(entidade);
				
				FSM.changeState(option);
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

	protected void off() {
        System.out.println("error");
    }
	
}
