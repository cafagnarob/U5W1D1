package roberto.cafagna.U5W1D1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import roberto.cafagna.U5W1D1.entities.Menu;
import roberto.cafagna.U5W1D1.entities.Ordine;

@SpringBootApplication
public class U5W1D1Application {

    private static final Logger logger =
            LoggerFactory.getLogger(U5W1D1Application.class);

    public static void main(String[] args) {
        SpringApplication.run(U5W1D1Application.class, args);
    }

    @Bean
    public CommandLineRunner run(Menu menu,
                                 @Qualifier("ordine1") Ordine ordine1,
                                 @Qualifier("ordine2") Ordine ordine2) {
        return args -> {
            logger.info(menu.toString());
            logger.info(ordine2.toString());
            logger.info(ordine1.toString());
        };
    }
}
