package io.altar.jseproject.stateinterface;


public class State01MainMenu extends State{
	
	public int doAction() {
		System.out.println("\nPor favor selecione uma das seguintes opcoes: "
				+ "\n1) Listar produtos"
				+ "\n2) Listar prateleiras"
				+ "\n3) Sair");
		
		int[] validOptions = {1,2,3};
		int option = checkOptions(validOptions);
		return option-1;
    }
}
