package roberto.cafagna.U5W1D1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import roberto.cafagna.U5W1D1.entities.Menu;

@SpringBootApplication
public class U5W1D1Application {

    public static void main(String[] args) {
        SpringApplication.run(U5W1D1Application.class, args);

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(U5W1D1Application.class);
        Menu menu = ctx.getBean(Menu.class);
        System.out.println(menu);

    }

}
