package roberto.cafagna.U5W1D1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import roberto.cafagna.U5W1D1.Enum.StatoOrdine;
import roberto.cafagna.U5W1D1.Enum.StatoTavolo;
import roberto.cafagna.U5W1D1.entities.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class U5W1D1ApplicationTests {
    @Autowired
    private ApplicationContext ctx;
    @Value("${coperto.price}")
    private double costoCoperto;


    @Test
    @DisplayName("TEST BEAN: i beans sono configurati correttamente?")
    void testBean() {
        Pizza margherita = (Pizza) ctx.getBean("margheritaPizza");
        Bevanda water = (Bevanda) ctx.getBean("water");
        Topping ham = (Topping) ctx.getBean("ham");

        assertNotNull(margherita);
        assertNotNull(water);
        assertNotNull(ham);

        assertEquals("Pizza Margherita", margherita.getName());
        assertEquals(4.99, margherita.getPrice(), 0.01);

        assertEquals("Water(0.5l)", water.getName());
        assertEquals(1.29, water.getPrice(), 0.01);

        assertEquals(2.0, costoCoperto, 0.01);
    }

    @Test
    @DisplayName("TEST CREAZIONE PIZZA: ogni pizza creata ha pomodoro e mozzarella?")
    void testCreationPizza() {
        Pizza pTest = new Pizza("test_pizza", 9999, 99.999);
        List<Topping> toppingList = pTest.getListaTopping();
        assertTrue(toppingList.stream().anyMatch(topping -> topping.getName().equalsIgnoreCase("tomato")));
        assertTrue(toppingList.stream().anyMatch(topping -> topping.getName().equalsIgnoreCase("cheese")));
    }

    @Test
    @DisplayName("TEST AGGIORNAMENTO LISTA TOPPING: aggiungendo un Topping la Lista si modifica?")
    void testUpdateToppingList() {
        Pizza pizzaTest = new Pizza("TEST Pizza", 999, 99.999);
        Topping toppingTest = (Topping) ctx.getBean("salami");
        int sizePizzaToppingListBeforeAdd = pizzaTest.getListaTopping().size();
        pizzaTest.getListaTopping().add(toppingTest);
        int sizePizzaToppingListAfterAdd = pizzaTest.getListaTopping().size();
        assertEquals(2, sizePizzaToppingListBeforeAdd);
        assertEquals(3, sizePizzaToppingListAfterAdd);
    }

    @Test
    @DisplayName("TEST GET TOTALE: calcola correttamente prezzo prodotti + coperti?")
    void testGetTotale() {
        Tavolo testT = new Tavolo(99, 99, StatoTavolo.LIBERO);
        Ordine testO = new Ordine(1, StatoOrdine.SERVITO, 3, testT, costoCoperto);
        testO.addElement((MenuItem) ctx.getBean("margheritaPizza"));
        // prezzo 4.99
        testO.addElement((MenuItem) ctx.getBean("salamiPizza"));
        // prezzo 5.99
        testO.addElement((MenuItem) ctx.getBean("water"));
        // prezzo 1.29
        // coperti 3 * 2 = 6
        //totale 18.27
        assertEquals(18.27, testO.getTotale(), 0.01);
    }

    @ParameterizedTest
    @DisplayName("TEST PARAMETRICO GET TOTALE: calcola correttamente prezzo prodotti + coperti?")
    @CsvSource({"1, 14.27", "2, 16.27", "3, 18.27", "4, 20.27"})
    void test2GetTotale(int numCoperto, double prezzoTotale) {
        Tavolo testT = new Tavolo(99, 99, StatoTavolo.LIBERO);
        Ordine testO = new Ordine(1, StatoOrdine.SERVITO, numCoperto, testT, costoCoperto);
        testO.addElement((MenuItem) ctx.getBean("margheritaPizza"));
        // prezzo 4.99
        testO.addElement((MenuItem) ctx.getBean("salamiPizza"));
        // prezzo 5.99
        testO.addElement((MenuItem) ctx.getBean("water"));
        // prezzo 1.29
        //totale 12.27
        assertEquals(prezzoTotale, testO.getTotale(), 0.01);
    }


    @Test
    void contextLoads() {
    }

}
