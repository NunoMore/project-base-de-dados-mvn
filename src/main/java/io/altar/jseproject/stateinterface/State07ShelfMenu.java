package io.altar.jseproject.stateinterface;

public class State07ShelfMenu extends State{ //Sub menu
	
	protected int doAction() {
		
		String entidade = "prateleira";
		
		System.out.println("\nPor favor selecione uma das seguintes opcoes: \n"
				+ "1) Criar novo(a) "+ entidade +" \n"
				+ "2) Editar um(a) "+ entidade +" existente \n"
				+ "3) Consultar o detalhe de um(a) "+ entidade + " \n"
				+ "4) Remover um(a) "+ entidade + " \n" 
				+ "5) Voltar ao ecra anterior");
		
		int[] validOptions = {1,2,3,4,5};
		int option = checkOptions(validOptions);
		return option-1;
    }
}
