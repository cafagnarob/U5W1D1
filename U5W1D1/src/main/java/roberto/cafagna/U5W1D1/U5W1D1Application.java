package roberto.cafagna.U5W1D1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    public CommandLineRunner run(Menu menu, Ordine ordine) {
        return args -> {
            logger.info(menu.toString());
            logger.info(ordine.toString());
        };
    }
}
