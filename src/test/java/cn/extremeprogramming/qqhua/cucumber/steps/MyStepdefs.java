package cn.extremeprogramming.qqhua.cucumber.steps;

import cn.extremeprogramming.qqhua.cucumber.pages.HomePage;
import io.cucumber.java8.En;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

/**
 * @author huisheng.jin
 * @date 2020/10/24.
 */
public class MyStepdefs implements En {

    @Autowired
    HomePage homePage;

    public MyStepdefs() {
        Given("user opens home page", this::openHomePage);

        Then("user see two forms with one encrypt and one decrypt form", this::openHomePage);

        Then("user sees encoded picture", () -> {
            assertThat(homePage.existEncodedImage()).isTrue();
        });

        When("user uploads encoded picture {string}", (String encodedImagePath) -> {
            homePage.submitImageFile(encodedImagePath);
        });

        Then("user sees decoded message {string}", (String expectedMessage) -> {
            assertThat(homePage.getDecryptedMessage()).isEqualTo(expectedMessage);
        });

        When("user uploads picture with message {string} and file {string}", (String message, String imagePath) -> {
            homePage.submitMessageAndImageFile(message, imagePath);
        });
    }

    private void openHomePage() {
        homePage.open();
    }

}
