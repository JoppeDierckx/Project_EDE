package fact.it.startproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class startprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(startprojectApplication.class, args);
    }

}
