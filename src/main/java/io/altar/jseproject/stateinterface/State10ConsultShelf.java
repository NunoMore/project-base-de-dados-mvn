package io.altar.jseproject.stateinterface;

public class State10ConsultShelf extends State{
		
	protected int doAction() {
		
		String entidade = "prateleira";
		int option = 1;
		
		if (shelfRepository.has()){
			String msg = "\nQual o ID do(a) "+ entidade +" a consultar?";
			long id = shelfRepository.checkId(msg);
			shelfRepository.consult(id);
		} else{
			System.out.println("Nao existem prateleiras!");
		}
		return option-1;
	}	
}
