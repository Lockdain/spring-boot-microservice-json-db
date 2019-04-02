package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"controller", "dao", "entity"})
public class SpringBootTomcatApplication /*extends SpringBootServletInitializer*/ {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTomcatApplication.class, args);
    }
}
