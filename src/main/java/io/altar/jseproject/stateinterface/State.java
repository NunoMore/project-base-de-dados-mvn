package io.altar.jseproject.stateinterface;

import java.util.Scanner;

import io.altar.jseproject.repositories.ProductRepository;
import io.altar.jseproject.repositories.ShelfRepository;

public abstract class State {
	
	public static Scanner sc = new Scanner(System.in);
	protected static ShelfRepository shelfRepository = ShelfRepository.getInstance();
	protected static ProductRepository productRepository = ProductRepository.getInstance();
	
	protected int doAction() {
        System.out.println("error");
        return 0;
    }
	
	protected int checkOptions(int[] options){
		int input;
		while(true){
			input = checkInputInt();
			for (int i = 0; i < options.length; i++) {
				if (options[i]==input) {
					return input;
				}
			}
			System.out.println("Escolha uma opcao valida!");
			System.out.println("\nAs opcoes validas sao: ");
			for (int i = 0; i < options.length; i++) {
				System.out.println(options[i]); 
			}
		}
	}
	
	public static int checkInputInt(){
		
		while(!sc.hasNextInt()){
			System.out.println("\nInput is not a valid number!");
			sc.next();
		}
		int number = sc.nextInt();
		return number;
	}
	
	public static long checkInputLong(){
		
		while(!sc.hasNextLong()){
			System.out.println("\nInput is not a valid number!");
			sc.next();
		}
		long number = sc.nextLong();
		return number;
	}
	
	public static double checkInputDouble(){
		
		while(!sc.hasNextDouble()){
			System.out.println("\nInput is not a valid number!");
			sc.next();
		}
		double number = sc.nextDouble();
		return number;
	}
	
	public static boolean keepValue(){
		
		System.out.println("Deseja REMOVER? (s-sim / n-nao)");
		String yesORno = sc.next();
		
		while (!yesORno.equals("s") && !yesORno.equals("n")) {
			System.out.println("Por favor, ecreva 's' ou 'n' para REMOVER(ou nao)!");
			yesORno = sc.next();
		}
		
		boolean keep = false;
		if (yesORno.equals("n")) {
			System.out.println("Nao houve remocao!");
			keep = true;
		}
		
		return keep;
	}
}
