package io.altar.jseproject.stateinterface;

public class FSM { //finite state machine
	private static State[] states = {	new State01MainMenu(), 			//0
    									new State02ProductMenu(), 		//1
    									new State03CreateProduct(),			//2
    									new State04EditProduct(),			//3
    									new State05ConsultProduct(),		//4
    									new State06RemoveProduct(),			//5
    									new State07ShelfMenu(), 		//6
    									new State08CreateShelf(),			//7
    									new State09EditShelf(),				//8
    									new State10ConsultShelf(),			//9
    									new State11RemoveShelf(),			//10
    								};
	
    private static Integer[][] transition = {	{1, 6, null},  			//0 
		    									{2, 3, 4, 5, 0}, 		//1
    											{1} ,{1}, {1}, {1},			//2, 3, 4, 5
    											{7, 8, 9, 10, 0}, 		//6
    											{6} ,{6}, {6}, {6}			//7, 8, 9, 10
		    								};
    
    private static int currentState;

    public static void changeState(int nextState) {
    	if (transition[currentState][nextState] == null) {
			off();
		} else {
	    	currentState = transition[currentState][nextState];
	    	int next = states[currentState].doAction();
	    	changeState(next);
		}
    }
    
    public static void on() {
    	currentState = 0;
    	int next = states[currentState].doAction();
    	changeState(next);
    }
    
    public static void off(){
    	System.out.println("Bye!");
    	System.exit(0);
    }
}
