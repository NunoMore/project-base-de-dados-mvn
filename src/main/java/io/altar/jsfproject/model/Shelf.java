package io.altar.jsfproject.model;


import io.altar.jseproject.stateinterface.State;

public class Shelf extends Entity{
	
	private enum Location{TOP, MID, BOT};
	private String location;
	private int capacity;
	private long productId;
	private double rentPrice;
	
	public void show() {
		System.out.println("Prateleira " + this.getId() + ": (localizacao) " + 
				this.getLocation() +", (capacidade) " + 
				this.getCapacity() +", (id de produto exposto) " + 
				this.getProductId() +", (preco de aluguer) " + 
				this.getRentPrice() +"euros.");
	}
	
	public String checkInputLocation(){
		while (true){
			String location = State.sc.next();
			location = location.trim().toUpperCase();
			if (location.equals(Location.TOP.toString()) || location.equals(Location.MID.toString()) || location.equals(Location.BOT.toString())) {
				return location;
			} else{
				System.out.println("Location not valid!");
			}
		}
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public double getRentPrice() {
		return rentPrice;
	}
	public void setRentPrice(double rentPrice) {
		this.rentPrice = rentPrice;
	}
}
