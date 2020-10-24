package cn.extremeprogramming.qqhua.functional.steps;

import io.cucumber.java8.En;

/**
 * @author huisheng.jin
 * @date 2020/10/24.
 */
public class MyStepdefs implements En {
    public MyStepdefs() {
        Given("^user opens home page$", () -> {
        });
        When("^user uploads picture with message \"([^\"]*)\"$", (String arg0) -> {
        });
        Then("^user sees encoded picture$", () -> {
        });
    }
}
