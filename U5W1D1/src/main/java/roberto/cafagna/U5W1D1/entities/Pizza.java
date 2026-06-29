package roberto.cafagna.U5W1D1.entities;

import java.util.ArrayList;
import java.util.List;

public class Pizza extends MenuItem {
    private List<Topping> listaTopping;

    public Pizza(String name, int calories, double price) {
        super(name, calories, price);
        this.listaTopping = new ArrayList<>();
        this.listaTopping.add(new Topping("Tomato", 85, 0.99));
        this.listaTopping.add(new Topping("Cheese", 92, 0.69));
    }

    public List<Topping> getListaTopping() {
        return listaTopping;
    }

    @Override
    public String toString() {
        String toppings = "";

        for (Topping topping : listaTopping) {
            toppings += topping.getName() + ", ";
        }

        if (!toppings.isEmpty()) {
            toppings = toppings.substring(0, toppings.length() - 2);
        }

        return "Pizza: " + getName() + "\n" +
                "Toppings: " + toppings + "\n" +
                "Calories: " + getCalories() + "\n" +
                "Price: €" + getPrice() + "\n";
    }
}
