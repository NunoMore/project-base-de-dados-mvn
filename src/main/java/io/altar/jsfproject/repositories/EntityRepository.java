package io.altar.jsfproject.repositories;

import java.util.Collection;
import java.util.HashMap;

import io.altar.jseproject.model.Entity;
import io.altar.jseproject.stateinterface.State;

public class EntityRepository <E extends Entity> { //E sera product ou shelf

	private HashMap<Long, E> m1 = new HashMap<>();
	private long maiorId = 0;
	
	public long getMaiorId() {
		return maiorId;
	}
	
	private Long nextId(){ 
		return ++maiorId;
	}

	public E get(long id){
		return this.m1.get(id);
	}
 
	public Long create(E e) {
		e.setId(this.nextId());
		this.m1.put(e.getId(), e);
		return e.getId();
	}
	
	public Collection<E> consult(){ 
		return this.m1.values();
	}
	
	public void consult( long id){
		this.m1.get(id).show();
	}
	
	public void edit(String entidade){ // not used...
	}
	
	public void remove(long Id){
		this.m1.remove(Id);
	}
	
	public long checkId(String message){
		//get id
		long id = 0; //se nao houver id ele retorna 0. 
		if (maiorId != 0) {
			System.out.println(message);
			id = State.checkInputLong();
			
			while(get(id) == null) {
				System.out.println("\nO ID introduzido nao existe..."
									+ "\nEscolha um ID que exista!");
				id = State.checkInputLong();
			}
		}
		return id;
	}
	
	public void printList(String entidade){ //produtos ou prateleiras
		//emite lista de entidades
		if (has()) {
			System.out.println("\nLista de " + entidade + "s:");
			for (long i = 1; i <= maiorId; i++) {
				if (get(i)!=null) {
					get(i).show();
				}
			}
		} else {
			System.out.println("\nNao existe qualquer " + entidade + "!"
								+ "\nDeve criar primeiro!");
		}
	}
	
	public boolean has(){ //produto ou prateleira
		if (consult().size() == 0) {
			return false;
		} else{
			return true;
		}
	}
}