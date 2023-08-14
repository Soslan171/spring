package app.config;

import app.model.AnimalsCage;
import app.model.Dog;
import app.model.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "app")
public class AppConfig {
    @Autowired
    private Dog dog;

    @Autowired
    private AnimalsCage animalCage;
    @Autowired
    private Timer timer;

}
