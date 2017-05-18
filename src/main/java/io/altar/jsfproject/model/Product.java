package io.altar.jsfproject.model;

import java.util.ArrayList;

public class Product extends Entity{
	private String name;
	private ArrayList<Long> shelfId = new ArrayList<>();
	private long maiorShelfId = 0;
	private int discount;
	private double iva;
	private double pvp;
	
	public void show(){
		System.out.println("Produto " + this.getId() + ": (nome) " + 
				this.getName() +", (PVP) " + 
				this.getPvp() +"euros, (IVA)" + 
				this.getIva() +"%, (desconto) " + 
				this.getDiscount() +"%.");
		
		if (this.shelfId.size()>0) {
			System.out.println("Este produto encontra-se em: ");
			for (long i = 0; i <= maiorShelfId; i++) {
				if (shelfId.contains(i)) {
					System.out.println("Prateleira - " + i);
				}
			}
		} else if (shelfId.size()==0) {
			System.out.println("Este produto nao se encontra em nenhuma prateleira!");
		}
	}
	
	public ArrayList<Long> getShelfId() {
		return shelfId;
	}
	public long getMaiorShelfId() {
		return maiorShelfId;
	}

	public void addShelfId(long id){
		shelfId.add(id);
		maiorShelfId++;
	}
	public void removeShelfId(long id){
		shelfId.remove(id);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public double getIva() {
		return iva;
	}
	public void setIva(double iva) {
		this.iva = iva;
	}
	public double getPvp() {
		return pvp;
	}
	public void setPvp(double pvp) {
		this.pvp = pvp;
	}	
}
