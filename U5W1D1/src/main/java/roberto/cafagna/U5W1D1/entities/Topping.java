package roberto.cafagna.U5W1D1.entities;

public class Topping extends MenuItem {

    public Topping(String name, int calories, double price) {
        super(name, calories, price);
    }

    @Override
    public String toString() {
        return "Topping{} " + super.toString();
    }
}
