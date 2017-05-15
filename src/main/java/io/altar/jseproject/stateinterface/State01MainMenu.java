package io.altar.jseproject.stateinterface;


public class State01MainMenu extends State{
	
	public int doAction() {
		System.out.println("\nPor favor selecione uma das seguintes opcoes: "
				+ "\n1) Listar produtos"
				+ "\n2) Listar prateleiras"
				+ "\n3) Sair");
		
		int[] validOptions = {1,2,3};
		int option = checkOptions(validOptions);
		
		if (option == 1) {
			productRepository.printList("produto");
		} else if (option == 2) {
			shelfRepository.printList("prateleira");
		}
		
		return option-1;
    }
}
