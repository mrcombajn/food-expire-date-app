/**
 * pl.expiredateapp is a main package of Food Expire Date Application.
 */
package pl.expiredateapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class.
 */
@SpringBootApplication
public class FoodExpireDateApplication {

    /**
     * Main application method.
     * @param args Args to run spring context.
     */
    public static void main(final String[] args) {
        SpringApplication.run(FoodExpireDateApplication.class, args);
    }

}