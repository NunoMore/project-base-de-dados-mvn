package io.altar.jseproject.stateinterface;

public class FSM { //finite state machine
    private State[] states = {new StateMainMenu(), new StateSubMenu()};
    private int[][] transition = {{1, 2}, {1, 2, 3, 4}};
    private int current = 0;

    private void changeState(int msg) {
        current = transition[current][msg];
    }
    
    public void on() {
        states[current].on();
        next(0);
    }

    public void off() {
        states[current].off();
        next(1);
    }
}
