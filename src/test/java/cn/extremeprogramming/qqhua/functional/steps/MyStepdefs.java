package cn.extremeprogramming.qqhua.functional.steps;

import cn.extremeprogramming.qqhua.pages.HomePage;
import io.cucumber.java8.En;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author huisheng.jin
 * @date 2020/10/24.
 */
public class MyStepdefs implements En {


    @Autowired
    HomePage homePage;

    public MyStepdefs() {
        Given("^user opens home page$", () -> {
            homePage.open();
        });
        When("^user uploads picture with message \"([^\"]*)\"$", (String arg0) -> {
        });
        Then("^user sees encoded picture$", () -> {
        });
    }

}
