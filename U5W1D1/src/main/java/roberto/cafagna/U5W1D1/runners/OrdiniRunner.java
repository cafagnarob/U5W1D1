package roberto.cafagna.U5W1D1.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import roberto.cafagna.U5W1D1.Enum.StatoOrdine;
import roberto.cafagna.U5W1D1.entities.*;

@Component
public class OrdiniRunner implements CommandLineRunner {

    @Value("${coperto.price}")
    private double costoCoperto;
    @Autowired
    private ApplicationContext ctx;

    @Override
    public void run(String... args) throws Exception {
        try {
            Menu m = (Menu) ctx.getBean("menu");
            m.stampaMenu();

            Tavolo t1 = (Tavolo) ctx.getBean("tavolo1");


            Ordine o1 = new Ordine(1,
                    StatoOrdine.IN_CORSO,
                    2,
                    t1, costoCoperto);

            o1.addElement(ctx.getBean("margheritaPizza", Pizza.class));
            o1.addElement(ctx.getBean("salamiPizza", Pizza.class));
            o1.addElement(ctx.getBean("wine", Bevanda.class));
            o1.addElement(ctx.getBean("water", Bevanda.class));

            System.out.println("DETTAGLI TAVOLO 1");
            System.out.println(o1);

            System.out.println("CONTO TAVOLO 1");
            System.out.println(o1.getTotale());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
}
