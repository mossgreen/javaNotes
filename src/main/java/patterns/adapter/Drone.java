package patterns.adapter;

import java.util.function.DoubleToIntFunction;

public interface Drone {
    public void beep();
    public void spin_rotors();
    public void take_off();
}

class SuperDrone implements Drone {

    @Override
    public void beep() {
        System.out.println("Beep, beep beep");
    }

    @Override
    public void spin_rotors() {
        System.out.println("Rotors are spinning");
    }

    @Override
    public void take_off() {
        System.out.println("Taking off");
    }
}
