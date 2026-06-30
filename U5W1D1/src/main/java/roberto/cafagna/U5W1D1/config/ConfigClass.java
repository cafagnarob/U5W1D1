package roberto.cafagna.U5W1D1.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import roberto.cafagna.U5W1D1.Enum.StatoOrdine;
import roberto.cafagna.U5W1D1.Enum.StatoTavolo;
import roberto.cafagna.U5W1D1.entities.*;

import java.time.LocalTime;
import java.util.List;

@Configuration
public class ConfigClass {

    @Bean
    public Topping ham() {
        return new Topping("Ham", 35, 0.99);
    }

    @Bean
    public Topping tomato() {
        return new Topping("Tomato", 85, 0.99);
    }

    @Bean
    public Topping pineapple() {
        return new Topping("Pineapple", 24, 0.79);
    }

    @Bean
    public Topping cheese() {
        return new Topping("Cheese", 92, 0.69);
    }

    @Bean
    public Topping onions() {
        return new Topping("Onions", 22, 0.69);
    }

    @Bean
    public Topping salami() {
        return new Topping("Salami", 86, 0.99);
    }


    @Bean
    public Bevanda lemonade() {
        return new Bevanda("Lemonade(0.33l)", 128, 1.29);
    }

    @Bean
    public Bevanda water() {
        return new Bevanda("Water(0.5l)", 0, 1.29);
    }

    @Bean
    public Bevanda wine() {
        return new Bevanda("Wine(0.75l)", 607, 7.49);
    }

    @Bean
    public Pizza margheritaPizza() {
        return new Pizza("Pizza Margherita", 1104, 4.99);
    }

    @Bean
    public Pizza hawaiianPizza() {
        Pizza p = new Pizza(
                "Hawaiian Pizza",
                1024,
                6.49);
        p.getListaTopping().add(pineapple());
        p.getListaTopping().add(ham());
        return p;
    }

    @Bean
    public Pizza salamiPizza() {
        Pizza p = new Pizza("Salami Pizza", 1160, 5.99);
        p.getListaTopping().add(salami());
        return p;
    }


    @Bean
    public Menu menu() {
        return new Menu(
                List.of(margheritaPizza(), hawaiianPizza(), salamiPizza()),
                List.of(lemonade(), water(), wine()),
                List.of(cheese(), ham(), onions(), pineapple(), salami(), tomato())
        );
    }

    @Bean
    public Tavolo tavolo1() {
        return new Tavolo(1, 10, StatoTavolo.LIBERO);
    }


    @Bean
    public Ordine ordine(@Value("${coperto.price}") double costoCoperto, Tavolo tavolo) {
        return new Ordine(1,
                StatoOrdine.IN_CORSO,
                2,
                LocalTime.now(),
                tavolo,
                List.of(margheritaPizza(), water()),
                costoCoperto);
    }

}
