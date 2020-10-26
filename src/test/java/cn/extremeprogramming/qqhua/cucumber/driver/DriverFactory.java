package cn.extremeprogramming.qqhua.cucumber.driver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DriverFactory {

    @Bean(name = "driver", destroyMethod = "close")
    public Driver driver() {
        return new Driver();
    }
}
