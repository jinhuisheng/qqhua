package cn.extremeprogramming.qqhua.pages;

import cn.extremeprogramming.qqhua.driver.Driver;
import org.springframework.beans.factory.annotation.Autowired;

public class HomePage {

    private Driver driver;

    @Autowired
    public HomePage(Driver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.navigateTo("/");
    }

    public void input(String character) {
        driver.inputTextByName(character, "character");
        driver.clickByText("Guess");
    }

}
