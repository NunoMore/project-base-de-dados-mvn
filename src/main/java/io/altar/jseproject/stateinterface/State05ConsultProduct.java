package io.altar.jseproject.stateinterface;


public class State05ConsultProduct extends State{
		
	protected int doAction() {
		
		String entidade = "produto";
		int option = 1;
		
		if (productRepository.has()){
			String msg = "\nQual o ID do(a) "+ entidade +" a consultar?";
			long id = productRepository.checkId(msg);
			productRepository.consult(id);
		} else{
			System.out.println("Nao existem produtos!");
		}
		return option-1;
	}	
}
