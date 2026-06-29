package roberto.cafagna.U5W1D1.entities;

import java.util.List;

public class Menu {
    private int id;
    private List<Pizza> menuPizze;
    private List<Bevanda> menuBevande;
    private List<Topping> menuTopping;


    public Menu(List<Pizza> menuPizze, List<Bevanda> menuBevande, List<Topping> menuTopping) {
        this.menuPizze = menuPizze;
        this.menuTopping = menuTopping;
        this.menuBevande = menuBevande;
    }

    public List<Bevanda> getMenuBevande() {
        return menuBevande;
    }

    public void setMenuBevande(List<Bevanda> menuBevande) {
        this.menuBevande = menuBevande;
    }

    public List<Pizza> getMenuPizze() {
        return menuPizze;
    }

    public void setMenuPizze(List<Pizza> menuPizze) {
        this.menuPizze = menuPizze;
    }

    public List<Topping> getMenuTopping() {
        return menuTopping;
    }

    public void setMenuTopping(List<Topping> menuTopping) {
        this.menuTopping = menuTopping;
    }

    @Override
    public String toString() {
        return "Menu{\n" +
                "menuPizze=" + menuPizze + "\n" +
                ", menuBevande=" + menuBevande + "\n" +
                ", menuTopping=" + menuTopping + "\n" +
                "} \n";
    }
}

