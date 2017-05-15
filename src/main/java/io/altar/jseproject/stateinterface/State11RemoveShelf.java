package io.altar.jseproject.stateinterface;


public class State11RemoveShelf extends State{
		
	protected int doAction() {
			
		String entidade = "prateleira";
		int option = 1;

		if (shelfRepository.has()){
			String msg = "\nQual o ID do(a) "+ entidade +" a remover?";
			long Id = shelfRepository.checkId(msg);
			
			boolean keep = State.keepValue();
			if (!keep) {
				System.out.println("\nHouve remocao!");
				shelfRepository.remove(Id);
			}else {
				System.out.println("\nOperacao anulada!");
			}
		} else{
			System.out.println("Nao existem prateleiras!");
		}
		
		shelfRepository.printList(entidade);
		return option-1;
	}
}
