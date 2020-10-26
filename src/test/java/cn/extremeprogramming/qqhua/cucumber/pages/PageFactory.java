package cn.extremeprogramming.qqhua.cucumber.pages;

import cn.extremeprogramming.qqhua.cucumber.driver.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class PageFactory {

    @Bean(name = "homePage")
    @Scope("cucumber-glue")
    public HomePage homePage(Driver driver) {
        return new HomePage(driver);
    }
}
