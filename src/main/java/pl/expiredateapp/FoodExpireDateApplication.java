package pl.expiredateapp;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class.
 */
@SpringBootApplication
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FoodExpireDateApplication {

    /**
     * Main application method.
     * @param args Args to run spring context.
     */
    public static void main(final String[] args) {
        SpringApplication.run(FoodExpireDateApplication.class, args);
    }

}