package roberto.cafagna.U5W1D1.entities;

public class Bevanda extends MenuItem {

    public Bevanda(String name, int calories, double price) {
        super(name, calories, price);
    }

    @Override
    public String toString() {
        return "Bevanda{} " + super.toString();
    }
}
