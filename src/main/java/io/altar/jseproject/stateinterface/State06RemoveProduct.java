package io.altar.jseproject.stateinterface;


public class State06RemoveProduct extends State{
		
	protected int doAction() {
			
		String entidade = "produto";
		int option = 1;

		if (productRepository.has()){
			String msg = "\nQual o ID do(a) "+ entidade +" a remover?";
			long Id = productRepository.checkId(msg);
			
			boolean keep = State.keepValue();
			if (!keep) {
				System.out.println("\nHouve remocao!");
				productRepository.remove(Id);
			}else {
				System.out.println("\nOperacao anulada!");
			}
		}
		
		productRepository.printList(entidade);
		return option-1;
	}
}
