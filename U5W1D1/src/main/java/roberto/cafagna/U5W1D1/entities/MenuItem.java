package roberto.cafagna.U5W1D1.entities;

public abstract class MenuItem {
    private int id;
    private String name;
    private int calories;
    private double price;

    public MenuItem(String name, int calories, double price) {
        this.name = name;
        this.calories = calories;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCalories() {
        return calories;
    }

    @Override
    public String toString() {
        return "MenuItem{ \n" +
                "id=" + id + "\n" +
                ", name='" + name + "\n" +
                ", calories=" + calories + "\n" +
                ", price=" + price + "\n" +
                "} \n";
    }
}
